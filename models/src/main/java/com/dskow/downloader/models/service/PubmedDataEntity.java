package com.dskow.downloader.models.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.dskow.downloader.models.xml.ArticleId;
import com.dskow.downloader.models.xml.History;
import com.dskow.downloader.models.xml.PubMedPubDate;
import com.dskow.downloader.models.xml.PubmedData;

import io.swagger.annotations.ApiModelProperty;

public class PubmedDataEntity {

	@JsonProperty("history")
	private List<DateEntity> history = null;

	@JsonProperty("publicationStatus")
	private String publicationStatus = null;

	@JsonProperty("articleIds")
	private List<ArticleIdEntity> articleIds = null;

	public PubmedDataEntity() {
		super();
	}

	public PubmedDataEntity(PubmedData j) {
		super();
		if (j == null) {
			return;
		}
		List<ArticleIdEntity> list = null;
		List<ArticleId> xmllist = j.getArticleIdList() != null ? j.getArticleIdList().getArticleId() : null;
		if (xmllist != null) {
			list = new ArrayList<ArticleIdEntity>();
			for (ArticleId i : xmllist) {
				list.add(new ArticleIdEntity(i));
			}
		}
		this.setArticleIds(list);
		List<DateEntity> hlist = null;
		History xmlhlist = j.getHistory();
		if (xmlhlist != null) {
			hlist = new ArrayList<DateEntity>();
			List<PubMedPubDate> l = xmlhlist.getPubMedPubDate();
			for (PubMedPubDate p : l) {
				hlist.add(new DateEntity(p));
			}
		}
		this.setHistory(hlist);
		this.setPublicationStatus(j.getPublicationStatus());
	}

	public PubmedDataEntity history(List<DateEntity> history) {
		this.history = history;
		return this;
	}

	/**
	 * The pubmed data history.
	 * 
	 * @return history
	 **/
	@ApiModelProperty(value = "The pubmed data history.")
	public List<DateEntity> getHistory() {
		return history;
	}

	public void addHistory(DateEntity history) {
		this.history.add(history);
	}

	public void setHistory(List<DateEntity> history) {
		this.history = history;
	}

	public PubmedDataEntity publicationStatus(String publicationStatus) {
		this.publicationStatus = publicationStatus;
		return this;
	}

	/**
	 * The pubmed data publicationStatus.
	 * 
	 * @return pubmedData
	 **/
	@ApiModelProperty(value = "The pubmed data publicationStatus.")
	public String getPublicationStatus() {
		return publicationStatus;
	}

	public void setPublicationStatus(String publicationStatus) {
		this.publicationStatus = publicationStatus;
	}

	public PubmedDataEntity articleIds(List<ArticleIdEntity> articleIds) {
		this.articleIds = articleIds;
		return this;
	}

	/**
	 * The pubmed data articleIds.
	 * 
	 * @return articleIds
	 **/
	@ApiModelProperty(value = "The pubmed data articleIds.")
	public List<ArticleIdEntity> getArticleIds() {
		return articleIds;
	}

	public void addArticleId(ArticleIdEntity articleId) {
		this.articleIds.add(articleId);
	}

	public void setArticleIds(List<ArticleIdEntity> articleIds) {
		this.articleIds = articleIds;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PubmedDataEntity pubmedDataEntity = (PubmedDataEntity) o;
		return Objects.equals(this.history, pubmedDataEntity.history)
				&& Objects.equals(this.publicationStatus, pubmedDataEntity.publicationStatus)
				&& Objects.equals(this.articleIds, pubmedDataEntity.articleIds);
	}

	@Override
	public int hashCode() {
		return Objects.hash(history, publicationStatus, articleIds);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PubmedDataEntity {\n");

		sb.append("    history: ").append(toIndentedString(history)).append("\n");
		sb.append("    publicationStatus: ").append(toIndentedString(publicationStatus)).append("\n");
		sb.append("    articleIds: ").append(toIndentedString(articleIds)).append("\n");
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
