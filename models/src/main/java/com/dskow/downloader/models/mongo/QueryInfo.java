package com.dskow.downloader.models.mongo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.dskow.downloader.models.service.QueryInfoEntity;
import com.dskow.downloader.models.service.QueryInfoEntity.StatusEnum;

import io.swagger.annotations.ApiModelProperty;

@Document(collection = "Queries")
public class QueryInfo {

	public QueryInfo() {
		super();
		id = UUID.randomUUID().toString();
	}

	public QueryInfo(QueryInfoEntity pe) {
		super();
		if (pe != null) {
			id = pe.getId() != null ? pe.getId().toString() : UUID.randomUUID().toString();
		}
		this.setLanguage(pe.getLanguage());
		this.setStatus(pe.getStatus());
		this.setContent(pe.getContent());
		this.setName(pe.getName());
		this.setRetMax(pe.getRetMax());
		this.setCount(pe.getCount());
		this.setDatabase(pe.getDatabase());
		this.setEmail(pe.getEmail());
		this.setError(pe.getError());
		this.setFetchItems(pe.getFetchItems());
		this.setId(pe.getId());
		this.setPrefix(pe.getPrefix());
		this.setRetmode(pe.getRetmode());
		this.setTool(pe.getTool());
		this.setTerm(pe.getTerm());
		this.setRettype(pe.getRettype());
	}

	@Id
	private String id;

	@JsonProperty("language")
	private String language = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("content")
	private String content = null;

	@JsonProperty("status")
	private StatusEnum status = null;

	@JsonProperty("retMax")
	private Integer retMax = null;

	@JsonProperty("fetchItems")
	private List<String> fetchItems = new ArrayList<String>();

	@JsonProperty("error")
	private String error = null;

	@JsonProperty("count")
	private Integer count = null;

	@JsonProperty("database")
	private String database = null;

	@JsonProperty("retmode")
	private String retmode = null;

	@JsonProperty("email")
	private String email = null;

	@JsonProperty("tool")
	private String tool = null;

	@JsonProperty("term")
	private String term = null;

	@JsonProperty("prefix")
	private String prefix = null;

	@JsonProperty("rettype")
	private String rettype = null;

	
	public QueryInfo id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public QueryInfo language(String language) {
		this.language = language;
		return this;
	}

	/**
	 * Get language
	 * 
	 * @return language
	 **/
	@ApiModelProperty(value = "")
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public QueryInfo name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Get name
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public QueryInfo content(String content) {
		this.content = content;
		return this;
	}

	/**
	 * Get content
	 * 
	 * @return content
	 **/
	@ApiModelProperty(example = "false", value = "")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public QueryInfo status(StatusEnum status) {
		this.status = status;
		return this;
	}

	/**
	 * Get status
	 * 
	 * @return status
	 **/
	@ApiModelProperty(example = "false", value = "")
	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public QueryInfo count(Integer count) {
		this.count = count;
		return this;
	}

	/**
	 * Get count
	 * 
	 * @return count
	 **/
	@ApiModelProperty(example = "false", value = "")
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	public QueryInfo error(String error) {
		this.error = error;
		return this;
	}

	/**
	 * Get error
	 * 
	 * @return error
	 **/
	@ApiModelProperty(example = "false", value = "")
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public QueryInfo fetchItems(List<String> fetchItems) {
		this.fetchItems = fetchItems;
		return this;
	}

	/**
	 * Get fetchItems
	 * 
	 * @return fetchItems
	 **/
	@ApiModelProperty(example = "false", value = "")
	public List<String> getFetchItems() {
		return fetchItems;
	}

	public void setFetchItems(List<String> fetchItems) {
		this.fetchItems = fetchItems;
	}
	
	public QueryInfo retMax(Integer retMax) {
		this.retMax = retMax;
		return this;
	}

	/**
	 * Get retMax
	 * 
	 * @return retMax
	 **/
	@ApiModelProperty(example = "false", value = "")
	public Integer getRetMax() {
		return retMax;
	}

	public void setRetMax(Integer retMax) {
		this.retMax = retMax;
	}

	public QueryInfo database(String database) {
		this.database = database;
		return this;
	}

	/**
	 * Get database
	 * 
	 * @return database
	 **/
	@ApiModelProperty(example = "false", value = "")
	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public QueryInfo retmode(String retmode) {
		this.retmode = retmode;
		return this;
	}

	/**
	 * Get retmode
	 * 
	 * @return retmode
	 **/
	@ApiModelProperty(example = "false", value = "")
	public String getRetmode() {
		return retmode;
	}

	public void setRetmode(String retmode) {
		this.retmode = retmode;
	}

	public QueryInfo rettype(String rettype) {
		this.rettype = rettype;
		return this;
	}

	/**
	 * Get rettype
	 * 
	 * @return rettype
	 **/
	@ApiModelProperty(example = "false", value = "")
	public String getRettype() {
		return rettype;
	}

	public void setRettype(String rettype) {
		this.rettype = rettype;
	}

	public QueryInfo prefix(String prefix) {
		this.prefix = prefix;
		return this;
	}

	/**
	 * Get prefix
	 * 
	 * @return prefix
	 **/
	@ApiModelProperty(example = "false", value = "")
	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public QueryInfo email(String email) {
		this.email = email;
		return this;
	}

	/**
	 * Get email
	 * 
	 * @return email
	 **/
	@ApiModelProperty(example = "false", value = "")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public QueryInfo tool(String tool) {
		this.tool = tool;
		return this;
	}

	/**
	 * Get tool
	 * 
	 * @return tool
	 **/
	public String getTool() {
		return tool;
	}

	public void setTool(String tool) {
		this.tool = tool;
	}

	public QueryInfo term(String term) {
		this.term = term;
		return this;
	}

	/**
	 * Get term
	 * 
	 * @return term
	 **/
	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		QueryInfo queryInfo = (QueryInfo) o;
		return Objects.equals(this.id, queryInfo.id) && Objects.equals(this.language, queryInfo.language)
				&& Objects.equals(this.name, queryInfo.name) && Objects.equals(this.content, queryInfo.content)
				&& Objects.equals(this.status, queryInfo.status) && Objects.equals(this.count, queryInfo.count)
				&& Objects.equals(this.error, queryInfo.error) && Objects.equals(this.fetchItems, queryInfo.fetchItems)
				&& Objects.equals(this.retMax, queryInfo.retMax)
				&& Objects.equals(this.database, queryInfo.database)
				&& Objects.equals(this.retmode, queryInfo.retmode)
				&& Objects.equals(this.email, queryInfo.email)
				&& Objects.equals(this.prefix, queryInfo.prefix)
				&& Objects.equals(this.term, queryInfo.term)
				&& Objects.equals(this.rettype, queryInfo.rettype);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, language, name, content, status, database, retmode, prefix, email, term, rettype);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class QueryInfo {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    language: ").append(toIndentedString(language)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    content: ").append(toIndentedString(content)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("    database: ").append(toIndentedString(database)).append("\n");
		sb.append("    retmode: ").append(toIndentedString(retmode)).append("\n");
		sb.append("    prefix: ").append(toIndentedString(prefix)).append("\n");
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
