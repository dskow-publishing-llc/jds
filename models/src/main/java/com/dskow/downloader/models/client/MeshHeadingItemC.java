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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * MeshHeadingItemC
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-06-26T09:41:10.684-04:00")
public class MeshHeadingItemC {
	@SerializedName("DescriptorName")
	private MeshHeadingIteNameC descriptorName = null;

	@SerializedName("QualifierName")
	private List<MeshHeadingIteNameC> qualifierName = new ArrayList<MeshHeadingIteNameC>();

	public MeshHeadingItemC descriptorName(MeshHeadingIteNameC descriptorName) {
		this.descriptorName = descriptorName;
		return this;
	}

	/**
	 * Get descriptorName
	 * 
	 * @return descriptorName
	 **/
	@ApiModelProperty(example = "null", value = "")
	public MeshHeadingIteNameC getDescriptorName() {
		return descriptorName;
	}

	public void setDescriptorName(MeshHeadingIteNameC descriptorName) {
		this.descriptorName = descriptorName;
	}

	public MeshHeadingItemC qualifierName(List<MeshHeadingIteNameC> qualifierName) {
		this.qualifierName = qualifierName;
		return this;
	}

	public MeshHeadingItemC addQualifierNameItem(MeshHeadingIteNameC qualifierNameItem) {
		this.qualifierName.add(qualifierNameItem);
		return this;
	}

	/**
	 * The fetch warning quoted phrases not found
	 * 
	 * @return qualifierName
	 **/
	@ApiModelProperty(example = "null", value = "The fetch warning quoted phrases not found")
	public List<MeshHeadingIteNameC> getQualifierName() {
		return qualifierName;
	}

	public void setQualifierName(List<MeshHeadingIteNameC> qualifierName) {
		this.qualifierName = qualifierName;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		MeshHeadingItemC meshHeadingItemC = (MeshHeadingItemC) o;
		return Objects.equals(this.descriptorName, meshHeadingItemC.descriptorName)
				&& Objects.equals(this.qualifierName, meshHeadingItemC.qualifierName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(descriptorName, qualifierName);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class MeshHeadingItemC {\n");

		sb.append("    descriptorName: ").append(toIndentedString(descriptorName)).append("\n");
		sb.append("    qualifierName: ").append(toIndentedString(qualifierName)).append("\n");
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
