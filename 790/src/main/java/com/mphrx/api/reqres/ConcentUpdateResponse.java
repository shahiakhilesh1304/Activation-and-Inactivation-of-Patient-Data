package com.mphrx.api.reqres;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mphrx.api.ConcentDTO.Category;
import com.mphrx.api.ConcentDTO.Extension;
import com.mphrx.api.ConcentDTO.Meta;
import com.mphrx.api.ConcentDTO.Patient;
import com.mphrx.api.ConcentDTO.Period;

public class ConcentUpdateResponse {
	@JsonProperty("extension")
	private List<Extension> extension;
	@JsonProperty("period")
	private Period period;
	@JsonProperty("meta")
	private Meta meta;
	@JsonProperty("patient")
	private Patient patient;
	@JsonProperty("id")
	private String id;
	@JsonProperty("category")
	private List<Category> category;
	@JsonProperty("resourceType")
	private String resourceType;
	@JsonProperty("status")
	private String status;

	@JsonProperty("extension")
	public List<Extension> getExtension() {
		return extension;
	}

	@JsonProperty("extension")
	public void setExtension(List<Extension> extension) {
		this.extension = extension;
	}

	@JsonProperty("period")
	public Period getPeriod() {
		return period;
	}

	@JsonProperty("period")
	public void setPeriod(Period period) {
		this.period = period;
	}

	@JsonProperty("meta")
	public Meta getMeta() {
		return meta;
	}

	@JsonProperty("meta")
	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	@JsonProperty("patient")
	public Patient getPatient() {
		return patient;
	}

	@JsonProperty("patient")
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("category")
	public List<Category> getCategory() {
		return category;
	}

	@JsonProperty("category")
	public void setCategory(List<Category> category) {
		this.category = category;
	}

	@JsonProperty("resourceType")
	public String getResourceType() {
		return resourceType;
	}

	@JsonProperty("resourceType")
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

}
