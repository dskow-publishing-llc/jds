package com.dskow.downloader.service.jds.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-06-22T15:06:40.463-04:00")

@Api(value = "default", description = "the default API")
public interface DefaultApi {

	@ApiOperation(value = "index", notes = "", response = String.class, tags = { "home-controller", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 204, message = "No Content", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/", produces = { "*/*" }, consumes = { "application/json" }, method = RequestMethod.DELETE)
	ResponseEntity<String> indexUsingDELETE();

	@ApiOperation(value = "index", notes = "", response = String.class, tags = { "home-controller", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class),
			@ApiResponse(code = 404, message = "Not Found", response = String.class) })
	@RequestMapping(value = "/", produces = { "*/*" }, consumes = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<String> indexUsingGET();

	@ApiOperation(value = "index", notes = "", response = String.class, tags = { "home-controller", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 204, message = "No Content", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/", produces = { "*/*" }, consumes = { "application/json" }, method = RequestMethod.HEAD)
	ResponseEntity<String> indexUsingHEAD();

	@ApiOperation(value = "index", notes = "", response = String.class, tags = { "home-controller", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 204, message = "No Content", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/", produces = { "*/*" }, consumes = {
			"application/json" }, method = RequestMethod.OPTIONS)
	ResponseEntity<String> indexUsingOPTIONS();

	@ApiOperation(value = "index", notes = "", response = String.class, tags = { "home-controller", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 204, message = "No Content", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/", produces = { "*/*" }, consumes = { "application/json" }, method = RequestMethod.PATCH)
	ResponseEntity<String> indexUsingPATCH();

	@ApiOperation(value = "index", notes = "", response = String.class, tags = { "home-controller", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 201, message = "Created", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class),
			@ApiResponse(code = 404, message = "Not Found", response = String.class) })
	@RequestMapping(value = "/", produces = { "*/*" }, consumes = { "application/json" }, method = RequestMethod.POST)
	ResponseEntity<String> indexUsingPOST();

	@ApiOperation(value = "index", notes = "", response = String.class, tags = { "home-controller", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 201, message = "Created", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class),
			@ApiResponse(code = 404, message = "Not Found", response = String.class) })
	@RequestMapping(value = "/", produces = { "*/*" }, consumes = { "application/json" }, method = RequestMethod.PUT)
	ResponseEntity<String> indexUsingPUT();

}
