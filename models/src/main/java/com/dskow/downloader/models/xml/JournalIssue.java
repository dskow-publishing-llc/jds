package com.dskow.downloader.models.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class JournalIssue implements Serializable {

	/**
	 * serial Version UID.
	 */
	private static final long serialVersionUID = -3154632123440554916L;

	@XmlAttribute(name = "CitedMedium")
	private String CitedMedium;

	@XmlElement(name = "Volume")
	private String Volume;

	@XmlElement(name = "Issue")
	private String Issue;

	@XmlElement(name = "PubDate")
	private PubDate PubDate;

	public String getCitedMedium() {
		return CitedMedium;
	}

	public String getVolume() {
		return Volume;
	}

	public String getIssue() {
		return Issue;
	}

	public PubDate getPubDate() {
		return PubDate;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Journal {\n");

		sb.append("    CitedMedium: ").append(toIndentedString(CitedMedium)).append("\n");
		sb.append("    Volume: ").append(toIndentedString(Volume)).append("\n");
		sb.append("    Issue: ").append(toIndentedString(Issue)).append("\n");
		sb.append("    PubDate: ").append(toIndentedString(PubDate)).append("\n");
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
