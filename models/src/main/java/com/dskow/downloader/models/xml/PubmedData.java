package com.dskow.downloader.models.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class PubmedData implements Serializable {

	/**
	 * serial Version UID.
	 */
	private static final long serialVersionUID = 9036196761044493992L;

	@XmlElement(name = "History")
	private History History;

	@XmlElement(name = "PublicationStatus")
	private String PublicationStatus;

	@XmlElement(name = "ArticleIdList")
	private ArticleIdList ArticleIdList;

	public History getHistory() {
		return History;
	}

	public String getPublicationStatus() {
		return PublicationStatus;
	}

	public ArticleIdList getArticleIdList() {
		return ArticleIdList;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PubmedData {\n");

		sb.append("    History: ").append(toIndentedString(History)).append("\n");
		sb.append("    PublicationStatus: ").append(toIndentedString(PublicationStatus)).append("\n");
		sb.append("    ArticleIdList: ").append(toIndentedString(ArticleIdList)).append("\n");
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
