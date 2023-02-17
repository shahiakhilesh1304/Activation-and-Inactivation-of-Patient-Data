package com.mphrx.api.ConcentDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateExtension {
	@JsonProperty("url")
	private String url;
	@JsonProperty("valueString")
	private String valueString;

	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	@JsonProperty("url")
	public void setUrl(String url) {
		this.url = url;
	}

	@JsonProperty("valueString")
	public String getValueString() {
		return valueString;
	}

	@JsonProperty("valueString")
	public void setValueString(String valueString) {
		this.valueString = valueString;
	}

}
