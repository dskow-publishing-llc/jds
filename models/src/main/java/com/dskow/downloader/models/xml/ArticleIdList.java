package com.dskow.downloader.models.xml;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class ArticleIdList implements Serializable {

	/**
	 * serial Version UID.
	 */
	private static final long serialVersionUID = -6783827660332523290L;

	@XmlElement(name = "ArticleId")
	private List<ArticleId> ArticleId;

	public List<ArticleId> getArticleId() {
		return ArticleId;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ArticleIdList {\n");

		sb.append("    ArticleId: ").append(toIndentedString(ArticleId)).append("\n");
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
