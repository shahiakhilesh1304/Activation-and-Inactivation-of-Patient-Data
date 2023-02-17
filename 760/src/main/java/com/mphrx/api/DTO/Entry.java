package com.mphrx.api.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Entry {

	@JsonProperty("resource")
	private Resource resource;
	
	@JsonProperty("resource")
	public Resource getResource() {
	return resource;
	}




	@JsonProperty("resource")
	public void setResource(Resource resource) {
	this.resource = resource;
	}

}
