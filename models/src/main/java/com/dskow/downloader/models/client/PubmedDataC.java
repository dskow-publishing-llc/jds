/*
 * JournDoc Downloader Client API
 * This is a journdoc downloader client
 *
 * OpenAPI spec version: 1.0.0
 * Contact: david@dskow.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.dskow.downloader.models.client;

import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * PubmedDataC
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-06-26T09:41:10.684-04:00")
@XmlRootElement(name = "pubmedData")
@XmlAccessorType(XmlAccessType.FIELD)
public class PubmedDataC {
	@SerializedName("History")
	private HistoryC history = null;

	@SerializedName("PublicationStatus")
	private String publicationStatus = null;

	@SerializedName("ArticleIdList")
	private ArticleIdListC articleIdList = null;

	public PubmedDataC history(HistoryC history) {
		this.history = history;
		return this;
	}

	/**
	 * A header
	 * 
	 * @return history
	 **/
	@ApiModelProperty(example = "null", value = "A header")
	public HistoryC getHistory() {
		return history;
	}

	public void setHistory(HistoryC history) {
		this.history = history;
	}

	public PubmedDataC publicationStatus(String publicationStatus) {
		this.publicationStatus = publicationStatus;
		return this;
	}

	/**
	 * A header
	 * 
	 * @return publicationStatus
	 **/
	@ApiModelProperty(example = "null", value = "A header")
	public String getPublicationStatus() {
		return publicationStatus;
	}

	public void setPublicationStatus(String publicationStatus) {
		this.publicationStatus = publicationStatus;
	}

	public PubmedDataC articleIdList(ArticleIdListC articleIdList) {
		this.articleIdList = articleIdList;
		return this;
	}

	/**
	 * A header
	 * 
	 * @return articleIdList
	 **/
	@ApiModelProperty(example = "null", value = "A header")
	public ArticleIdListC getArticleIdList() {
		return articleIdList;
	}

	public void setArticleIdList(ArticleIdListC articleIdList) {
		this.articleIdList = articleIdList;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PubmedDataC pubmedDataC = (PubmedDataC) o;
		return Objects.equals(this.history, pubmedDataC.history)
				&& Objects.equals(this.publicationStatus, pubmedDataC.publicationStatus)
				&& Objects.equals(this.articleIdList, pubmedDataC.articleIdList);
	}

	@Override
	public int hashCode() {
		return Objects.hash(history, publicationStatus, articleIdList);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PubmedDataC {\n");

		sb.append("    history: ").append(toIndentedString(history)).append("\n");
		sb.append("    publicationStatus: ").append(toIndentedString(publicationStatus)).append("\n");
		sb.append("    articleIdList: ").append(toIndentedString(articleIdList)).append("\n");
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