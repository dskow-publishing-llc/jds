package com.dskow.downloader.models.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class ELocationID implements Serializable {

	/**
	 * serial Version UID.
	 */
	private static final long serialVersionUID = 3140338200659212633L;

	@XmlValue
	private String content;

	@XmlAttribute(name = "EIdType")
	private String EIdType;

	@XmlAttribute(name = "ValidYN")
	private String ValidYN;

	public String getContent() {
		return content;
	}
	
	public String getEIdType() {
		return EIdType;
	}

	public String getValidYN() {
		return ValidYN;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Journal {\n");

		sb.append("    EIdType: ").append(toIndentedString(EIdType)).append("\n");
		sb.append("    ValidYN: ").append(toIndentedString(ValidYN)).append("\n");
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
