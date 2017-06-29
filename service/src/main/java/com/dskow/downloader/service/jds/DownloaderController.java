package com.dskow.downloader.service.jds;

import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.oxm.XmlMappingException;
import org.springframework.util.StringUtils;

import com.dskow.downloader.jdd.client.ApiException;
import com.dskow.downloader.models.client.ResultC;
import com.dskow.downloader.models.mongo.PubmedArticle;
import com.dskow.downloader.models.mongo.QueryInfo;
import com.dskow.downloader.models.service.PubmedArticleEntity;
import com.dskow.downloader.models.service.QueryInfoEntity;
import com.dskow.downloader.models.service.QueryInfoEntity.StatusEnum;
import com.dskow.downloader.models.xml.PubmedArticleSet;

public class DownloaderController {

	// Define a static LOGGER variable so that it references the
	// Logger instance named "DownloaderController".
	private static final Logger LOGGER = LogManager.getLogger(DownloaderController.class);

	private static final String BASE_URI = "http://eutils.ncbi.nlm.nih.gov/entrez/eutils/";
	// private static final int MAX_REQUEST_PER_SEC = 3;

	// limit large jobs to either weekends or between 9:00 PM and 5:00 AM
	// Eastern
	// time during weekdays
	// Failure to comply with this policy may result in an IP address being
	// blocked from accessing NCBI.
	// developers of the software accessing the E-utilities register values of
	// the
	// tool and email parameters with NCBI
	// private static Calendar startTime = Calendar.getInstance();
	// private static Calendar endTime = Calendar.getInstance();
	private static final TimeZone EASTERNTIMEZONE = TimeZone.getTimeZone("America/New_York");
	// private static final String tool = "SecurborationDownloader";
	// The value of email will be used only to contact developers if NCBI
	// observes
	// requests that violate our policies, and we will attempt such contact
	// prior
	// to blocking access.
	// To register tool and email values, simply send an e-mail to
	// eutilities@ncbi.nlm.nih.gov including the desired values along with the
	// name of either a developer or the organization creating the software.
	// private static final String email = "dskowronski@dskow.com";
	//
	// private static final String ncbiCopyRightURI =
	// "http://www.ncbi.nlm.nih.gov/About/disclaimer.html";

	// If you wish to do a large data mining project on PubMed data, you can
	// enter
	// into a licensing agreement and lease the data for free from NLM. For more
	// information on this please see
	// http://www.nlm.nih.gov/databases/leased.html.

	// If a space is required, use a plus sign (+) instead of a space
	// private static final String SPACE = "+";
	// private static final String JOURNAL_TYPE = "%5bjournal%5d";
	// private static final String PUBLISH_DATE_TYPE = "%5bpdat%5d";
	// private static final String RESTART = "restart=";
	private static final String USE_HISTORY = "usehistory=";
	private static final String TERM = "term=";

	private final int corePoolSize = 1;
	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(corePoolSize);
	private final long period = 6 * 60 * 60; // every 6 hours
	public ScheduledFuture<?> generatorHandler = null;
	private static boolean jdsRunning = false;
	JournalDocDownloaderService jds = null;

	// Other special characters, should be URL encoded.

	public DownloaderController(JournalDocDownloaderService journalDocDownloaderService) {
		jds = journalDocDownloaderService;
		LOGGER.debug("construct a Downloader");
	}

