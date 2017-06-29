package com.dskow.downloader.models.service;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.dskow.downloader.models.xml.ISSN;

import io.swagger.annotations.ApiModelProperty;

public class IssnEntity {
	@JsonProperty("content")
	private String content = null;

	@JsonProperty("type")
	private String type = null;

	public IssnEntity() {
		super();
	}

	public IssnEntity(ISSN j) {
		super();
		if (j == null) {
			return;
		}
		this.setContent(j.getContent());
		this.setType(j.getIssnType());
	}

	public IssnEntity content(String content) {
		this.content = content;
		return this;
	}

	/**
	 * The issn content.
	 * 
	 * @return content
	 **/
	@ApiModelProperty(value = "The issn content.")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public IssnEntity type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * The issn type.
	 * 
	 * @return type
	 **/
	@ApiModelProperty(value = "The issn type.")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		IssnEntity issnEntity = (IssnEntity) o;
		return Objects.equals(this.content, issnEntity.content) && Objects.equals(this.type, issnEntity.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class IssnEntity {\n");

		sb.append("    content: ").append(toIndentedString(content)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
