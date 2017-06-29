package com.dskow.downloader.models.xml;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PubmedArticleSet")
@XmlAccessorType(XmlAccessType.FIELD)
public class PubmedArticleSet implements Serializable {

	/**
	 * serial Version UID.
	 */
	private static final long serialVersionUID = -8472841751379423856L;

	@XmlElement(name = "PubmedArticle")
	private List<PubmedArticle> pubmedArticleList;

	public List<PubmedArticle> getPubmedArticleList() {
		return pubmedArticleList;
	}

	public void setPubmedArticleList(List<PubmedArticle> pubmedArticleList) {
		this.pubmedArticleList = pubmedArticleList;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PubmedArticleSet {\n");

		sb.append("    PubmedArticle: ").append(toIndentedString(pubmedArticleList)).append("\n");
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
