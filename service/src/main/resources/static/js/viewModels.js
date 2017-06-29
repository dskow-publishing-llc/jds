var setHeader = function(xhr) {
	xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	xhr.setRequestHeader('Accept', 'application/sparql-results+json');
	xhr.withCredentials = true;
};

var setUploadHeader = function(xhr) {
	xhr.withCredentials = true;
};

var setTextHeader = function(xhr) {
	xhr.setRequestHeader('Accept', 'text/html');
	xhr.withCredentials = true;
};

/**
 * Creates a journalVM view model.
 * 
 * @param name
 *            the name
 * @param isChecked
 *            the isChecked
 */
var JournalVM = function(name, isChecked, currentQuery, database, parent) {
	'use strict';
	var self = this;
	self.parent = window.ko.observable(parent);
	self.name = window.ko.observable(name);
	self.database = window.ko.observable(database);
	self.checked = window.ko.observable(isChecked);
	self.currentQuery = window.ko.observable(currentQuery);
	self.data = window.ko.observable("");
	self.datatype = window.ko.observable("XML");
	self.rawvalue = window.ko.observable(0);
	self.precision = window.ko.observable(2);
	self.value = window.ko.observable(0);

	self.animated = window.ko.observable();
	self.striped = window.ko.observable(true);
	self.type = window.ko.observable('info');
	self.text = window.ko.observable('Complete');
	self.textHidden = window.ko.observable(false);
	self.pauseButton = window.ko.observable('Pause');
	self.fetchItems = window.ko.observable();
	self.count = window.ko.observable(0);
	self.retStart = window.ko.observable(0);
	self.retMax = window.ko.observable(20);
	self.count = window.ko.observable(0);
	self.retmode = window.ko.observable("JSON");
	self.rettype = window.ko.observable("abstract");
	self.phase = window.ko.observable('search');
	self.error = window.ko.observable("");

	self.pause = function() {
		if (self.pauseButton() === 'Pause') {
			self.pauseButton("Resume");
			self.checked(false);
		} else {
			self.pauseButton("Pause");
			self.checked(true);
		}
	};

	self.updateParentCheckbox = function(parent) {
		if (parent.internal() === false) {
			var catlinks = parent.links();
			var allTrue = true;
			var partialTrue = false;
			var j;
			for (j = 0; j < catlinks.length; j++) {
				if (catlinks[j].checked() === true) {
					partialTrue = true;
				} else {
					allTrue = false;
				}
			}
			parent.internal(true);
			parent.allchecked(allTrue);
			parent.internal(false);
			if (partialTrue && allTrue === false) {
				parent.linksIndeterminate(true);
			} else {
				parent.linksIndeterminate(false);
			}
		}
	};
	self.getSearchDataAsync = function(sYear, eYear) {
		setTimeout(function() {
			console.log("getSearchDataAsync called");
			var i26;
			var myjournal = self.name();//.replace(/\s+/g, '+');
//			var sYear = self.startRange();
//			var eYear = self.endRange();
			var quertInfo = {
				id : null,
				name : "query4",
				content : self.currentQuery(),
				language : "xml",
				error : "",
				count : 0,
				retMax : 0,
				fetchItems : self.fetchItems(),
				database : self.database(), 
				retmode : self.retmode(),
				rettype : self.rettype(),
				prefix : self.parent().prefix(), 
				tool : self.parent().tool(),
				email : self.parent().email(),
				term : myjournal + "[journal]" + " AND " + sYear + ":" + eYear + "[pdat]"
			}
			console.log(quertInfo);
			var args = {
				      url : 'jds/queries',
				      type : 'POST',
				      dataType : 'json',
				      contentType : 'application/json',
				      data : JSON.stringify(quertInfo),
				success : function(largeLoad) {
					console.log(largeLoad);
					/*
					 * Do this next part on the server side too. if (typeof
					 * largeLoad.error === 'undefined') { var esearchresult = $
					 * (largeLoad).find ( "esearchresult"); $ (largeLoad) .find
					 * ("esearchresult") .each ( function() { var error = $ (
					 * largeLoad) .find ( "ERROR") .text (); var ecount = $ (
					 * largeLoad) .find ( "Count:first"); var eretMax = $ (
					 * largeLoad) .find ( "RetMax"); $ (largeLoad) .find (
					 * "IdList") .each ( function( index) { var ids = $ ( this)
					 * .text () .replace ( /\n+/g, ','); self .fetchItems (ids
					 * .substring ( 1, ids.length - 1)); }); self.error (error);
					 * self.count (ecount .text ()); self .retMax (eretMax .text
					 * ()); }); } else { alert ('ERRORS: ' + largeLoad.error); }
					 */
				},
				error : function(xhr, ajaxOptions, thrownError) {
					console.log(xhr);
					console.log(ajaxOptions);
					console.log(thrownError);
				},
				complete : function() {
					self.retStart(Number(self.retStart())
							+ Number(self.retMax()));
					var fetchquery = self.parent().buildFetchQuery(
							self.database(), self.fetchItems(), self.retmode(),
							self.parent().prefix(), self.parent().tool(),
							self.parent().email());
					self.currentQuery(fetchquery)
					self.datatype("XML");
					self.phase('fetch');
					self.getFetchDataAsync();
				}
			};
			$.ajax(args);
		}, 100);
	};
	self.getFetchDataAsync = function() {
		setTimeout(function() {
			console.log("getFetchDataAsync called");
			console.log(self.currentQuery());
			$.ajax({
				url : self.currentQuery(),
				type : 'POST',
				dataType : "text",
				// contentType : "application/text",
				async : true,
				success : function(largeLoad) {
					if (typeof largeLoad.error === 'undefined') {
						var esearchresult = $(largeLoad).find("esearchresult");
						self.currentQuery("jds/files");
						self.data(largeLoad);
					} else {
						alert('ERRORS: ' + largeLoad.error);
					}
				},
				error : function(xhr, ajaxOptions, thrownError) {
					console.log(xhr);
					console.log(ajaxOptions);
					console.log(thrownError);
				},
				complete : function() {
					self.phase("upload");
					self.uploadDataAsync();
				},
				beforeSend : setHeader
			});
		}, 100);
	};
	self.uploadDataAsync = function() {
		setTimeout(function() {
			var inputjson = {
				"filename" : self.parent().fileName(),
				"data" : self.data()
			};
			var jsonString = JSON.stringify(inputjson);
			$.ajax({
				url : 'jds/files',
				type : 'POST',
				data : jsonString,
				dataType : "text",
				contentType : "application/json",
				async : true,
				success : function(largeLoad) {
				},
				error : function(xhr, ajaxOptions, thrownError) {
					console.log(xhr);
					console.log(ajaxOptions);
					console.log(thrownError);
				},
				complete : function() {
					self.phase("search");
					self.parent().canRunSearchQuery(true);
					self.parent().tryQuery();
				},
				beforeSend : setUploadHeader
			});
		}, 100);
	};

};

