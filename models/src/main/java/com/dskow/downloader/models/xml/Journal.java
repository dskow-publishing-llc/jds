package com.dskow.downloader.models.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class Journal implements Serializable {

	/**
	 * serial Version UID.
	 */
	private static final long serialVersionUID = 3905716556004719900L;

	@XmlElement(name = "ISSN")
	private ISSN ISSN;

	@XmlElement(name = "JournalIssue")
	private JournalIssue JournalIssue;

	@XmlElement(name = "Title")
	private String Title;

	@XmlElement(name = "ISOAbbreviation")
	private String ISOAbbreviation;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Journal {\n");

		sb.append("    ISSN: ").append(toIndentedString(ISSN)).append("\n");
		sb.append("    JournalIssue: ").append(toIndentedString(JournalIssue)).append("\n");
		sb.append("    Title: ").append(toIndentedString(Title)).append("\n");
		sb.append("    ISOAbbreviation: ").append(toIndentedString(ISOAbbreviation)).append("\n");
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
