package com.dskow.downloader.models.service;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.dskow.downloader.models.xml.ArticleId;

import io.swagger.annotations.ApiModelProperty;

public class ArticleIdEntity {

	@JsonProperty("content")
	private String content = null;

	@JsonProperty("idType")
	private String idType = null;

	public ArticleIdEntity() {
		super();
	}

	public ArticleIdEntity(ArticleId i) {
		super();
		if (i == null) {
			return;
		}
	}

	public ArticleIdEntity content(String content) {
		this.content = content;
		return this;
	}

	/**
	 * The article id content.
	 * 
	 * @return content
	 **/
	@ApiModelProperty(value = "The article id content.")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ArticleIdEntity idType(String idType) {
		this.idType = idType;
		return this;
	}

	/**
	 * The article id idType.
	 * 
	 * @return idType
	 **/
	@ApiModelProperty(value = "The article id idType.")
	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ArticleIdEntity articleIdEntity = (ArticleIdEntity) o;
		return Objects.equals(this.content, articleIdEntity.content)
				&& Objects.equals(this.idType, articleIdEntity.idType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, idType);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ArticleIdEntity {\n");

		sb.append("    content: ").append(toIndentedString(content)).append("\n");
		sb.append("    idType: ").append(toIndentedString(idType)).append("\n");
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
