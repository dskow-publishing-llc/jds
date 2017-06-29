package com.dskow.downloader.models.service;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.dskow.downloader.models.xml.ELocationID;

import io.swagger.annotations.ApiModelProperty;

public class ELocationIDEntity {

	@JsonProperty("content")
	private String content = null;

	@JsonProperty("eIdType")
	private String eIdType = null;

	@JsonProperty("valid")
	private String valid = null;

	public ELocationIDEntity() {
		super();
	}

	public ELocationIDEntity(ELocationID eLocationId) {
		super();
		if (eLocationId == null) {
			return;
		}
		this.setContent(eLocationId.getContent());
		this.setEIdType(eLocationId.getEIdType());
		this.setValid(eLocationId.getValidYN());
	}

	public ELocationIDEntity content(String content) {
		this.content = content;
		return this;
	}

	/**
	 * The elocation id content.
	 * 
	 * @return content
	 **/
	@ApiModelProperty(value = "The elocation id content.")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ELocationIDEntity eIdType(String eIdType) {
		this.eIdType = eIdType;
		return this;
	}

	/**
	 * The elocation id eIdType.
	 * 
	 * @return eIdType
	 **/
	@ApiModelProperty(value = "The elocation id eIdType.")
	public String getEIdType() {
		return eIdType;
	}

	public void setEIdType(String eIdType) {
		this.eIdType = eIdType;
	}

	public ELocationIDEntity valid(String valid) {
		this.valid = valid;
		return this;
	}

	/**
	 * If elocation id is valid.
	 * 
	 * @return valid
	 **/
	@ApiModelProperty(value = "The elocation id valid.")
	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ELocationIDEntity eLocationIDEntity = (ELocationIDEntity) o;
		return Objects.equals(this.content, eLocationIDEntity.content)
				&& Objects.equals(this.eIdType, eLocationIDEntity.eIdType)
				&& Objects.equals(this.valid, eLocationIDEntity.valid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, eIdType, valid);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ELocationIDEntity {\n");

		sb.append("    content: ").append(toIndentedString(content)).append("\n");
		sb.append("    eIdType: ").append(toIndentedString(eIdType)).append("\n");
		sb.append("    valid: ").append(toIndentedString(valid)).append("\n");
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
