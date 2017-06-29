package com.dskow.downloader.models.service;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.dskow.downloader.models.xml.AbstractText;

import io.swagger.annotations.ApiModelProperty;

public class AbstractTextEntity {

	@JsonProperty("content")
	private String content = null;

	@JsonProperty("label")
	private String label = null;

	public AbstractTextEntity() {
		super();
	}

	public AbstractTextEntity(AbstractText j) {
		super();
		if (j == null) {
			return;
		}
		this.setContent(j.getContent());
		this.setLabel(j.getLabel());
	}

	public AbstractTextEntity content(String content) {
		this.content = content;
		return this;
	}

	/**
	 * The abstract text content.
	 * 
	 * @return content
	 **/
	@ApiModelProperty(value = "The abstract text content.")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public AbstractTextEntity label(String label) {
		this.label = label;
		return this;
	}

	/**
	 * The abstract text label.
	 * 
	 * @return abstract text label
	 **/
	@ApiModelProperty(value = "The abstract text label.")
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AbstractTextEntity journalEntity = (AbstractTextEntity) o;
		return Objects.equals(this.content, journalEntity.content) && Objects.equals(this.label, journalEntity.label);
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, label);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AbstractTextEntity {\n");

		sb.append("    content: ").append(toIndentedString(content)).append("\n");
		sb.append("    label: ").append(toIndentedString(label)).append("\n");
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
