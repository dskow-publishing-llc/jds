package com.dskow.downloader.models.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class PMID implements Serializable {

	/**
	 * serial Version UID.
	 */
	private static final long serialVersionUID = -1588784684804469305L;

	@XmlValue
	private String content;

	@XmlAttribute(name = "Version")
	private String Version;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PMID {\n");

		sb.append("    Version: ").append(toIndentedString(Version)).append("\n");
		sb.append("    content: ").append(toIndentedString(content)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