	public void requestStart() {
		final Runnable command = new Runnable() {
			private int retStart = 0;
			private int retMax = 20;

			@Override
			public void run() {
				boolean isRunning = true;
				try {
					if (DownloaderController.jdsRunning) {
						LOGGER.warn("previous request is still running");
						return;
					}

					LOGGER.debug("DownloaderController request is starting");
					DownloaderController.jdsRunning = true;
					if (canDownload()) {
						List<QueryInfo> list = jds.queryRepo.findByStatus(StatusEnum.QUEUED.name());
						if (list != null) {
							LOGGER.debug("number of fetch queries" + list.size());
							for (QueryInfo qi : list) {
								String db = qi.getDatabase();
								String id = qi.getId();
								String retmode = qi.getRetmode();
								String rettype = qi.getRettype();
								String tool = qi.getTool();
								String email = qi.getEmail();
								LOGGER.debug("fetching documents id=" + id);
								String term = qi.getTerm();
								ResultC result = jds.getJddClient().jddSearchUsingPOST(db, term,
										Integer.valueOf(retStart).toString(), Integer.valueOf(retMax).toString(),
										retmode, tool, email);
								LOGGER.debug("resultstr=" + result);
								if (result.getEsearchresult() == null) {
									continue;
								}
								int count = Integer.valueOf(result.getEsearchresult().getCount());
								for (int i = Integer.valueOf(retStart); i < count; i += Integer.valueOf(retMax)) {
									result = jds.getJddClient().jddSearchUsingPOST(db, term,
											Integer.valueOf(i).toString(), Integer.valueOf(retMax).toString(), retmode,
											tool, email);
									PubmedArticleSet fetchList = null;
									String fetchListString = "";
									try {
										String idList = StringUtils.collectionToCommaDelimitedString(
												result.getEsearchresult().getIdlist());
										fetchListString = jds.getJddClient().jddEFetchUsingGET(db, idList,
												rettype, "XML", tool, email);
										fetchListString = fetchListString.substring(fetchListString.indexOf("pubmed_170101.dtd") + "pubmed_170101.dtd'>".length());
										final StringReader is = new StringReader(fetchListString);
										final Source source = new StreamSource(is);
										try {
											fetchList = (PubmedArticleSet) jds.marshaller.unmarshal(source);
										} catch (XmlMappingException ex) {
											LOGGER.debug("source=" + fetchListString);
											LOGGER.warn("fetch xml parsing error: ", ex);
										}

									} catch (ApiException ex) {
										LOGGER.error("Error fetching docs", ex);
										LOGGER.debug("base=" + jds.getJddClient().getApiClient().getBasePath());
									}
									if (fetchList != null && fetchList.getPubmedArticleList() != null) {
										qi.setRetmode(retmode);
										qi.setCount(count);
										qi.setStatus(StatusEnum.INPROGRESS);
										jds.queryRepo.save(qi);
										
										for (com.dskow.downloader.models.xml.PubmedArticle article : fetchList.getPubmedArticleList()) {
											PubmedArticle journal = new PubmedArticle(article);
											jds.journalRepo.save(journal);
										}
										qi.setStatus(StatusEnum.COMPLETE);
										jds.queryRepo.save(qi);
									}
								}
							}
						} else {
							LOGGER.debug("no fetch queries found");
						}

						// get next query
						// run query
						// store results
					}
					LOGGER.debug("DownloaderController request is finished");

					isRunning = false;
				} catch (Throwable t) {
					LOGGER.error("DownloaderController.requestStart().run() failed due to:", t);
					isRunning = false;
				} finally {
					if (!isRunning) {
						DownloaderController.jdsRunning = false;
					}
				}
			}
		};

		long initialDelay = 15;
		TimeUnit unit = TimeUnit.SECONDS;

		generatorHandler = scheduler.scheduleAtFixedRate(command, initialDelay, period, unit);

	}

	public List<PubmedArticleEntity> getFiles(int fromIndex, int toIndex) {
		List<PubmedArticleEntity> results = new ArrayList<PubmedArticleEntity>();
		List<PubmedArticle> list = jds.journalRepo.findAllAbstracts().subList(fromIndex, toIndex);
		for (PubmedArticle j : list) {
			PubmedArticleEntity je = new PubmedArticleEntity(j);
			results.add(je);
		}
		return results;
	}

	public List<QueryInfoEntity> getQueries() {
		List<QueryInfoEntity> results = new ArrayList<QueryInfoEntity>();
		List<QueryInfo> list = jds.queryRepo.findAll();
		for (QueryInfo j : list) {
			QueryInfoEntity je = new QueryInfoEntity(j);
			results.add(je);
		}
		return results;
	};

	/**
	 * Checks to see if downloading can happen.
	 * 
	 * Limit all scripts to the off peak hours of 9 PM to 5 AM Eastern Standard
	 * Time (USA).
	 * 
	 * @return true if downloading is possible.
	 */
	public Boolean canDownload() {
		Boolean canDownload = false;
		Calendar current_date = Calendar.getInstance(EASTERNTIMEZONE);
		int offhourEnd = 5;
		int offhourStart = 21;
		if (EASTERNTIMEZONE.inDaylightTime(new Date())) {
			// In daylight savings time, treat values as if they are 1 hour
			// ahead of
			// standard time.
			offhourEnd += 1;
			offhourStart += 1;
		}
		int current_hour = current_date.get(Calendar.HOUR_OF_DAY);
		int current_day = current_date.get(Calendar.DAY_OF_WEEK);
		if (current_day == Calendar.TUESDAY || current_day == Calendar.SATURDAY || current_day == Calendar.SUNDAY
				|| current_hour < offhourEnd || current_hour > offhourStart) {
			LOGGER.info("Weekend or off hours! Can download");
			canDownload = true;
		} else {
			LOGGER.info("It is not the weekend or off hours! this program can not download");
			canDownload = false;
		}
		return canDownload;
	}

