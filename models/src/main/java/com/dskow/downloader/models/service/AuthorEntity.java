package com.dskow.downloader.models.service;

import java.util.Objects;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.dskow.downloader.models.xml.Author;

import io.swagger.annotations.ApiModelProperty;

public class AuthorEntity {

	@JsonProperty("valid")
	private String valid;

	@XmlElement(name = "lastName")
	private String lastName;

	@XmlElement(name = "foreName")
	private String foreName;

	@XmlElement(name = "initials")
	private String initials;

	@XmlElement(name = "affiliation")
	private String affiliation;

	public AuthorEntity() {
		super();
	}

	public AuthorEntity(Author j) {
		super();
		if (j == null) {
			return;
		}
		this.setAffiliation(j.getAffiliationInfo() != null ? j.getAffiliationInfo().getAffiliation() : null);
		this.setForeName(j.getForeName());
		this.setInitials(j.getInitials());
		this.setLastName(j.getLastName());
		this.setValid(j.getValidYN());
	}

	public AuthorEntity valid(String valid) {
		this.valid = valid;
		return this;
	}

	/**
	 * If is author valid.
	 * 
	 * @return valid
	 **/
	@ApiModelProperty(value = "If is author valid.")
	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public AuthorEntity lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	/**
	 * The author lastName.
	 * 
	 * @return lastName
	 **/
	@ApiModelProperty(value = "The author lastName.")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public AuthorEntity foreName(String foreName) {
		this.foreName = foreName;
		return this;
	}

	/**
	 * The author foreName.
	 * 
	 * @return foreName
	 **/
	@ApiModelProperty(value = "The author foreName.")
	public String getForeName() {
		return foreName;
	}

	public void setForeName(String foreName) {
		this.foreName = foreName;
	}

	public AuthorEntity initials(String initials) {
		this.initials = initials;
		return this;
	}

	/**
	 * The author initials.
	 * 
	 * @return initials
	 **/
	@ApiModelProperty(value = "The author initials.")
	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public AuthorEntity affiliation(String affiliation) {
		this.affiliation = affiliation;
		return this;
	}

	/**
	 * The author affiliation.
	 * 
	 * @return affiliation
	 **/
	@ApiModelProperty(value = "The author affiliation.")
	public String getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AuthorEntity authorEntity = (AuthorEntity) o;
		return Objects.equals(this.valid, authorEntity.valid) && Objects.equals(this.lastName, authorEntity.lastName)
				&& Objects.equals(this.foreName, authorEntity.foreName)
				&& Objects.equals(this.initials, authorEntity.initials)
				&& Objects.equals(this.affiliation, authorEntity.affiliation);
	}

	@Override
	public int hashCode() {
		return Objects.hash(valid, lastName, foreName, initials, affiliation);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AuthorEntity {\n");

		sb.append("    valid: ").append(toIndentedString(valid)).append("\n");
		sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
		sb.append("    foreName: ").append(toIndentedString(foreName)).append("\n");
		sb.append("    initials: ").append(toIndentedString(initials)).append("\n");
		sb.append("    affiliation: ").append(toIndentedString(affiliation)).append("\n");
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
