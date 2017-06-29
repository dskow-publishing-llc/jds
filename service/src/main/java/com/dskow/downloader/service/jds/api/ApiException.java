package com.dskow.downloader.service.jds.api;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-06-22T15:06:40.463-04:00")

public class ApiException extends Exception {
	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = -844175208883331581L;

	public ApiException(int code, String msg) {
		super(msg);
	}
}
