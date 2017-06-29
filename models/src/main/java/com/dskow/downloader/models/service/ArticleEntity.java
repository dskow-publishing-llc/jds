package com.dskow.downloader.models.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.dskow.downloader.models.xml.Article;
import com.dskow.downloader.models.xml.Author;
import com.dskow.downloader.models.xml.PublicationType;

import io.swagger.annotations.ApiModelProperty;

public class ArticleEntity {

	@JsonProperty("pubModel")
	private String pubModel = null;

	@JsonProperty("journal")
	private JournalEntity journal = null;

	@JsonProperty("articleTitle")
	private String articleTitle = null;

	@JsonProperty("eLocationID")
	private ELocationIDEntity eLocationID = null;

	@JsonProperty("abstractItem")
	private AbstractEntity abstractItem = null;

	@JsonProperty("authors")
	private List<AuthorEntity> authors = null;

	@JsonProperty("language")
	private String language = null;

	@JsonProperty("publicationTypes")
	private List<PublicationTypeEntity> publicationTypes = null;

	@JsonProperty("articleDate")
	private DateEntity articleDate = null;

	public ArticleEntity() {
		super();
	}

	public ArticleEntity(Article j) {
		super();
		if (j == null) {
			return;
		}
		this.setAbstractItem(new AbstractEntity(j.getAbstractItem()));
		this.setArticleDate(new DateEntity(j.getArticleDate()));
		List<Author> xmllist = j.getArthorList() != null ? j.getArthorList().getAuthor() : null;
		List<AuthorEntity> list = null;
		if (xmllist != null) {
			list = new ArrayList<AuthorEntity>();
			for (Author a : xmllist) {
				list.add(new AuthorEntity(a));
			}
		}
		this.setAuthors(list);
		this.setELocationID(new ELocationIDEntity(j.getELocationId()));
		this.setJournal(new JournalEntity(j.getJournal()));
		this.setLanguage(j.getLanguage());
		this.setArticleTitle(j.getArticleTitle());
		List<PublicationTypeEntity> publist = null;
		List<PublicationType> xmlpublist = j.getPublicationTypeList() != null
				? j.getPublicationTypeList().getPublicationType() : null;
		if (xmlpublist != null) {
			publist = new ArrayList<PublicationTypeEntity>();
			for (PublicationType p : xmlpublist) {
				publist.add(new PublicationTypeEntity(p));
			}
		}
		this.setPublicationTypes(publist);
		this.setPubModel(j.getPubModel());
	}

	public ArticleEntity pubModel(String pubModel) {
		this.pubModel = pubModel;
		return this;
	}

	/**
	 * The article pubModel.
	 * 
	 * @return pubModel
	 **/
	@ApiModelProperty(value = "The article pubModel.")
	public String getPubModel() {
		return pubModel;
	}

	public void setPubModel(String pubModel) {
		this.pubModel = pubModel;
	}

	public ArticleEntity journal(JournalEntity journal) {
		this.journal = journal;
		return this;
	}

	/**
	 * The article journal.
	 * 
	 * @return journal
	 **/
	@ApiModelProperty(value = "The article journal.")
	public JournalEntity getJournal() {
		return journal;
	}

	public void setJournal(JournalEntity journal) {
		this.journal = journal;
	}

