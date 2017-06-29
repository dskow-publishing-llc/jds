package com.dskow.downloader.models.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Article implements Serializable {

	/**
	 * serial Version UID.
	 */
	private static final long serialVersionUID = -5831479382796057225L;

	@XmlAttribute(name = "PubModel")
	private String PubModel;

	@XmlElement(name = "Journal")
	private Journal Journal;

	@XmlElement(name = "ArticleTitle")
	private String ArticleTitle;

	@XmlElement(name = "ELocationID")
	private ELocationID ELocationID;

	@XmlElement(name = "Abstract")
	private Abstract Abstract;

	@XmlElement(name = "AuthorList")
	private AuthorList AuthorList;

	@XmlElement(name = "Language")
	private String Language;

	@XmlElement(name = "PublicationTypeList")
	private PublicationTypeList PublicationTypeList;

	@XmlElement(name = "ArticleDate")
	private com.dskow.downloader.models.xml.ArticleDate ArticleDate;

	public Abstract getAbstractItem() {
		return Abstract;
	}

	public ArticleDate getArticleDate() {
		return ArticleDate;
	}

	public AuthorList getArthorList() {
		return AuthorList;
	}

	public ELocationID getELocationId() {
		return ELocationID;
	}

	public Journal getJournal() {
		return Journal;
	}

	public String getLanguage() {
		return Language;
	}

	public String getArticleTitle() {
		return ArticleTitle;
	}

	public PublicationTypeList getPublicationTypeList() {
		return PublicationTypeList;
	}

	public String getPubModel() {
		return PubModel;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Article {\n");

		sb.append("    PubModel: ").append(toIndentedString(PubModel)).append("\n");
		sb.append("    Journal: ").append(toIndentedString(Journal)).append("\n");
		sb.append("    ArticleTitle: ").append(toIndentedString(ArticleTitle)).append("\n");
		sb.append("    ELocationID: ").append(toIndentedString(ELocationID)).append("\n");
		sb.append("    Abstract: ").append(toIndentedString(Abstract)).append("\n");
		sb.append("    AuthorList: ").append(toIndentedString(AuthorList)).append("\n");
		sb.append("    Language: ").append(toIndentedString(Language)).append("\n");
		sb.append("    PublicationTypeList: ").append(toIndentedString(PublicationTypeList)).append("\n");
		sb.append("    ArticleDate: ").append(toIndentedString(ArticleDate)).append("\n");
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
