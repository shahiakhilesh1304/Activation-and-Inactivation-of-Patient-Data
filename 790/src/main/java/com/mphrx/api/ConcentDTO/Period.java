package com.mphrx.api.ConcentDTO;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Period {
	@JsonProperty("start")
	private String start;
	
	@JsonProperty("start")
	public String getStart() {
	return start;
	}

	@JsonProperty("start")
	public void setStart(String start) {
	this.start = start;
	}

}
