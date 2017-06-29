package com.dskow.downloader.models.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class MedlineJournalInfo implements Serializable {

	/**
	 * serial Version UID.
	 */
	private static final long serialVersionUID = -2691189155035491810L;

	@XmlElement(name = "Country")
	private String Country;

	@XmlElement(name = "MedlineTA")
	private String MedlineTA;

	@XmlElement(name = "NlmUniqueID")
	private String NlmUniqueID;

	@XmlElement(name = "ISSNLinking")
	private String ISSNLinking;

	public String getCountry() {
		return Country;
	}

	public String getMedlineTA() {
		return MedlineTA;
	}

	public String getNlmUniqueID() {
		return NlmUniqueID;
	}

	public String getISSNLinking() {
		return ISSNLinking;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class MedlineJournalInfo {\n");

		sb.append("    Country: ").append(toIndentedString(Country)).append("\n");
		sb.append("    MedlineTA: ").append(toIndentedString(MedlineTA)).append("\n");
		sb.append("    NlmUniqueID: ").append(toIndentedString(NlmUniqueID)).append("\n");
		sb.append("    ISSNLinking: ").append(toIndentedString(ISSNLinking)).append("\n");
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
