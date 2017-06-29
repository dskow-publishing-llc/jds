package com.dskow.downloader.models.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class PublicationType implements Serializable {

	/**
	 * serial Version UID.
	 */
	private static final long serialVersionUID = 2802302366648356907L;

	@XmlValue
	private String content;

	@XmlAttribute(name = "UI")
	private String UI;

	public String getContent() {
		return content;
	}

	public String getUi() {
		return UI;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PublicationType {\n");

		sb.append("    UI: ").append(toIndentedString(UI)).append("\n");
		sb.append("    content: ").append(toIndentedString(content)).append("\n");
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