/**
 * Creates a search menu view model.
 * 
 * @param database
 *            the search database
 * @param journals
 *            the search journals
 * @param keywordSearch
 *            the keyword search
 * @param query
 *            the query
 */
var SearchVm = function(database, databases, journals, startRange, endRange,
		query, tool, email) {
	'use strict';
	self.databases = window.ko.observableArray(databases);
	self.journals = window.ko.observableArray(journals);
	self.files = window.ko.observableArray([]);
	self.newJournal = window.ko.observable("");
	self.newDatabase = window.ko.observable("pubmed");
	self.startRange = window.ko.observable(startRange);
	self.endRange = window.ko.observable(endRange);
	self.fileName = window.ko.observable("savefilename.xml");
	self.type = window.ko.observable("Search");
	self.query = window.ko.observable(query);
	self.stillMoreQueries = window.ko.observable(false);
	self.prefix = window.ko
			.observable("http://eutils.ncbi.nlm.nih.gov/entrez/eutils/");
	self.tool = window.ko.observable(tool);
	self.email = window.ko.observable(email);
	self.canRunSearchQuery = window.ko.observable(true);
	self.intervalId = window.ko.observable(0);
	self.searchButton = window.ko.observable('Start Search');
	self.toggleSearchButton = function() {
		if (self.searchButton() === 'Start Search') {
			self.searchButton('Stop Search');
			self.startCanRunQueryToggler();
		} else {
			clearInterval(self.intervalId());
			self.searchButton('Start Search');
		}
	}
	self.startCanRunQueryToggler = function() {
		clearInterval(self.intervalId());
		var id = setInterval(function() {
			self.tryQuery();
			self.getResultFilesAsync();
		}, 2000);
		self.intervalId(id);
	};
	self.tryQuery = function() {
		console.log("tryQuery called");
		var arrayIndex = 0;
		var count = 0;
		for (arrayIndex; arrayIndex < self.journals().length; arrayIndex++) {
			if (self.canRunSearchQuery() === false) {
				break;
			}
			var currentjournal = self.journals()[arrayIndex];
			var count = currentjournal.count() !== 0 ? currentjournal.count()
					: 1;
			var retStart = currentjournal.retStart();
			if (currentjournal.checked() === true
					&& (currentjournal.retStart() === 0 || currentjournal
							.retStart() < currentjournal.count())) {
				self.canRunSearchQuery(false);
				currentjournal.value(Math.floor((retStart / count) * 100));
				var searchquery = self.buildSearchQuery(currentjournal
						.database(), currentjournal.name(), currentjournal
						.retStart(), currentjournal.retMax(), currentjournal
						.retmode(), self.startRange(), self.endRange(), self
						.prefix(), self.tool(), self.email());
				currentjournal.currentQuery(searchquery);
				currentjournal.datatype("XML");
				currentjournal.getSearchDataAsync(self.startRange(), self.endRange());
			}
		}
	};

	self.getResultFilesAsync = function() {
//		setTimeout(function() {
//			$.ajax({
//				url : "jds/files",
//				type : 'GET',
//				dataType : "json",
//				contentType : "application/json",
//				async : true,
//				success : function(largeLoad) {
//					if (typeof largeLoad.error === 'undefined') {
//						self.files(largeLoad);
//					} else {
//						alert('ERRORS: ' + largeLoad.error);
//					}
//				},
//				error : function(xhr, ajaxOptions, thrownError) {
//					console.log(xhr);
//					console.log(ajaxOptions);
//					console.log(thrownError);
//				},
//				complete : function() {
//				},
//			// beforeSend : setHeader
//			});
//		}, 100);
	};
	self.getResultFilesAsync();

	self.testUpload = function() {
		var currentjournal = self.journals()[0];
		currentjournal.currentQuery("jds/files");
		currentjournal
				.data('<?xml version="1.0" encoding="UTF-8"?><!DOCTYPE PubmedArticleSet PUBLIC "-//NLM//DTD PubMedArticle, 1st January 2015//EN" "http://www.ncbi.nlm.nih.gov/corehtml/query/DTD/pubmed_150101.dtd"><PubmedArticleSet><PubmedArticle></PubmedArticle></PubmedArticleSet>')
		currentjournal.uploadDataAsync();
	}
	self.addJournal = function() {
		self.journals.push(new JournalVM(self.newJournal(), true, "", self
				.newDatabase(), this));

	};
	self.removeJournal = function(item) {
		self.journals.remove(item);
	}

	self.buildSearchQuery = function(db, journal, retStart, retMax, retmode,
			sYear, eYear, prefix, tool, email) {
		var myjournal = journal.replace(/\s+/g, '+')
		var query = prefix + "esearch.fcgi" + "?" + "db=" + db + "&" + "term="
				+ myjournal + "%5bjournal%5d" + "+AND+" + sYear + ":" + eYear
				+ "%5bpdat%5d" + "&retStart=" + retStart + "&retMax=" + retMax
				+ "&retmode=" + retmode + "&tool=" + tool + "&email=" + email;
		return query;
	};
	self.buildSummaryQuery = function(db, ids, prefix, tool, email) {
		var query = "";
		if (ids !== undefined && ids.length > 0) {
			query = prefix + "esummary.fcgi" + "?" + "db=" + db + "&" + "id="
					+ ids + "&tool=" + tool + "&email=" + email;
		}
		return query;
	};
	self.buildFetchQuery = function(db, ids, retmode, prefix, tool, email) {
		var query = "";
		if (ids !== undefined && ids.length > 0) {
			query = prefix + "efetch.fcgi" + "?" + "db=" + db + "&" + "id="
					+ ids + "&retmode=" + retmode + "&tool=" + tool + "&email="
					+ email;
		}
		return query;
	};

	// Bind twitter typeahead
	ko.bindingHandlers.typeahead = {
		init : function(element, valueAccessor, allBindingsAccessor, viewModel,
				bindingContext) {
			var $element = $(element);
			var allBindings = allBindingsAccessor();
			var substringMatcher = function(strs) {
				return function findMatches(q, cb) {
					var matches, substrRegex;
					// an array that will be populated with substring matches
					matches = [];
					// regex used to determine if a string contains the
					// substring `q`
					substrRegex = new RegExp(q, 'i');
					// iterate through the pool of strings and for any string
					// that
					// contains the substring `q`, add it to the `matches` array
					$.each(strs, function(i, str) {
						if (substrRegex.test(str)) {
							// the typeahead jQuery plugin expects suggestions
							// to a
							// JavaScript object, refer to typeahead docs for
							// more info
							matches.push(str);
						}
					});

					cb(matches);
				};
			};
			var typeaheadOpts = {
				source : substringMatcher(ko.utils
						.unwrapObservable(valueAccessor()))
			};

			if (allBindings.typeaheadOptions) {
				$.each(allBindings.typeaheadOptions, function(optionName,
						optionValue) {
					typeaheadOpts[optionName] = ko.utils
							.unwrapObservable(optionValue);
				});
			}

			$element.attr("autocomplete", "off").typeahead({
				hint : true,
				highlight : true,
				minLength : 1
			}, typeaheadOpts);
		}
	};
	self.updateSearch = function(paramstext) {
		var params = JSON.parse(paramstext);
		var i24;
		for (i24 = 0; self.journals().length; i24++) {
			self.journals.pop();
		}
		var i25;
		for (i25 = 0; i25 < params.journals.length; i25++) {
			var journal = params.journals[i25];
			self.journals.push(new JournalVM(journal.name, journal.checked, "",
					params.database, this));
		}
		self.startRange(params.startRange);
		self.endRange(params.endRange);
		self.query(params.query);
		window.viewModel.results.queryString(window.viewModel.search.query());
	};

	self.startSearch = function() {
		if (self.searchButton() === 'Start Search') {
			var arrayIndex = 0;
			var i26;
			for (i26 = 0; i26 < self.journals().length; i26++) {
				var currentjournal = self.journals()[i26];
				var query = self.buildSearchQuery(currentjournal.database(),
						currentjournal.name(), currentjournal.name(),
						currentjournal.retStart(), currentjournal.retMax(),
						currentjournal.retmode(), self.startRange(), self
								.endRange(), self.prefix(), self.tool(), self
								.email());
				currentjournal.currentQuery(query);
			}
			self.tryQuery();
		}
		self.toggleSearchButton();
	};

	self.getJournalsSearchDataAsync = function() {
		setTimeout(function() {
			var myjournals = [ "New England Journal of Medicine",
					"Journal of the American Medical Association",
					"Annals of Internal Medicine", "Lancet",
					"Mayo Clinic Proceedings", "Gastroenterology", "GUT",
					"Journal of Digestive Diseases",
					"Journal of Gastroenterology and Hepatology",
					"Journal of Gastroenterology",
					"Journal of Clinical Gastroenterology",
					"Journal of Hepatology" ];
			var mydatabases = [ "All Databases", "Assembly", "BioProject",
					"BioSample", "BioSystems", "Books", "ClinVar", "Clone",
					"Conserved Domains", "dbGaP", "Epigenomics", "EST", "Gene",
					"Genome", "GEO DataSets", "GEO Profiles", "GSS", "GTR",
					"HomoloGene", "MedGen", "MeSH", "MCBI Web Site",
					"NLM Catalog", "Nucleotide", "PMC", "PopSet", "Probe",
					"Protein", "Protein Clusters", "PubChem BioAssay",
					"PubChem Compound", "PubChem Substance", "PubMed",
					"PubMed Health", "SNP", "SRA", "Structure", "Taxonomy",
					"ToolKit", "ToolKitAll", "ToolKitBook", "UniGene" ];
			var dbkey;
			for (dbkey in mydatabases) {
				self.databases.push(mydatabases.dbkey);
			}
			var jkey;
			for (jkey in myjournals) {
				var name = myjournals[jkey];
				var isChecked = true;
				var currentQuery = "";
				var database = "pubmed";
				self.journals.push(new JournalVM(name, isChecked, currentQuery,
						database, this));
			}
		}, 100);
	};

	window.ko.bindingHandlers.nullableChecked = {
		update : function(element, valueAccessor) {
			var value = window.ko.utils.unwrapObservable(valueAccessor()) || {};
			var propName;
			for (propName in value) {
				if (!value.hasOwnProperty(propName)) {
					continue;
				}
				if (typeof propName === "string") {
					var propValue = window.ko.utils
							.unwrapObservable(value[propName]);
					element[propName] = propValue;
				}
			}
		}
	};
	self.getJournalsSearchDataAsync();
};
