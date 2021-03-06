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
 * MeshHeadingIteNameC
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-06-26T09:41:10.684-04:00")
public class MeshHeadingIteNameC {
	@SerializedName("-UI")
	private String _UI = null;

	@SerializedName("-MajorTopicYN")
	private String majorTopicYN = null;

	@SerializedName("#text")
	private String text = null;

	public MeshHeadingIteNameC _UI(String _UI) {
		this._UI = _UI;
		return this;
	}

	/**
	 * A header
	 * 
	 * @return _UI
	 **/
	@ApiModelProperty(example = "null", value = "A header")
	public String getUI() {
		return _UI;
	}

	public void setUI(String _UI) {
		this._UI = _UI;
	}

	public MeshHeadingIteNameC majorTopicYN(String majorTopicYN) {
		this.majorTopicYN = majorTopicYN;
		return this;
	}

	/**
	 * A header
	 * 
	 * @return majorTopicYN
	 **/
	@ApiModelProperty(example = "null", value = "A header")
	public String getMajorTopicYN() {
		return majorTopicYN;
	}

	public void setMajorTopicYN(String majorTopicYN) {
		this.majorTopicYN = majorTopicYN;
	}

	public MeshHeadingIteNameC text(String text) {
		this.text = text;
		return this;
	}

	/**
	 * A header
	 * 
	 * @return text
	 **/
	@ApiModelProperty(example = "null", value = "A header")
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		MeshHeadingIteNameC meshHeadingIteNameC = (MeshHeadingIteNameC) o;
		return Objects.equals(this._UI, meshHeadingIteNameC._UI)
				&& Objects.equals(this.majorTopicYN, meshHeadingIteNameC.majorTopicYN)
				&& Objects.equals(this.text, meshHeadingIteNameC.text);
	}

	@Override
	public int hashCode() {
		return Objects.hash(_UI, majorTopicYN, text);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class MeshHeadingIteNameC {\n");

		sb.append("    _UI: ").append(toIndentedString(_UI)).append("\n");
		sb.append("    majorTopicYN: ").append(toIndentedString(majorTopicYN)).append("\n");
		sb.append("    text: ").append(toIndentedString(text)).append("\n");
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
