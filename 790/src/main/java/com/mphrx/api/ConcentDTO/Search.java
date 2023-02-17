package com.mphrx.api.ConcentDTO;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Search {

	@JsonProperty("mode")
	private String mode;
	
	@JsonProperty("mode")
	public String getMode() {
	return mode;
	}

	@JsonProperty("mode")
	public void setMode(String mode) {
	this.mode = mode;
	}

}
