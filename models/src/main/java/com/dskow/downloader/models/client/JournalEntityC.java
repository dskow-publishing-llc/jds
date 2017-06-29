package com.dskow.downloader.models.client;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * JournalEntity
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-06-22T15:15:38.215-04:00")

public class JournalEntityC {
	@JsonProperty("language")
	private String language = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("file")
	private String file = null;

	public JournalEntityC language(String language) {
		this.language = language;
		return this;
	}

	/**
	 * The journal type.
	 * 
	 * @return language
	 **/
	@ApiModelProperty(value = "The journal type.")
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public JournalEntityC name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * The journal name.
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "The journal name.")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JournalEntityC file(String file) {
		this.file = file;
		return this;
	}

	/**
	 * info.
	 * 
	 * @return file
	 **/
	@ApiModelProperty(value = "info.")
	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		JournalEntityC journalEntity = (JournalEntityC) o;
		return Objects.equals(this.language, journalEntity.language) && Objects.equals(this.name, journalEntity.name)
				&& Objects.equals(this.file, journalEntity.file);
	}

	@Override
	public int hashCode() {
		return Objects.hash(language, name, file);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class JournalEntity {\n");

		sb.append("    language: ").append(toIndentedString(language)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    file: ").append(toIndentedString(file)).append("\n");
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
