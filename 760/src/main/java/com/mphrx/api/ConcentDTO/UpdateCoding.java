package com.mphrx.api.ConcentDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateCoding {
	@JsonProperty("code")
	private String code;
	@JsonProperty("display")
	private String display;

	@JsonProperty("code")
	public String getCode() {
		return code;
	}

	@JsonProperty("code")
	public void setCode(String code) {
		this.code = code;
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
