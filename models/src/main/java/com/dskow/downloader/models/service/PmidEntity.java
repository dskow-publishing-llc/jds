package com.dskow.downloader.models.service;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.dskow.downloader.models.xml.PMID;

import io.swagger.annotations.ApiModelProperty;

public class PmidEntity {

	@JsonProperty("content")
	private String content = null;

	@JsonProperty("version")
	private String version = null;

	public PmidEntity() {
		super();
	}

	public PmidEntity(PMID pmid) {
		super();
		if (pmid == null) {
			return;
		}
	}

	public PmidEntity content(String content) {
		this.content = content;
		return this;
	}

	/**
	 * The pmid content.
	 * 
	 * @return content
	 **/
	@ApiModelProperty(value = "The pmid content.")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public PmidEntity version(String version) {
		this.version = version;
		return this;
	}

	/**
	 * The pmid version.
	 * 
	 * @return version
	 **/
	@ApiModelProperty(value = "The pmid version.")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PmidEntity pmidEntity = (PmidEntity) o;
		return Objects.equals(this.content, pmidEntity.content) && Objects.equals(this.version, pmidEntity.version);
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, version);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PmidEntity {\n");

		sb.append("    content: ").append(toIndentedString(content)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
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
