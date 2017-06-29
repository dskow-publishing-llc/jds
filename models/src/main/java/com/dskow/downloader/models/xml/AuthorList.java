package com.dskow.downloader.models.xml;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class AuthorList implements Serializable {

	/**
	 * serial Version UID.
	 */
	private static final long serialVersionUID = 3894371071275083781L;

	@XmlElement(name = "Author")
	private List<Author> Author;
	
	public List<Author> getAuthor() {
		return Author;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AuthorList {\n");

		sb.append("    Author: ").append(toIndentedString(Author)).append("\n");
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
