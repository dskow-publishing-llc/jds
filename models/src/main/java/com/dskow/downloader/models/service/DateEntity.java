package com.dskow.downloader.models.service;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.dskow.downloader.models.xml.ArticleDate;
import com.dskow.downloader.models.xml.DateCreated;
import com.dskow.downloader.models.xml.DateRevised;
import com.dskow.downloader.models.xml.PubDate;
import com.dskow.downloader.models.xml.PubMedPubDate;

import io.swagger.annotations.ApiModelProperty;

public class DateEntity {

	@JsonProperty("year")
	private String year;

	@JsonProperty("month")
	private String month;

	@JsonProperty("day")
	private String day;

	@JsonProperty("hour")
	private String hour;

	@JsonProperty("minute")
	private String minute;

	@JsonProperty("pubStatus")
	private String pubStatus;
	
	public DateEntity() {
		super();
	}

	public DateEntity(DateRevised dateRevised) {
		super();
		if (dateRevised == null) {
			return;
		}
		this.setYear(dateRevised.getYear());
		this.setMonth(dateRevised.getMonth());
		this.setDay(dateRevised.getDay());
	}

	public DateEntity(DateCreated dateCreated) {
		super();
		if (dateCreated == null) {
			return;
		}
		this.setYear(dateCreated.getYear());
		this.setMonth(dateCreated.getMonth());
		this.setDay(dateCreated.getDay());
	}

	public DateEntity(ArticleDate articleDate) {
		super();
		if (articleDate == null) {
			return;
		}
		this.setYear(articleDate.getYear());
		this.setMonth(articleDate.getMonth());
		this.setDay(articleDate.getDay());
	}

	public DateEntity(PubDate pubDate) {
		super();
		if (pubDate == null) {
			return;
		}
		this.setYear(pubDate.getYear());
		this.setMonth(pubDate.getMonth());
		this.setDay(pubDate.getDay());
	}

	public DateEntity(PubMedPubDate pubMedPubDate) {
		super();
		if (pubMedPubDate == null) {
			return;
		}
		this.setYear(pubMedPubDate.getYear());
		this.setMonth(pubMedPubDate.getMonth());
		this.setDay(pubMedPubDate.getDay());
		this.setHour(pubMedPubDate.getHour());
		this.setMinute(pubMedPubDate.getMinute());
		this.setPubStatus(pubMedPubDate.getPubStatus());
	}

	public DateEntity year(String year) {
		this.year = year;
		return this;
	}

	/**
	 * The date year.
	 * 
	 * @return year
	 **/
	@ApiModelProperty(value = "The date year.")
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public DateEntity month(String month) {
		this.month = month;
		return this;
	}

	/**
	 * The date month.
	 * 
	 * @return month
	 **/
	@ApiModelProperty(value = "The date month.")
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public DateEntity day(String day) {
		this.day = day;
		return this;
	}

	/**
	 * The date day.
	 * 
	 * @return day
	 **/
	@ApiModelProperty(value = "The date day.")
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public DateEntity hour(String hour) {
		this.hour = hour;
		return this;
	}

	/**
	 * The date hour.
	 * 
	 * @return hour
	 **/
	@ApiModelProperty(value = "The date hour.")
	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public DateEntity minute(String minute) {
		this.minute = minute;
		return this;
	}

	/**
	 * The date minute.
	 * 
	 * @return minute
	 **/
	@ApiModelProperty(value = "The date minute.")
	public String getMinute() {
		return minute;
	}

	public void setMinute(String minute) {
		this.minute = minute;
	}

	public DateEntity pubStatus(String pubStatus) {
		this.pubStatus = pubStatus;
		return this;
	}

	/**
	 * The date pubStatus.
	 * 
	 * @return pubStatus
	 **/
	@ApiModelProperty(value = "The date pubStatus.")
	public String getPubStatus() {
		return pubStatus;
	}

	public void setPubStatus(String pubStatus) {
		this.pubStatus = pubStatus;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		DateEntity dateEntity = (DateEntity) o;
		return Objects.equals(this.year, dateEntity.year) && Objects.equals(this.month, dateEntity.month)
				&& Objects.equals(this.day, dateEntity.day)&& Objects.equals(this.hour, dateEntity.hour)
				&& Objects.equals(this.minute, dateEntity.minute)
				&& Objects.equals(this.pubStatus, dateEntity.pubStatus);
	}

	@Override
	public int hashCode() {
		return Objects.hash(year, month, day);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class DateEntity {\n");

		sb.append("    year: ").append(toIndentedString(year)).append("\n");
		sb.append("    month: ").append(toIndentedString(month)).append("\n");
		sb.append("    day: ").append(toIndentedString(day)).append("\n");
		sb.append("    hour: ").append(toIndentedString(hour)).append("\n");
		sb.append("    minute: ").append(toIndentedString(minute)).append("\n");
		sb.append("    pubStatus: ").append(toIndentedString(pubStatus)).append("\n");
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
