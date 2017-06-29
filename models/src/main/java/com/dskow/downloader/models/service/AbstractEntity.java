package com.dskow.downloader.models.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.dskow.downloader.models.xml.Abstract;
import com.dskow.downloader.models.xml.AbstractText;

import io.swagger.annotations.ApiModelProperty;

public class AbstractEntity {

	@JsonProperty("abstractTexts")
	private List<AbstractTextEntity> abstractTexts = null;

	public AbstractEntity() {
		super();
	}

	public AbstractEntity(Abstract j) {
		super();
		if (j == null) {
			return;
		}
		List<AbstractTextEntity> list = null;
		List<AbstractText> xmllist = j.getAbstractText();
		if (xmllist != null) {
			list = new ArrayList<AbstractTextEntity>();
			for (AbstractText a : xmllist) {
				list.add(new AbstractTextEntity(a));
			}
		}
		this.setAbstractTexts(list);
	}

	public AbstractEntity abstractTexts(List<AbstractTextEntity> abstractTexts) {
		this.abstractTexts = abstractTexts;
		return this;
	}

	/**
	 * The abstract texts.
	 * 
	 * @return abstractTexts
	 **/
	@ApiModelProperty(value = "The abstract texts.")
	public List<AbstractTextEntity> getAbstractTexts() {
		return abstractTexts;
	}

	public void addAbstractText(AbstractTextEntity abstractText) {
		this.abstractTexts.add(abstractText);
	}

	public void setAbstractTexts(List<AbstractTextEntity> abstractTexts) {
		this.abstractTexts = abstractTexts;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AbstractEntity journalEntity = (AbstractEntity) o;
		return Objects.equals(this.abstractTexts, journalEntity.abstractTexts);
	}

	@Override
	public int hashCode() {
		return Objects.hash(abstractTexts);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AbstractEntity {\n");

		sb.append("    abstractTexts: ").append(toIndentedString(abstractTexts)).append("\n");
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
