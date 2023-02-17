package com.mphrx.api.ConcentDTO;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class Entry {
	@JsonProperty("search")
	private Search search;
	@JsonProperty("resource")
	private Resource resource;
	@JsonProperty("fullUrl")
	private String fullUrl;
	
	@JsonProperty("search")
	public Search getSearch() {
	return search;
	}

	@JsonProperty("search")
	public void setSearch(Search search) {
	this.search = search;
	}

	@JsonProperty("resource")
	public Resource getResource() {
	return resource;
	}

	@JsonProperty("resource")
	public void setResource(Resource resource) {
	this.resource = resource;
	}

	@JsonProperty("fullUrl")
	public String getFullUrl() {
	return fullUrl;
	}

	@JsonProperty("fullUrl")
	public void setFullUrl(String fullUrl) {
	this.fullUrl = fullUrl;
	}
}
