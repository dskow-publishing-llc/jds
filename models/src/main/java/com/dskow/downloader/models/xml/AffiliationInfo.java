package com.dskow.downloader.models.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class AffiliationInfo implements Serializable {

	/**
	 * serial Version UID.
	 */
	private static final long serialVersionUID = -1872516548055244505L;

	@XmlElement(name = "Affiliation")
	private String Affiliation;

	public String getAffiliation() {
		return Affiliation;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AffiliationInfo {\n");

		sb.append("    Affiliation: ").append(toIndentedString(Affiliation)).append("\n");
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
