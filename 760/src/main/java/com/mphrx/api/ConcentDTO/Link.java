package com.mphrx.api.ConcentDTO;


import com.fasterxml.jackson.annotation.JsonProperty;


public class Link {
	@JsonProperty("url")
	private String url;
	@JsonProperty("relation")
	private String relation;
	
	@JsonProperty("url")
	public String getUrl() {
	return url;
	}

	@JsonProperty("url")
	public void setUrl(String url) {
	this.url = url;
	}

	@JsonProperty("relation")
	public String getRelation() {
	return relation;
	}

	@JsonProperty("relation")
	public void setRelation(String relation) {
	this.relation = relation;
	}
}