	public ArticleEntity articleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
		return this;
	}

	/**
	 * The article articleTitle.
	 * 
	 * @return articleTitle
	 **/
	@ApiModelProperty(value = "The article articleTitle.")
	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public ArticleEntity eLocationID(ELocationIDEntity eLocationID) {
		this.eLocationID = eLocationID;
		return this;
	}

	/**
	 * The article eLocationID.
	 * 
	 * @return eLocationID
	 **/
	@ApiModelProperty(value = "The article eLocationID.")
	public ELocationIDEntity getELocationID() {
		return eLocationID;
	}

	public void setELocationID(ELocationIDEntity eLocationID) {
		this.eLocationID = eLocationID;
	}

	public ArticleEntity abstractItem(AbstractEntity abstractItem) {
		this.abstractItem = abstractItem;
		return this;
	}

	/**
	 * The article abstractItem.
	 * 
	 * @return abstractItem
	 **/
	@ApiModelProperty(value = "The article abstractItem.")
	public AbstractEntity getAbstractItem() {
		return abstractItem;
	}

	public void setAbstractItem(AbstractEntity abstractItem) {
		this.abstractItem = abstractItem;
	}

	public ArticleEntity authors(List<AuthorEntity> authors) {
		this.authors = authors;
		return this;
	}

	/**
	 * The article authors.
	 * 
	 * @return authors
	 **/
	@ApiModelProperty(value = "The article authors.")
	public List<AuthorEntity> getAuthors() {
		return authors;
	}

	public void addAuthor(AuthorEntity author) {
		this.authors.add(author);
	}

	public void setAuthors(List<AuthorEntity> authors) {
		this.authors = authors;
	}

	public ArticleEntity language(String language) {
		this.language = language;
		return this;
	}

	/**
	 * The article language.
	 * 
	 * @return language
	 **/
	@ApiModelProperty(value = "The article language.")
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public ArticleEntity publicationTypes(List<PublicationTypeEntity> publicationTypes) {
		this.publicationTypes = publicationTypes;
		return this;
	}

	/**
	 * The article publicationTypes.
	 * 
	 * @return publicationTypes
	 **/
	@ApiModelProperty(value = "The article publicationTypes.")
	public List<PublicationTypeEntity> getPublicationTypes() {
		return publicationTypes;
	}

	public void addPublicationType(PublicationTypeEntity publicationType) {
		this.publicationTypes.add(publicationType);
	}

	public void setPublicationTypes(List<PublicationTypeEntity> publicationTypes) {
		this.publicationTypes = publicationTypes;
	}

	public ArticleEntity articleDate(DateEntity articleDate) {
		this.articleDate = articleDate;
		return this;
	}

	/**
	 * The article articleDate.
	 * 
	 * @return articleDate
	 **/
	@ApiModelProperty(value = "The article articleDate.")
	public DateEntity getArticleDate() {
		return articleDate;
	}

	public void setArticleDate(DateEntity articleDate) {
		this.articleDate = articleDate;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ArticleEntity articleEntity = (ArticleEntity) o;
		return Objects.equals(this.pubModel, articleEntity.pubModel)
				&& Objects.equals(this.journal, articleEntity.journal)
				&& Objects.equals(this.articleTitle, articleEntity.articleTitle)
				&& Objects.equals(this.eLocationID, articleEntity.eLocationID)
				&& Objects.equals(this.abstractItem, articleEntity.abstractItem)
				&& Objects.equals(this.authors, articleEntity.authors)
				&& Objects.equals(this.language, articleEntity.language)
				&& Objects.equals(this.publicationTypes, articleEntity.publicationTypes)
				&& Objects.equals(this.articleDate, articleEntity.articleDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(pubModel, journal, articleTitle, eLocationID, abstractItem, authors, language,
				publicationTypes, articleDate);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ArticleEntity {\n");

		sb.append("    pubModel: ").append(toIndentedString(pubModel)).append("\n");
		sb.append("    journal: ").append(toIndentedString(journal)).append("\n");
		sb.append("    articleTitle: ").append(toIndentedString(articleTitle)).append("\n");
		sb.append("    eLocationID: ").append(toIndentedString(eLocationID)).append("\n");
		sb.append("    abstractItem: ").append(toIndentedString(abstractItem)).append("\n");
		sb.append("    authors: ").append(toIndentedString(authors)).append("\n");
		sb.append("    language: ").append(toIndentedString(language)).append("\n");
		sb.append("    publicationTypes: ").append(toIndentedString(publicationTypes)).append("\n");
		sb.append("    articleDate: ").append(toIndentedString(articleDate)).append("\n");
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
