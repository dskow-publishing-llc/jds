package com.dskow.downloader.models.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class MedlineCitation implements Serializable {

	/**
	 * serial Version UID.
	 */
	private static final long serialVersionUID = 6794989639322626582L;

	@XmlElement(name = "PMID")
	private PMID PMID;

	@XmlElement(name = "DateCreated")
	private DateCreated DateCreated;

	@XmlElement(name = "DateRevised")
	private DateRevised DateRevised;

	@XmlElement(name = "Article")
	private Article Article;

	@XmlElement(name = "MedlineJournalInfo")
	private MedlineJournalInfo MedlineJournalInfo;

	public PMID getPmid() {
		return PMID;
	}

	public DateCreated getDateCreated() {
		return DateCreated;
	}

	public DateRevised getDateRevised() {
		return DateRevised;
	}

	public Article getArticle() {
		return Article;
	}

	public MedlineJournalInfo getMedlineJournalInfo() {
		return MedlineJournalInfo;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class MedlineCitation {\n");

		sb.append("    PMID: ").append(toIndentedString(PMID)).append("\n");
		sb.append("    DateCreated: ").append(toIndentedString(DateCreated)).append("\n");
		sb.append("    DateRevised: ").append(toIndentedString(DateRevised)).append("\n");
		sb.append("    Article: ").append(toIndentedString(Article)).append("\n");
		sb.append("    MedlineJournalInfo: ").append(toIndentedString(MedlineJournalInfo)).append("\n");
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