	public void run(String query) {
		if (canDownload()) {

		}
	}

	/**
	 * Gets the data records by Id.
	 * 
	 * Each Entrez database refers to the data records within it by an integer
	 * ID called a UID (unique identifier). Examples of UIDs are GI numbers for
	 * Nucleotide and Protein, PMIDs for PubMed, or MMDB-IDs for Structure. The
	 * E-utilities use UIDs for both data input and output, and thus it is often
	 * critical, especially for advanced data pipelines, to know how to find the
	 * UIDs associated with the desired data before beginning a project with the
	 * E-utilities. Here is a complete list of UIDs in Entrez.
	 * <table>
	 * <tr>
	 * <th>Entrez Database</th>
	 * <th>UID common name</th>
	 * <th>E-utility Database Name</th>
	 * </tr>
	 * <tr>
	 * <td>BioProject</td>
	 * <td>BioProject ID</td>
	 * <td>bioproject</td>
	 * </tr>
	 * <tr>
	 * <td>BioSample</td>
	 * <td>BioSample ID</td>
	 * <td>biosample</td>
	 * </tr>
	 * <tr>
	 * <td>Biosystems</td>
	 * <td>BSID</td>
	 * <td>biosystems</td>
	 * </tr>
	 * <tr>
	 * <td>Books</td>
	 * <td>Book ID</td>
	 * <td>books</td>
	 * </tr>
	 * <tr>
	 * <td>Conserved Domains</td>
	 * <td>PSSM-ID</td>
	 * <td>cdd</td>
	 * </tr>
	 * <tr>
	 * <td>dbGaP</td>
	 * <td>dbGaP ID</td>
	 * <td>gap</td>
	 * </tr>
	 * <tr>
	 * <td>dbVar</td>
	 * <td>dbVar ID</td>
	 * <td>dbvar</td>
	 * </tr>
	 * <tr>
	 * <td>Epigenomics</td>
	 * <td>Epigenomics ID</td>
	 * <td>epigenomics</td>
	 * </tr>
	 * <tr>
	 * <td>EST</td>
	 * <td>GI number</td>
	 * <td>nucest</td>
	 * </tr>
	 * <tr>
	 * <td>Gene</td>
	 * <td>Gene ID</td>
	 * <td>gene</td>
	 * </tr>
	 * <tr>
	 * <td>Genome</td>
	 * <td>Genome ID</td>
	 * <td>genome</td>
	 * </tr>
	 * <tr>
	 * <td>GEO Datasets</td>
	 * <td>GDS ID</td>
	 * <td>gds</td>
	 * </tr>
	 * <tr>
	 * <td>GEO Profiles</td>
	 * <td>GEO ID</td>
	 * <td>geoprofiles</td>
	 * </tr>
	 * <tr>
	 * <td>GSS</td>
	 * <td>GI number</td>
	 * <td>nucgss</td>
	 * </tr>
	 * <tr>
	 * <td>HomoloGene</td>
	 * <td>HomoloGene ID</td>
	 * <td>homologene</td>
	 * </tr>
	 * <tr>
	 * <td>MeSH</td>
	 * <td>MeSH ID</td>
	 * <td>mesh</td>
	 * </tr>
	 * <tr>
	 * <td>NCBI C++ Toolkit</td>
	 * <td>Toolkit ID</td>
	 * <td>toolkit</td>
	 * </tr>
	 * <tr>
	 * <td>NCBI Web Site</td>
	 * <td>Web Site ID</td>
	 * <td>ncbisearch</td>
	 * </tr>
	 * <tr>
	 * <td>NLM Catalog</td>
	 * <td>NLM Catalog ID</td>
	 * <td>nlmcatalog</td>
	 * </tr>
	 * <tr>
	 * <td>Nucleotide</td>
	 * <td>GI number</td>
	 * <td>nuccore</td>
	 * </tr>
	 * <tr>
	 * <td>OMIA</td>
	 * <td>OMIA ID</td>
	 * <td>omia</td>
	 * </tr>
	 * <tr>
	 * <td>PopSet</td>
	 * <td>PopSet ID</td>
	 * <td>popset</td>
	 * </tr>
	 * <tr>
	 * <td>Probe</td>
	 * <td>Probe ID</td>
	 * <td>probe</td>
	 * </tr>
	 * <tr>
	 * <td>Protein</td>
	 * <td>GI number</td>
	 * <td>protein</td>
	 * </tr>
	 * <tr>
	 * <td>Protein Clusters</td>
	 * <td>Protein Cluster ID</td>
	 * <td>proteinclusters</td>
	 * </tr>
	 * <tr>
	 * <td>PubChem BioAssay</td>
	 * <td>AID</td>
	 * <td>pcassay</td>
	 * </tr>
	 * <tr>
	 * <td>PubChem Compound</td>
	 * <td>CID</td>
	 * <td>pccompound</td>
	 * </tr>
	 * <tr>
	 * <td>PubChem Substance</td>
	 * <td>SID</td>
	 * <td>pcsubstance</td>
	 * </tr>
	 * <tr>
	 * <td>PubMed</td>
	 * <td>PMID</td>
	 * <td>pubmed</td>
	 * </tr>
	 * <tr>
	 * <td>PubMed Central</td>
	 * <td>PMCID</td>
	 * <td>pmc</td>
	 * </tr>
	 * <tr>
	 * <td>SNP</td>
	 * <td>rs number</td>
	 * <td>snp</td>
	 * </tr>
	 * <tr>
	 * <td>SRA</td>
	 * <td>SRA ID</td>
	 * <td>sra</td>
	 * </tr>
	 * <tr>
	 * <td>Structure</td>
	 * <td>MMDB-ID</td>
	 * <td>structure</td>
	 * </tr>
	 * <tr>
	 * <td>Taxonomy</td>
	 * <td>TaxID</td>
	 * <td>taxonomy</td>
	 * </tr>
	 * <tr>
	 * <td>UniGene</td>
	 * <td>UniGene Cluster ID</td>
	 * <td>unigene</td>
	 * </tr>
	 * <tr>
	 * <td>UniSTS</td>
	 * <td>STS ID</td>
	 * <td>unists</td>
	 * </tr>
	 * </table>
	 * 
	 * @param uid
	 *            the unique identifier.
	 */
	public void getByUID(String uid) {

	}

