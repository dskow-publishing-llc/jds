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

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * ResultC
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-06-26T09:41:10.684-04:00")
public class ResultC {
	@SerializedName("header")
	private HeaderC header = null;

	@SerializedName("esearchresult")
	private SearchResultC esearchresult = null;

	public ResultC header(HeaderC header) {
		this.header = header;
		return this;
	}

	/**
	 * A header
	 * 
	 * @return header
	 **/
	@ApiModelProperty(example = "null", value = "A header")
	public HeaderC getHeader() {
		return header;
	}

	public void setHeader(HeaderC header) {
		this.header = header;
	}

	public ResultC esearchresult(SearchResultC esearchresult) {
		this.esearchresult = esearchresult;
		return this;
	}

	/**
	 * The search result
	 * 
	 * @return esearchresult
	 **/
	@ApiModelProperty(example = "null", value = "The search result")
	public SearchResultC getEsearchresult() {
		return esearchresult;
	}

	public void setEsearchresult(SearchResultC esearchresult) {
		this.esearchresult = esearchresult;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResultC resultC = (ResultC) o;
		return Objects.equals(this.header, resultC.header) && Objects.equals(this.esearchresult, resultC.esearchresult);
	}

	@Override
	public int hashCode() {
		return Objects.hash(header, esearchresult);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResultC {\n");

		sb.append("    header: ").append(toIndentedString(header)).append("\n");
		sb.append("    esearchresult: ").append(toIndentedString(esearchresult)).append("\n");
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
