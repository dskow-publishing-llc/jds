package com.dskow.downloader.models.mongo;

import java.util.Objects;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.dskow.downloader.models.client.ResultC;
import com.dskow.downloader.models.client.SearchResultC;
import com.dskow.downloader.models.service.MedlineCitationEntity;
import com.dskow.downloader.models.service.PubmedArticleEntity;
import com.dskow.downloader.models.service.PubmedDataEntity;

import io.swagger.annotations.ApiModelProperty;

@Document(collection = "Journals")
public class PubmedArticle {

	public PubmedArticle() {
		super();
		id = UUID.randomUUID().toString();
	}

	public PubmedArticle(PubmedArticleEntity pe) {
		super();
		if (pe != null) {
			id = pe.getId() != null ? pe.getId().toString() : UUID.randomUUID().toString();
		}
		this.setMedlineCitation(pe.getMedlineCitation());
		this.setPubmedData(pe.getPubmedData());
	}

	public PubmedArticle(ResultC fetchItem) {
		super();
		SearchResultC item = fetchItem.getEsearchresult();
		if (item == null) {
			return;
		}
	}

	public PubmedArticle(com.dskow.downloader.models.xml.PubmedArticle article) {
		super();
		if (article == null) {
			return;
		}
		this.setId(article.getId());
		this.setMedlineCitation(new MedlineCitationEntity(article.getMedlineCitation()));
		this.setPubmedData(new PubmedDataEntity(article.getPubmedData()));
	}

	@Id
	private String id;

	@JsonProperty("PubmedData")
	private PubmedDataEntity pubmedData = null;

	@JsonProperty("MedlineCitation")
	private MedlineCitationEntity medlineCitation = null;

	public PubmedArticle id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PubmedArticle pubmedData(PubmedDataEntity pubmedData) {
		this.pubmedData = pubmedData;
		return this;
	}

	/**
	 * Get pubmedData
	 * 
	 * @return pubmedData
	 **/
	@ApiModelProperty(value = "")
	public PubmedDataEntity getPubmedData() {
		return pubmedData;
	}

	public void setPubmedData(PubmedDataEntity pubmedDataEntity) {
		this.pubmedData = pubmedDataEntity;
	}

	public PubmedArticle medlineCitation(MedlineCitationEntity medlineCitation) {
		this.medlineCitation = medlineCitation;
		return this;
	}

	/**
	 * Get medlineCitation
	 * 
	 * @return medlineCitation
	 **/
	@ApiModelProperty(value = "")
	public MedlineCitationEntity getMedlineCitation() {
		return medlineCitation;
	}

	public void setMedlineCitation(MedlineCitationEntity medlineCitationEntity) {
		this.medlineCitation = medlineCitationEntity;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PubmedArticle journal = (PubmedArticle) o;
		return Objects.equals(this.id, journal.id) && Objects.equals(this.pubmedData, journal.pubmedData)
				&& Objects.equals(this.medlineCitation, journal.medlineCitation);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, pubmedData, medlineCitation);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Journal {\n");

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
