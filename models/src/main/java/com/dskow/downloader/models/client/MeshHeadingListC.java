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
 * MeshHeadingListC
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-06-26T09:41:10.684-04:00")
public class MeshHeadingListC {
	@SerializedName("MeshHeading")
	private List<MeshHeadingItemC> meshHeading = new ArrayList<MeshHeadingItemC>();

	public MeshHeadingListC meshHeading(List<MeshHeadingItemC> meshHeading) {
		this.meshHeading = meshHeading;
		return this;
	}

	public MeshHeadingListC addMeshHeadingItem(MeshHeadingItemC meshHeadingItem) {
		this.meshHeading.add(meshHeadingItem);
		return this;
	}

	/**
	 * The fetch warning quoted phrases not found
	 * 
	 * @return meshHeading
	 **/
	@ApiModelProperty(example = "null", value = "The fetch warning quoted phrases not found")
	public List<MeshHeadingItemC> getMeshHeading() {
		return meshHeading;
	}

	public void setMeshHeading(List<MeshHeadingItemC> meshHeading) {
		this.meshHeading = meshHeading;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		MeshHeadingListC meshHeadingListC = (MeshHeadingListC) o;
		return Objects.equals(this.meshHeading, meshHeadingListC.meshHeading);
	}

	@Override
	public int hashCode() {
		return Objects.hash(meshHeading);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class MeshHeadingListC {\n");

		sb.append("    meshHeading: ").append(toIndentedString(meshHeading)).append("\n");
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
