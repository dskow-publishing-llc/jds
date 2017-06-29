package com.dskow.downloader.models.service;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.dskow.downloader.models.xml.MedlineJournalInfo;

import io.swagger.annotations.ApiModelProperty;

public class MedlineJournalInfoEntity {

	@JsonProperty("country")
	private String country = null;

	@JsonProperty("medlineTA")
	private String medlineTA = null;

	@JsonProperty("nlmUniqueID")
	private String nlmUniqueID = null;

	@JsonProperty("issnLinking")
	private String issnLinking = null;

	public MedlineJournalInfoEntity() {
		super();
	}

	public MedlineJournalInfoEntity(MedlineJournalInfo medlineJournalInfo) {
		super();
		if (medlineJournalInfo == null) {
			return;
		}
		this.setCountry(medlineJournalInfo.getCountry());
		this.setIssnLinking(medlineJournalInfo.getISSNLinking());
		this.setMedlineTA(medlineJournalInfo.getMedlineTA());
		this.setNlmUniqueID(medlineJournalInfo.getNlmUniqueID());
	}

	public MedlineJournalInfoEntity country(String country) {
		this.country = country;
		return this;
	}

	/**
	 * The medline journal info country.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "The medline journal info type.")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public MedlineJournalInfoEntity medlineTA(String medlineTA) {
		this.medlineTA = medlineTA;
		return this;
	}

	/**
	 * The medline journal info medlineTA.
	 * 
	 * @return medlineTA
	 **/
	@ApiModelProperty(value = "The medline journal info medlineTA.")
	public String getMedlineTA() {
		return medlineTA;
	}

	public void setMedlineTA(String medlineTA) {
		this.medlineTA = medlineTA;
	}

	public MedlineJournalInfoEntity nlmUniqueID(String nlmUniqueID) {
		this.nlmUniqueID = nlmUniqueID;
		return this;
	}

	/**
	 * The medline journal info nlmUniqueID.
	 * 
	 * @return nlmUniqueID
	 **/
	@ApiModelProperty(value = "The medline journal info nlmUniqueID.")
	public String getNlmUniqueID() {
		return nlmUniqueID;
	}

	public void setNlmUniqueID(String nlmUniqueID) {
		this.nlmUniqueID = nlmUniqueID;
	}

	public MedlineJournalInfoEntity issnLinking(String issnLinking) {
		this.issnLinking = issnLinking;
		return this;
	}

	/**
	 * The medline journal info issnLinking.
	 * 
	 * @return issnLinking
	 **/
	@ApiModelProperty(value = "The medline journal info issnLinking.")
	public String getIssnLinking() {
		return issnLinking;
	}

	public void setIssnLinking(String issnLinking) {
		this.issnLinking = issnLinking;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		MedlineJournalInfoEntity medlineJournalInfoEntity = (MedlineJournalInfoEntity) o;
		return Objects.equals(this.country, medlineJournalInfoEntity.country)
				&& Objects.equals(this.medlineTA, medlineJournalInfoEntity.medlineTA)
				&& Objects.equals(this.nlmUniqueID, medlineJournalInfoEntity.nlmUniqueID)
				&& Objects.equals(this.issnLinking, medlineJournalInfoEntity.issnLinking);
	}

	@Override
	public int hashCode() {
		return Objects.hash(country, medlineTA, nlmUniqueID, issnLinking);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class MedlineJournalInfoEntity {\n");

		sb.append("    country: ").append(toIndentedString(country)).append("\n");
		sb.append("    medlineTA: ").append(toIndentedString(medlineTA)).append("\n");
		sb.append("    nlmUniqueID: ").append(toIndentedString(nlmUniqueID)).append("\n");
		sb.append("    issnLinking: ").append(toIndentedString(issnLinking)).append("\n");
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
