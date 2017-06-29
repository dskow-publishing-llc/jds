package com.dskow.downloader.service.jds;

import java.text.FieldPosition;
import java.util.Date;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.fasterxml.jackson.databind.util.ISO8601Utils;

public class RFC3339DateFormat extends ISO8601DateFormat {

	/**
	 * serial Version UID.
	 */
	private static final long serialVersionUID = -583061235813042589L;

	// Same as ISO8601DateFormat but serializing milliseconds.
	@Override
	public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
		String value = ISO8601Utils.format(date, true);
		toAppendTo.append(value);
		return toAppendTo;
	}

}