	/**
	 * Gets the url part for the environment key.
	 * 
	 * @return the url part for the environment key or empty string if null.
	 */
	// private String getEnvUrlPart(String envKey) {
	// String envUrlPart = "";
	// if (envKey != null && !envKey.isEmpty()) {
	// envUrlPart = "&WebEnv=" + envKey;
	// }
	// return envUrlPart;
	// }

	/**
	 * Gets the url part for the database key.
	 * 
	 * @return the url part for the database key or empty string if null.
	 */
	private String getDatabaseKey(String database) {
		String db = "";
		if (database != null && !database.isEmpty()) {
			db = "db=" + database;
		}
		return db;
	}

	/**
	 * Gets a list of UIDs that match a text query.
	 * 
	 * ESearch returns a list of UIDs that match a text query in a given Entrez
	 * database
	 * 
	 * Example: egquery.fcgi?term=query
	 * 
	 * ESearch can post its output set of UIDs to the History Server, but only
	 * if the &usehistory parameter is set to “y”
	 * 
	 * Upload Example: esearch.fcgi?db=database&term=query&usehistory=y
	 * 
	 * Search step that uses a web environment and a query key in the &term
	 * parameter (preceded by #, encoded as %23)
	 * 
	 * Search Example:
	 * esearch.fcgi?db=database&term=%23key+AND+query&WebEnv=webenv&usehistory=y
	 * 
	 * @param database
	 *            the database
	 * @param query
	 *            the query string
	 * @param record
	 *            a record of the request
	 * @return a record of the request
	 */
	private Record eSearch(Record record) {
		if (record.query != null && !record.query.isEmpty()) {
			// String envUrlPart = getEnvUrlPart(record.envKey);
			String db = getDatabaseKey(record.database);
			String urlstring = BASE_URI + "esearch.fcgi?" + db + "&" + TERM + record.query + "&" + USE_HISTORY + "y";
			URL url = null;
			URLConnection conn = null;
			try {
				url = new URL(urlstring);
			} catch (MalformedURLException e) {
				LOGGER.warn(e.getMessage());
			}
			try {
				if (url != null) {
					conn = url.openConnection();
					conn.setDoOutput(true);
					conn.setDoInput(false);
					Object xmlobj = conn.getContent();
					if (xmlobj instanceof String) {
						String xmlString = (String) xmlobj;
						LOGGER.info(xmlString);
					}
				}
			} catch (IOException e) {
				LOGGER.warn(e.getMessage());
			}
		}
		return record;
	}

