package com.mphrx.api.ConcentDTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateCategory {
	@JsonProperty("coding")
	private List<UpdateCoding> coding;
	
	@JsonProperty("text")
	private String text;
	
	@JsonProperty("coding")
	public List<UpdateCoding> getCoding() {
	return coding;
	}

	@JsonProperty("coding")
	public void setCoding(List<UpdateCoding> coding) {
	this.coding = coding;
	}

	@JsonProperty("text")
	public String getText() {
	return text;
	}

	@JsonProperty("text")
	public void setText(String text) {
	this.text = text;
	}
}
