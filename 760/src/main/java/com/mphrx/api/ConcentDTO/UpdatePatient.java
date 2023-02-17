package com.mphrx.api.ConcentDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdatePatient {
	@JsonProperty("reference")
	private String reference;
	@JsonProperty("display")
	private String display;
	
	@JsonProperty("reference")
	public String getReference() {
	return reference;
	}

	@JsonProperty("reference")
	public void setReference(String reference) {
	this.reference = reference;
	}

	@JsonProperty("display")
	public String getDisplay() {
	return display;
	}

	@JsonProperty("display")
	public void setDisplay(String display) {
	this.display = display;
	}
}
