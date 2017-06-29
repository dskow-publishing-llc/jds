package com.dskow.downloader.models.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class PubDate implements Serializable {

	/**
	 * serial Version UID.
	 */
	private static final long serialVersionUID = 6375273085775067828L;

	@XmlElement(name = "Year")
	private String Year;

	@XmlElement(name = "Month")
	private String Month;

	@XmlElement(name = "Day")
	private String Day;

	public String getYear() {
		return Year;
	}

	public String getMonth() {
		return Month;
	}

	public String getDay() {
		return Day;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PubDate {\n");

		sb.append("    Year: ").append(toIndentedString(Year)).append("\n");
		sb.append("    Month: ").append(toIndentedString(Month)).append("\n");
		sb.append("    Day: ").append(toIndentedString(Day)).append("\n");
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
