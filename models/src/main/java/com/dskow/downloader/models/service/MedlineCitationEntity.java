package com.dskow.downloader.models.service;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.dskow.downloader.models.xml.MedlineCitation;

import io.swagger.annotations.ApiModelProperty;

public class MedlineCitationEntity {

	@JsonProperty("pmid")
	private PmidEntity pmid = null;

	@JsonProperty("dateCreated")
	private DateEntity dateCreated = null;

	@JsonProperty("dateRevised")
	private DateEntity dateRevised = null;

	@JsonProperty("article")
	private ArticleEntity article = null;

	@JsonProperty("medlineJournalInfo")
	private MedlineJournalInfoEntity medlineJournalInfo = null;

	public MedlineCitationEntity() {
		super();
	}
	
	public MedlineCitationEntity(MedlineCitation medlineCitation) {
		super();
		if (medlineCitation == null) {
			return;
		}
		this.setArticle(new ArticleEntity(medlineCitation.getArticle()));
		this.setDateCreated(new DateEntity(medlineCitation.getDateCreated()));
		this.setDateRevised(new DateEntity(medlineCitation.getDateRevised()));
		this.setMedlineJournalInfo(new MedlineJournalInfoEntity(medlineCitation.getMedlineJournalInfo()));
		this.setPmid(new PmidEntity(medlineCitation.getPmid()));
	}

	public MedlineCitationEntity pmid(PmidEntity pmid) {
		this.pmid = pmid;
		return this;
	}

	/**
	 * The journal pmid.
	 * 
	 * @return pmid
	 **/
	@ApiModelProperty(value = "The journal pmid.")
	public PmidEntity getPmid() {
		return pmid;
	}

	public void setPmid(PmidEntity pmid) {
		this.pmid = pmid;
	}

	public MedlineCitationEntity dateCreated(DateEntity dateCreated) {
		this.dateCreated = dateCreated;
		return this;
	}

	/**
	 * The journal dateCreated.
	 * 
	 * @return dateCreated
	 **/
	@ApiModelProperty(value = "The journal dateCreated.")
	public DateEntity getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(DateEntity dateCreated) {
		this.dateCreated = dateCreated;
	}

	public MedlineCitationEntity dateRevised(DateEntity dateRevised) {
		this.dateRevised = dateRevised;
		return this;
	}

	/**
	 * The journal dateRevised.
	 * 
	 * @return dateRevised
	 **/
	@ApiModelProperty(value = "The journal dateRevised.")
	public DateEntity getDateRevised() {
		return dateRevised;
	}

	public void setDateRevised(DateEntity dateRevised) {
		this.dateRevised = dateRevised;
	}

	public MedlineCitationEntity article(ArticleEntity article) {
		this.article = article;
		return this;
	}

	/**
	 * The journal article.
	 * 
	 * @return article
	 **/
	@ApiModelProperty(value = "The journal article.")
	public ArticleEntity getArticled() {
		return article;
	}

	public void setArticle(ArticleEntity article) {
		this.article = article;
	}

	
	public MedlineCitationEntity medlineJournalInfo(MedlineJournalInfoEntity medlineJournalInfo) {
		this.medlineJournalInfo = medlineJournalInfo;
		return this;
	}

	/**
	 * The journal medlineJournalInfo.
	 * 
	 * @return medlineJournalInfo
	 **/
	@ApiModelProperty(value = "The journal medlineJournalInfo.")
	public MedlineJournalInfoEntity getMedlineJournalInfo() {
		return medlineJournalInfo;
	}

	public void setMedlineJournalInfo(MedlineJournalInfoEntity medlineJournalInfo) {
		this.medlineJournalInfo = medlineJournalInfo;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		MedlineCitationEntity medlineCitationEntity = (MedlineCitationEntity) o;
		return Objects.equals(this.pmid, medlineCitationEntity.pmid)
				&& Objects.equals(this.dateCreated, medlineCitationEntity.dateCreated)
				&& Objects.equals(this.dateRevised, medlineCitationEntity.dateRevised)
				&& Objects.equals(this.article, medlineCitationEntity.article)
				&& Objects.equals(this.medlineJournalInfo, medlineCitationEntity.medlineJournalInfo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(pmid, dateCreated, dateRevised, article, medlineJournalInfo);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class MedlineCitationEntity {\n");

		sb.append("    pmid: ").append(toIndentedString(pmid)).append("\n");
		sb.append("    dateCreated: ").append(toIndentedString(dateCreated)).append("\n");
		sb.append("    dateRevised: ").append(toIndentedString(dateRevised)).append("\n");
		sb.append("    article: ").append(toIndentedString(article)).append("\n");
		sb.append("    medlineJournalInfo: ").append(toIndentedString(medlineJournalInfo)).append("\n");
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