	/**
	 * Globally gets a list of UIDs that match the text query. EGQuery is a
	 * global version of ESearch that searches all Entrez databases
	 * simultaneously.
	 * 
	 * esearch.fcgi?db=database&term=query
	 * 
	 * @param query
	 *            the query string
	 * @param record
	 *            a record of the request
	 * @return a record of the request
	 */
	// private Record eqSearch(Record record) {
	// String envUrlPart = getEnvUrlPart(record.envKey);
	// return record;
	// }

	/**
	 * Gets the DocSums that match a list of input UIDs.
	 * 
	 * ESummary returns DocSums that match a list of input UIDs.
	 * 
	 * esummary.fcgi?db=database&id=uid1,uid2,uid3,...
	 * 
	 * The resulting query key and Web environment from either EPost or ESearch
	 * can then be used in place of a UID list
	 * 
	 * Download Example: esummary.fcgi?db=database&WebEnv=webenv&query_key=key
	 * 
	 * @param uids
	 *            a list of uids
	 * @param record
	 *            a record of the request
	 * @return a record of the request.
	 */
	private Record eSummary(Record record) {
		// String envUrlPart = getEnvUrlPart(record.envKey);
		return record;
	}

	/**
	 * EInfo provides detailed information about each database, including lists
	 * of the indexing fields in the database and the available links to other
	 * Entrez databases.
	 * 
	 * einfo.fcgi?db=database
	 * 
	 * @param database
	 *            a database to look for
	 * @param record
	 *            a record of the request
	 */
	// private Record eInfo(Record record) {
	// String envUrlPart = getEnvUrlPart(record.envKey);
	// return record;
	// }

	/**
	 * EPost allows any list of UIDs to be uploaded to the History Server and
	 * returns the query key and Web environment.
	 * 
	 * 1. each set of UIDs an integer label called a query key (&query_key)
	 * 
	 * 2. an encoded cookie string called a Web environment (&WebEnv)
	 * 
	 * Upload Example: epost.fcgi?db=database&id=uid1,uid2,uid3,...
	 * 
	 * @param uids
	 *            alist of uids
	 * @return a query key and web environment.
	 */
	// private Record ePost(Record record) {
	// String envUrlPart = getEnvUrlPart(record.envKey);
	// return record;
	// }

	/**
	 * ELink also can post its output to the History server if &cmd is set to
	 * "neighbor_history".
	 * 
	 * The resulting query key and Web environment from either EPost or ESearch
	 * can then be used in place of a UID list
	 * 
	 * Upload Example:
	 * elink.fcgi?dbfrom=source_db&db=destination_db&cmd=neighbor_history&
	 * id=uid1,uid2,...
	 * 
	 * Link Example:
	 * elink.fcgi?dbfrom=initial_databasedb=target_database&WebEnv=webenv
	 * &query_key=key
	 */
	// private Record eLink(Record record) {
	// String envUrlPart = getEnvUrlPart(record.envKey);
	// return record;
	// }

	/**
	 * The resulting query key and Web environment from either EPost or ESearch
	 * can then be used in place of a UID list.
	 * 
	 * Download Example:
	 * efetch.fcgi?db=database&WebEnv=webenv&query_key=key&rettype=report_type
	 * &retmode=data_mode
	 * 
	 */
	// private Record eFetch(Record record) {
	// String envUrlPart = getEnvUrlPart(record.envKey);
	// return record;
	// }

	/**
	 * Retrieving data records matching an Entrez query.
	 * 
	 * Runs a text search in web Entrez is equivalent to ESearch-ESummary.
	 * 
	 * Text search strings entered into the Entrez system are converted into
	 * Entrez queries with the following format: term1[field1] Op term2[field2]
	 * Op term3[field3] Op ...
	 * 
	 * where: terms are search terms and Op = AND, OR, or NOT
	 * 
	 * Example: human[organism] AND topoisomerase[protein name]
	 * 
	 * Each E-utility call after the initial call must set the &WebEnv parameter
	 * to the value of the pre-existing web environment.
	 * 
	 * @param database
	 *            the database to search
	 * @param query
	 *            the query string
	 * @return XML Document Summaries.
	 */
	public String search(String database, String query) {
		String xmlDocSummaries = "";
		Record record = new Record();
		record.query = query;
		record = eSearch(record);
		record = eSummary(record);
		return xmlDocSummaries;
	}

	public class Record {
		public String query;
		public String envKey;
		public String querykey;
		public List<String> uids;
		public String database;
		public String xmlDocSummaries;
		public int retstart;

		public Record() {
			retstart = 0;
			query = "";
			envKey = "";
			querykey = "";
			uids = new ArrayList<String>();
			database = "";
		}
	}
}
