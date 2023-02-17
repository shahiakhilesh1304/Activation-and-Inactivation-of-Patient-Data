package com.mphrx.api.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Resource {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("id")
	public String getId() {
	return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
	this.id = id;
	}

}
