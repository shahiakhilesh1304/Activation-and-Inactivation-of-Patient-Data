package com.mphrx.api.ConcentDTO;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Meta {
	@JsonProperty("lastUpdated")
	private String lastUpdated;
	@JsonProperty("versionId")
	private String versionId;
	
	@JsonProperty("lastUpdated")
	public String getLastUpdated() {
	return lastUpdated;
	}

	@JsonProperty("lastUpdated")
	public void setLastUpdated(String lastUpdated) {
	this.lastUpdated = lastUpdated;
	}

	@JsonProperty("versionId")
	public String getVersionId() {
	return versionId;
	}

	@JsonProperty("versionId")
	public void setVersionId(String versionId) {
	this.versionId = versionId;
	}
}
