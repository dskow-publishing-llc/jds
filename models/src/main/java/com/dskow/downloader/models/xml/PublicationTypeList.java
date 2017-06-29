package com.dskow.downloader.models.xml;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class PublicationTypeList implements Serializable {

	/**
	 * serial Version UID.
	 */
	private static final long serialVersionUID = -815289166294754476L;

	@XmlElement(name = "PublicationType")
	private List<PublicationType> PublicationType;

	public List<PublicationType> getPublicationType() {
		return PublicationType;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PublicationTypeList {\n");

		sb.append("    PublicationType: ").append(toIndentedString(PublicationType)).append("\n");
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
