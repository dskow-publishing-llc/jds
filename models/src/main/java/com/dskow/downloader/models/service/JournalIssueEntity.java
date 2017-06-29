package com.dskow.downloader.models.service;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.dskow.downloader.models.xml.JournalIssue;

import io.swagger.annotations.ApiModelProperty;

public class JournalIssueEntity {
	@JsonProperty("citedMedium")
	private String citedMedium = null;

	@JsonProperty("volume")
	private String volume = null;

	@JsonProperty("issue")
	private String issue = null;

	@JsonProperty("pubDate")
	private DateEntity pubDate = null;

	public JournalIssueEntity() {
		super();
	}

	public JournalIssueEntity(JournalIssue j) {
		super();
		if (j == null) {
			return;
		}
		this.setCitedMedium(j.getCitedMedium());
		this.setIssue(j.getIssue());
		this.setPubDate(new DateEntity(j.getPubDate()));
		this.setVolume(j.getVolume());
	}

	public JournalIssueEntity citedMedium(String citedMedium) {
		this.citedMedium = citedMedium;
		return this;
	}

	/**
	 * The journal issue citedMedium.
	 * 
	 * @return citedMedium
	 **/
	@ApiModelProperty(value = "The journal issue citedMedium.")
	public String getCitedMedium() {
		return citedMedium;
	}

	public void setCitedMedium(String citedMedium) {
		this.citedMedium = citedMedium;
	}

	public JournalIssueEntity volume(String volume) {
		this.volume = volume;
		return this;
	}

	/**
	 * The journal issue volume.
	 * 
	 * @return volume
	 **/
	@ApiModelProperty(value = "The journal issue volume.")
	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public JournalIssueEntity issue(String issue) {
		this.issue = issue;
		return this;
	}

	/**
	 * The journal issue issue.
	 * 
	 * @return issue
	 **/
	@ApiModelProperty(value = "The journal issue issue.")
	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public JournalIssueEntity pubDate(DateEntity pubDate) {
		this.pubDate = pubDate;
		return this;
	}

	/**
	 * The journal issue pubDate.
	 * 
	 * @return issue
	 **/
	@ApiModelProperty(value = "The journal issue pubDate.")
	public DateEntity getPubDate() {
		return pubDate;
	}

	public void setPubDate(DateEntity pubDate) {
		this.pubDate = pubDate;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		JournalIssueEntity journalIssueEntity = (JournalIssueEntity) o;
		return Objects.equals(this.citedMedium, journalIssueEntity.citedMedium)
				&& Objects.equals(this.volume, journalIssueEntity.volume)
				&& Objects.equals(this.issue, journalIssueEntity.issue)
				&& Objects.equals(this.pubDate, journalIssueEntity.pubDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(citedMedium, volume, issue, pubDate);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class JournalIssueEntity {\n");

		sb.append("    citedMedium: ").append(toIndentedString(citedMedium)).append("\n");
		sb.append("    volume: ").append(toIndentedString(volume)).append("\n");
		sb.append("    issue: ").append(toIndentedString(issue)).append("\n");
		sb.append("    pubDate: ").append(toIndentedString(pubDate)).append("\n");
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
