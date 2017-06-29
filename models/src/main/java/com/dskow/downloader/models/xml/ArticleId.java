package com.dskow.downloader.models.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class ArticleId implements Serializable {

	/**
	 * serial Version UID.
	 */
	private static final long serialVersionUID = -8838663872034202561L;

	@XmlValue
	protected String content;

	@XmlAttribute(name = "IdType")
	private String IdType;

	public String getContent() {
		return content;
	}

	public String getIdType() {
		return IdType;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ArticleId {\n");

		sb.append("    content: ").append(toIndentedString(content)).append("\n");
		sb.append("    IdType: ").append(toIndentedString(IdType)).append("\n");
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
