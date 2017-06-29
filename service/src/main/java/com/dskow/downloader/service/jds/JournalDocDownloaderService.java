package com.dskow.downloader.service.jds;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.MongoTimeoutException;
import com.dskow.downloader.jdd.client.ApiClient;
import com.dskow.downloader.jdd.client.api.JDDApi;
import com.dskow.downloader.models.mongo.PubmedArticle;
import com.dskow.downloader.models.mongo.QueryInfo;
import com.dskow.downloader.models.mongo.QueryStatus;
import com.dskow.downloader.models.service.PubmedArticleEntity;
import com.dskow.downloader.models.service.QueryInfoEntity;
import com.dskow.downloader.models.service.QueryInfoEntity.StatusEnum;
import com.dskow.downloader.service.jds.api.JournalDocDownloaderServiceApi;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-04-21T13:21:31.389-04:00")

@Controller
public class JournalDocDownloaderService implements JournalDocDownloaderServiceApi {

	// Define a static LOGGER variable so that it references the
	// Logger instance named "JournalDocDownloaderService".
	private static final Logger LOGGER = LogManager.getLogger(JournalDocDownloaderService.class);

	private JDDApi jddClient;

	@Autowired
	public void configureJddClient(JDDApi jddClient, @Value("${jdd.endpoint}") String baseUrl) {
		LOGGER.debug("configureJddClient baseUrl=" + baseUrl);
		this.jddClient = jddClient;
		ApiClient apiClient = new ApiClient();
		apiClient.setBasePath(baseUrl);
		this.jddClient.setApiClient(apiClient);
	}

	@Autowired
	JournalRepository journalRepo;

	@Autowired
	QueryRepository queryRepo;

	private DownloaderController jddc = null;

	@Autowired
	public void configJDDC() {
		LOGGER.debug("configJDDC() called");
		jddc = new DownloaderController(this);
		jddc.requestStart();
	}

	@Autowired
	Jaxb2Marshaller marshaller;

	public ResponseEntity<List<PubmedArticleEntity>> jdsFilesUsingGET(
			@ApiParam(value = "query fromIndex") @RequestParam(value = "from", required = false) int fromIndex,
			@ApiParam(value = "query toIndex") @RequestParam(value = "to", required = false) int toIndex) {
		LOGGER.debug("jdsFilesUsingGET from=" + fromIndex + " to=" + toIndex);
		return new ResponseEntity<List<PubmedArticleEntity>>(jddc.getFiles(fromIndex, toIndex), HttpStatus.OK);
	}

	public ResponseEntity<PubmedArticleEntity> jdsFilesUsingPOST(
			@ApiParam(value = "file detail") @RequestPart("file") MultipartFile body) {
		return new ResponseEntity<PubmedArticleEntity>(createFile(body), HttpStatus.OK);
	}

	public ResponseEntity<List<QueryInfoEntity>> jdsQueriesUsingGET() {
		return new ResponseEntity<List<QueryInfoEntity>>(jddc.getQueries(), HttpStatus.OK);
	}

	public ResponseEntity<QueryInfoEntity> jdsQueriesUsingPOST(
			@ApiParam(value = "query detail", required = true) @RequestBody QueryInfoEntity body) {
		return new ResponseEntity<QueryInfoEntity>(createQuery(body), HttpStatus.OK);
	}

	public ResponseEntity<String> jdsPingsUsingGET() {
		return new ResponseEntity<String>(getPing(), HttpStatus.OK);
	}

	// pass specific exceptions to http client.

	@Override
	public Error handleMongoTimeoutException(HttpServletRequest req, MongoTimeoutException ex) {
		LOGGER.error("handleMongoTimeoutException called", ex);
		return getException(req, ex);
	}

	public JDDApi getJddClient() {
		return jddClient;
	}

	private String getPing() {
		return "" + System.currentTimeMillis();
	}

	private PubmedArticleEntity createFile(MultipartFile body) {
		PubmedArticleEntity result = null;

		PubmedArticle j = null;
		String name = "";
		if (body != null) {
			name = body.getName();
		}

		if (name != null && name.trim().length() != 0) {
			List<PubmedArticle> list = journalRepo.findByName(name);
			if (list != null && !list.isEmpty()) {
				j = list.get(0);
				result = new PubmedArticleEntity(j);
			}
		}

		return result;
	}

	private QueryInfoEntity createQuery(QueryInfoEntity body) {
		LOGGER.debug("JDS::createQuery body=" + body);
		QueryInfoEntity result = null;

		String content = "";
		if (body != null) {
			content = body.getContent();
		}

		if (content != null && content.trim().length() != 0) {
			List<QueryInfo> list = queryRepo.findByStatus(QueryStatus.Queued.name());
			boolean isAlreadyQueued = false;
			if (list != null && !list.isEmpty()) {
				for (QueryInfo q : list) {
					if (q.getContent().equals(content)) {
						isAlreadyQueued = true;
						break;
					}
				}
			}
			LOGGER.debug("JDS::createQuery isAlreadyQueued=" + isAlreadyQueued);
			if (!isAlreadyQueued) {
				QueryInfo qi = new QueryInfo(body);
				qi.setStatus(StatusEnum.QUEUED);
				queryRepo.save(qi);
				LOGGER.debug("JDS::createQuery query saved qi=" + qi);
				result = body;
			}

		}

		return result;
	}

	private Error getException(HttpServletRequest req, MongoTimeoutException ex) {
		LOGGER.debug("mongo timeout error called");
		Error error = new Error();
		error.setStackTrace(ex.getStackTrace());
		return error;
	}

	public UUID getNewJournalUuid() {
		UUID id = UUID.randomUUID();
		if (journalRepo.exists(id.toString())) {
			id = getNewJournalUuid();
		}
		return id;
	}

}
