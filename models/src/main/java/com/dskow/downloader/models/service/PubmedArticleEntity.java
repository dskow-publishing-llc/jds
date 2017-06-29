package com.dskow.downloader.models.service;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.dskow.downloader.models.mongo.PubmedArticle;

import io.swagger.annotations.ApiModelProperty;

/**
 * JournalEntity
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-06-22T15:15:38.215-04:00")

public class PubmedArticleEntity {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("pubmedData")
	private PubmedDataEntity pubmedData = null;

	@JsonProperty("medlineCitation")
	private MedlineCitationEntity medlineCitation = null;

	public PubmedArticleEntity() {
		super();
	}

	public PubmedArticleEntity(PubmedArticle j) {
		super();
		if (j == null) {
			return;
		}
		this.setId(j.getId());
		this.setMedlineCitation(j.getMedlineCitation());
		this.setPubmedData(j.getPubmedData());
	}

	public PubmedArticleEntity(com.dskow.downloader.models.xml.PubmedArticle j) {
		super();
		if (j == null) {
			return;
		}
		this.setId(j.getId());
		this.setMedlineCitation(new MedlineCitationEntity(j.getMedlineCitation()));
		this.setPubmedData(new PubmedDataEntity(j.getPubmedData()));
	}

	public PubmedArticleEntity id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * The journal type.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "The journal type.")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PubmedArticleEntity pubmedData(PubmedDataEntity pubmedData) {
		this.pubmedData = pubmedData;
		return this;
	}

	/**
	 * The journal pubmedData.
	 * 
	 * @return pubmedData
	 **/
	@ApiModelProperty(value = "The journal pubmedData.")
	public PubmedDataEntity getPubmedData() {
		return pubmedData;
	}

	public void setPubmedData(PubmedDataEntity pubmedData) {
		this.pubmedData = pubmedData;
	}

	public PubmedArticleEntity medlineCitation(MedlineCitationEntity medlineCitation) {
		this.medlineCitation = medlineCitation;
		return this;
	}

	/**
	 * The journal medlineCitation.
	 * 
	 * @return medlineCitation
	 **/
	@ApiModelProperty(value = "The journal medlineCitation.")
	public MedlineCitationEntity getMedlineCitation() {
		return medlineCitation;
	}

	public void setMedlineCitation(MedlineCitationEntity medlineCitation) {
		this.medlineCitation = medlineCitation;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PubmedArticleEntity pubmedArticleEntity = (PubmedArticleEntity) o;
		return Objects.equals(this.id, pubmedArticleEntity.id) && Objects.equals(this.pubmedData, pubmedArticleEntity.pubmedData)
				&& Objects.equals(this.medlineCitation, pubmedArticleEntity.medlineCitation);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, pubmedData, medlineCitation);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PubmedArticleEntity {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    pubmedData: ").append(toIndentedString(pubmedData)).append("\n");
		sb.append("    medlineCitation: ").append(toIndentedString(medlineCitation)).append("\n");
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
