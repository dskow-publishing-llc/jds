package com.dskow.downloader.models.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class PubmedArticle implements Serializable {

	/**
	 * serial Version UID.
	 */
	private static final long serialVersionUID = 5907368128421873448L;

	@XmlElement(name = "id")
	private String id = null;

	@XmlElement(name = "MedlineCitation")
	private MedlineCitation MedlineCitation;

	@XmlElement(name = "PubmedData")
	private PubmedData PubmedData;

	public String getId() {
		return id;
	}

	public MedlineCitation getMedlineCitation() {
		return MedlineCitation;
	}

	public PubmedData getPubmedData() {
		return PubmedData;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PubmedArticle {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    MedlineCitation: ").append(toIndentedString(MedlineCitation)).append("\n");
		sb.append("    PubmedData: ").append(toIndentedString(PubmedData)).append("\n");
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
