package com.dskow.downloader.models.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.dskow.downloader.models.mongo.QueryInfo;

import io.swagger.annotations.ApiModelProperty;

/**
 * QueryInfoEntity
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-06-22T15:15:38.215-04:00")

public class QueryInfoEntity {
	@JsonProperty("content")
	private String content = null;

	@JsonProperty("count")
	private Integer count = null;

	@JsonProperty("error")
	private String error = null;

	@JsonProperty("fetchItems")
	private List<String> fetchItems = new ArrayList<String>();

	@JsonProperty("id")
	private String id = null;

	@JsonProperty("language")
	private String language = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("retMax")
	private Integer retMax = null;

	@JsonProperty("database")
	private String database = null;

	@JsonProperty("retmode")
	private String retmode = null;
	
	@JsonProperty("prefix")
	private String prefix = null;
	
	@JsonProperty("tool")
	private String tool = null;
	
	@JsonProperty("email")
	private String email = null;

	@JsonProperty("term")
	private String term = null;

	@JsonProperty("rettype")
	private String rettype = null;

	/**
	 * status.
	 */
	public enum StatusEnum {
		QUEUED("Queued"),

		INPROGRESS("InProgress"),

		COMPLETE("Complete"),

		FAILED("Failed");

		private String value;

		StatusEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static StatusEnum fromValue(String text) {
			for (StatusEnum b : StatusEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("status")
	private StatusEnum status = null;

	public QueryInfoEntity() {
		super();
	}

	public QueryInfoEntity(QueryInfo j) {
		super();
		this.setContent(j.getContent());
		this.setCount(j.getCount());
		this.setError(j.getError());
		this.setFetchItems(j.getFetchItems());
		this.setId(j.getId());
		this.setLanguage(j.getLanguage());
		this.setName(j.getName());
		this.setRetMax(j.getRetMax());
		this.setStatus(j.getStatus());
		this.setDatabase(j.getDatabase());
		this.setRetmode(j.getRetmode());
		this.setPrefix(j.getPrefix());
		this.setEmail(j.getEmail());
		this.setTool(j.getTool());
		this.setTerm(j.getTerm());
		this.setRettype(j.getRettype());
	}

	public QueryInfoEntity content(String content) {
		this.content = content;
		return this;
	}

	/**
	 * info.
	 * 
	 * @return content
	 **/
	@ApiModelProperty(value = "info.")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public QueryInfoEntity count(Integer count) {
		this.count = count;
		return this;
	}

	/**
	 * count.
	 * 
	 * @return count
	 **/
	@ApiModelProperty(value = "count.")
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public QueryInfoEntity error(String error) {
		this.error = error;
		return this;
	}

	/**
	 * error.
	 * 
	 * @return error
	 **/
	@ApiModelProperty(value = "error.")
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public QueryInfoEntity fetchItems(List<String> fetchItems) {
		this.fetchItems = fetchItems;
		return this;
	}

	public QueryInfoEntity addFetchItemsItem(String fetchItemsItem) {
		this.fetchItems.add(fetchItemsItem);
		return this;
	}

	/**
	 * fetchItems.
	 * 
	 * @return fetchItems
	 **/
	@ApiModelProperty(value = "fetchItems.")
	public List<String> getFetchItems() {
		return fetchItems;
	}

	public void setFetchItems(List<String> fetchItems) {
		this.fetchItems = fetchItems;
	}

	public QueryInfoEntity id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * The queryInfo type.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "The queryInfo type.")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public QueryInfoEntity language(String language) {
		this.language = language;
		return this;
	}

	/**
	 * The queryInfo type.
	 * 
	 * @return language
	 **/
	@ApiModelProperty(value = "The queryInfo type.")
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public QueryInfoEntity name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * The queryInfo name.
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "The queryInfo name.")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public QueryInfoEntity retMax(Integer retMax) {
		this.retMax = retMax;
		return this;
	}

	/**
	 * retMax.
	 * 
	 * @return retMax
	 **/
	@ApiModelProperty(value = "retMax.")
	public Integer getRetMax() {
		return retMax;
	}

	public void setRetMax(Integer retMax) {
		this.retMax = retMax;
	}

	public QueryInfoEntity database(String database) {
		this.database = database;
		return this;
	}

	/**
	 * database.
	 * 
	 * @return database
	 **/
	@ApiModelProperty(value = "database")
	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}
	
	public QueryInfoEntity retmode(String retmode) {
		this.retmode = retmode;
		return this;
	}

	/**
	 * retmode.
	 * 
	 * @return retmode
	 **/
	@ApiModelProperty(value = "retmode")
	public String getRetmode() {
		return retmode;
	}

	public void setRetmode(String retmode) {
		this.retmode = retmode;
	}
	
	public QueryInfoEntity prefix(String prefix) {
		this.prefix = prefix;
		return this;
	}

	/**
	 * prefix.
	 * 
	 * @return prefix
	 **/
	@ApiModelProperty(value = "prefix")
	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public QueryInfoEntity tool(String tool) {
		this.tool = tool;
		return this;
	}

	/**
	 * tool.
	 * 
	 * @return tool
	 **/
	@ApiModelProperty(value = "tool")
	public String getTool() {
		return tool;
	}

	public void setTool(String tool) {
		this.tool = tool;
	}
	
	public QueryInfoEntity email(String email) {
		this.email = email;
		return this;
	}

	/**
	 * email.
	 * 
	 * @return email
	 **/
	@ApiModelProperty(value = "email.")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public QueryInfoEntity status(StatusEnum status) {
		this.status = status;
		return this;
	}

	/**
	 * status.
	 * 
	 * @return status
	 **/
	@ApiModelProperty(value = "status.")
	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public QueryInfoEntity term(String term) {
		this.term = term;
		return this;
	}

	/**
	 * term.
	 * 
	 * @return term
	 **/
	@ApiModelProperty(value = "term.")
	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public QueryInfoEntity rettype(String rettype) {
		this.rettype = rettype;
		return this;
	}

	/**
	 * rettype.
	 * 
	 * @return rettype
	 **/
	@ApiModelProperty(value = "rettype.")
	public String getRettype() {
		return rettype;
	}

	public void setRettype(String rettype) {
		this.rettype = rettype;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		QueryInfoEntity inlineResponse2001 = (QueryInfoEntity) o;
		return Objects.equals(this.content, inlineResponse2001.content)
				&& Objects.equals(this.count, inlineResponse2001.count)
				&& Objects.equals(this.error, inlineResponse2001.error)
				&& Objects.equals(this.fetchItems, inlineResponse2001.fetchItems)
				&& Objects.equals(this.id, inlineResponse2001.id)
				&& Objects.equals(this.language, inlineResponse2001.language)
				&& Objects.equals(this.name, inlineResponse2001.name)
				&& Objects.equals(this.retMax, inlineResponse2001.retMax)
				&& Objects.equals(this.status, inlineResponse2001.status)
				&& Objects.equals(this.database, inlineResponse2001.database)
				&& Objects.equals(this.retmode, inlineResponse2001.retmode)
				&& Objects.equals(this.prefix, inlineResponse2001.prefix)
				&& Objects.equals(this.tool, inlineResponse2001.tool)
				&& Objects.equals(this.email, inlineResponse2001.email)
				&& Objects.equals(this.term, inlineResponse2001.term)
				&& Objects.equals(this.rettype, inlineResponse2001.rettype);
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, count, error, fetchItems, id, language, name, retMax, status, database, retmode, prefix, tool, email, term, rettype);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class QueryInfoEntity {\n");

		sb.append("    content: ").append(toIndentedString(content)).append("\n");
		sb.append("    count: ").append(toIndentedString(count)).append("\n");
		sb.append("    error: ").append(toIndentedString(error)).append("\n");
		sb.append("    fetchItems: ").append(toIndentedString(fetchItems)).append("\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    language: ").append(toIndentedString(language)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    retMax: ").append(toIndentedString(retMax)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("    database: ").append(toIndentedString(database)).append("\n");
		sb.append("    retmode: ").append(toIndentedString(retmode)).append("\n");
		sb.append("    prefix: ").append(toIndentedString(prefix)).append("\n");
		sb.append("    tool: ").append(toIndentedString(tool)).append("\n");
		sb.append("    email: ").append(toIndentedString(email)).append("\n");
		sb.append("    term: ").append(toIndentedString(term)).append("\n");
		sb.append("    rettype: ").append(toIndentedString(rettype)).append("\n");
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
