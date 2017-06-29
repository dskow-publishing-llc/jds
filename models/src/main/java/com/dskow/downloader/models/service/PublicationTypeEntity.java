package com.dskow.downloader.models.service;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.dskow.downloader.models.xml.PublicationType;

import io.swagger.annotations.ApiModelProperty;

public class PublicationTypeEntity {

	@JsonProperty("content")
	private String content = null;

	@JsonProperty("ui")
	private String ui = null;

	public PublicationTypeEntity() {
		super();
	}

	public PublicationTypeEntity(PublicationType p) {
		super();
		if (p == null) {
			return;
		}
		this.setContent(p.getContent());
		this.setUi(p.getUi());
	}

	public PublicationTypeEntity content(String content) {
		this.content = content;
		return this;
	}

	/**
	 * The publication type content.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "The publication type content.")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public PublicationTypeEntity ui(String ui) {
		this.ui = ui;
		return this;
	}

	/**
	 * The publication type ui.
	 * 
	 * @return ui
	 **/
	@ApiModelProperty(value = "The publication type ui.")
	public String getUi() {
		return ui;
	}

	public void setUi(String ui) {
		this.ui = ui;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PublicationTypeEntity publicationTypeEntity = (PublicationTypeEntity) o;
		return Objects.equals(this.content, publicationTypeEntity.content)
				&& Objects.equals(this.ui, publicationTypeEntity.ui);
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, ui);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PublicationTypeEntity {\n");

		sb.append("    content: ").append(toIndentedString(content)).append("\n");
		sb.append("    ui: ").append(toIndentedString(ui)).append("\n");
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
