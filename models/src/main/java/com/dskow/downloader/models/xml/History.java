package com.dskow.downloader.models.xml;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class History implements Serializable {

	/**
	 * serial Version UID.
	 */
	private static final long serialVersionUID = -5174059912170436384L;

	@XmlElement(name = "PubMedPubDate")
	private List<PubMedPubDate> PubMedPubDate;

	public List<PubMedPubDate> getPubMedPubDate() {
		return PubMedPubDate;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class History {\n");

		sb.append("    PubMedPubDate: ").append(toIndentedString(PubMedPubDate)).append("\n");
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
