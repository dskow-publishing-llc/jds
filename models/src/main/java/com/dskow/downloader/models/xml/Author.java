package com.dskow.downloader.models.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Author implements Serializable {

	/**
	 * serial Version UID.
	 */
	private static final long serialVersionUID = 7123839421045851264L;

	@XmlAttribute(name = "ValidYN")
	private String ValidYN;

	@XmlElement(name = "LastName")
	private String LastName;

	@XmlElement(name = "ForeName")
	private String ForeName;

	@XmlElement(name = "Initials")
	private String Initials;

	@XmlElement(name = "AffiliationInfo")
	private AffiliationInfo AffiliationInfo;

	public String getValidYN() {
		return ValidYN;
	}

	public String getLastName() {
		return LastName;
	}

	public String getForeName() {
		return ForeName;
	}
	public String getInitials() {
		return Initials;
	}

	public AffiliationInfo getAffiliationInfo() {
		return AffiliationInfo;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Author {\n");

		sb.append("    ValidYN: ").append(toIndentedString(ValidYN)).append("\n");
		sb.append("    LastName: ").append(toIndentedString(LastName)).append("\n");
		sb.append("    ForeName: ").append(toIndentedString(ForeName)).append("\n");
		sb.append("    Initials: ").append(toIndentedString(Initials)).append("\n");
		sb.append("    AffiliationInfo: ").append(toIndentedString(AffiliationInfo)).append("\n");
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
