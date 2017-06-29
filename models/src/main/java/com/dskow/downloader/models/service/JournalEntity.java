package com.dskow.downloader.models.service;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.dskow.downloader.models.xml.Journal;

import io.swagger.annotations.ApiModelProperty;

public class JournalEntity {

	@JsonProperty("issn")
	private IssnEntity issn = null;

	@JsonProperty("journalIssue")
	private JournalIssueEntity journalIssue = null;

	@JsonProperty("title")
	private String title = null;

	@JsonProperty("isoAbbreviation")
	private String isoAbbreviation = null;

	public JournalEntity() {
		super();
	}

	public JournalEntity(Journal journal) {
		super();
		if (journal == null) {
			return;
		}
	}

	public JournalEntity issn(IssnEntity issn) {
		this.issn = issn;
		return this;
	}

	/**
	 * The journal issn.
	 * 
	 * @return issn
	 **/
	@ApiModelProperty(value = "The journal issn.")
	public IssnEntity getIssn() {
		return issn;
	}

	public void setIssn(IssnEntity issn) {
		this.issn = issn;
	}

	public JournalEntity journalIssue(JournalIssueEntity journalIssue) {
		this.journalIssue = journalIssue;
		return this;
	}

	/**
	 * The journal journalIssue.
	 * 
	 * @return journalIssue
	 **/
	@ApiModelProperty(value = "The journal journalIssue.")
	public JournalIssueEntity getJournalIssue() {
		return journalIssue;
	}

	public void setJournalIssue(JournalIssueEntity journalIssue) {
		this.journalIssue = journalIssue;
	}

	public JournalEntity title(String title) {
		this.title = title;
		return this;
	}

	/**
	 * The journal title.
	 * 
	 * @return title
	 **/
	@ApiModelProperty(value = "The journal title.")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public JournalEntity isoAbbreviation(String isoAbbreviation) {
		this.isoAbbreviation = isoAbbreviation;
		return this;
	}

	/**
	 * The journal isoAbbreviation.
	 * 
	 * @return isoAbbreviation
	 **/
	@ApiModelProperty(value = "The journal isoAbbreviation.")
	public String getIsoAbbreviation() {
		return isoAbbreviation;
	}

	public void setIsoAbbreviation(String isoAbbreviation) {
		this.isoAbbreviation = isoAbbreviation;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		JournalEntity journalEntity = (JournalEntity) o;
		return Objects.equals(this.issn, journalEntity.issn)
				&& Objects.equals(this.journalIssue, journalEntity.journalIssue)
				&& Objects.equals(this.title, journalEntity.title)
				&& Objects.equals(this.isoAbbreviation, journalEntity.isoAbbreviation);
	}

	@Override
	public int hashCode() {
		return Objects.hash(issn, journalIssue, title, isoAbbreviation);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class JournalEntity {\n");

		sb.append("    issn: ").append(toIndentedString(issn)).append("\n");
		sb.append("    journalIssue: ").append(toIndentedString(journalIssue)).append("\n");
		sb.append("    title: ").append(toIndentedString(title)).append("\n");
		sb.append("    isoAbbreviation: ").append(toIndentedString(isoAbbreviation)).append("\n");
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
