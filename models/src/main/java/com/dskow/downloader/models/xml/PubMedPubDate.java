package com.dskow.downloader.models.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class PubMedPubDate implements Serializable {

	/**
	 * serial Version UID.
	 */
	private static final long serialVersionUID = 3030479010777384029L;

	@XmlElement(name = "Year")
	private String Year;

	@XmlElement(name = "Month")
	private String Month;

	@XmlElement(name = "Day")
	private String Day;

	@XmlElement(name = "Hour")
	private String Hour;

	@XmlElement(name = "Minute")
	private String Minute;

	@XmlAttribute(name = "PubStatus")
	private String PubStatus;

	public String getYear() {
		return Year;
	}

	public String getMonth() {
		return Month;
	}

	public String getDay() {
		return Day;
	}

	public String getHour() {
		return Hour;
	}

	public String getMinute() {
		return Minute;
	}
	public String getPubStatus() {
		return PubStatus;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PubMedPubDate {\n");

		sb.append("    Year: ").append(toIndentedString(Year)).append("\n");
		sb.append("    Month: ").append(toIndentedString(Month)).append("\n");
		sb.append("    Day: ").append(toIndentedString(Day)).append("\n");
		sb.append("    Hour: ").append(toIndentedString(Hour)).append("\n");
		sb.append("    Minute: ").append(toIndentedString(Minute)).append("\n");
		sb.append("    PubStatus: ").append(toIndentedString(PubStatus)).append("\n");
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
