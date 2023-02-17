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

public class Category {

	@JsonProperty("coding")
	private List<Coding> coding;
	@JsonProperty("text")
	private String text;
	@JsonProperty("coding")
	public List<Coding> getCoding() {
	return coding;
	}

	@JsonProperty("coding")
	public void setCoding(List<Coding> coding) {
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
