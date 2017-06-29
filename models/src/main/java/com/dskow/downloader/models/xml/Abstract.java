package com.dskow.downloader.models.xml;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Abstract implements Serializable {

	/**
	 * serial Version UID.
	 */
	private static final long serialVersionUID = -5831479382796057226L;

	@XmlElement(name = "AbstractText")
	private List<AbstractText> AbstractText;

	public List<AbstractText> getAbstractText() {
		return AbstractText;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Abstract {\n");

		sb.append("    AbstractText: ").append(toIndentedString(AbstractText)).append("\n");
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
