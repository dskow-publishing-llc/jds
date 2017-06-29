package com.dskow.downloader.service.jds.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mongodb.MongoTimeoutException;
import com.dskow.downloader.models.service.PubmedArticleEntity;
import com.dskow.downloader.models.service.QueryInfoEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-05T10:38:38.017-04:00")

@Api(value = "jds", description = "the journalDocDownloaderService API")
public interface JournalDocDownloaderServiceApi {

	@ApiOperation(value = "gets all xml files", notes = "gets all xml files. ", response = PubmedArticleEntity.class, responseContainer = "List", tags = {
			"JDD", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "xml file data", response = PubmedArticleEntity.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = PubmedArticleEntity.class),
			@ApiResponse(code = 403, message = "Forbidden", response = PubmedArticleEntity.class),
			@ApiResponse(code = 404, message = "Not Found", response = PubmedArticleEntity.class) })
	@RequestMapping(value = "/jds/files", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<List<PubmedArticleEntity>> jdsFilesUsingGET(
			@ApiParam(value = "query fromIndex") @RequestParam(value = "from", required = false) int fromIndex,
			@ApiParam(value = "query toIndex") @RequestParam(value = "to", required = false) int toIndex);

	@ApiOperation(value = "gets all queries", notes = "gets all queries. ", response = QueryInfoEntity.class, responseContainer = "List", tags = {
			"JDD", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "query data", response = QueryInfoEntity.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = QueryInfoEntity.class),
			@ApiResponse(code = 403, message = "Forbidden", response = QueryInfoEntity.class),
			@ApiResponse(code = 404, message = "Not Found", response = QueryInfoEntity.class) })
	@RequestMapping(value = "/jds/queries", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<List<QueryInfoEntity>> jdsQueriesUsingGET();

	@ApiOperation(value = "creates a query", notes = "creates an query. ", response = QueryInfoEntity.class, tags = {
			"JDD", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "query data", response = QueryInfoEntity.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = QueryInfoEntity.class),
			@ApiResponse(code = 403, message = "Forbidden", response = QueryInfoEntity.class),
			@ApiResponse(code = 404, message = "Not Found", response = QueryInfoEntity.class) })
	@RequestMapping(value = "/jds/queries", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<QueryInfoEntity> jdsQueriesUsingPOST(
			@ApiParam(value = "query detail", required = true) @RequestBody QueryInfoEntity query);

	@ApiOperation(value = "get server's current epoch time in millis", notes = "get server's current epoch time in millis. ", response = String.class, tags = {
			"JDD", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "The current epoch time in millis", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class),
			@ApiResponse(code = 404, message = "Not Found", response = String.class) })
	@RequestMapping(value = "/jds/pings", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<String> jdsPingsUsingGET();

	@ExceptionHandler(MongoTimeoutException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	Error handleMongoTimeoutException(HttpServletRequest req, MongoTimeoutException ex);

}
