package com.mphrx.api.reqres;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mphrx.api.ConcentDTO.Category;
import com.mphrx.api.ConcentDTO.Extension;
import com.mphrx.api.ConcentDTO.Patient;
import com.mphrx.api.ConcentDTO.Period;

public class ConcentCreateRequest {
	@JsonProperty("resourceType")
	private String resourceType;
	@JsonProperty("status")
	private String status;
	@JsonProperty("extension")
	private List<Extension> extension;
	@JsonProperty("category")
	private List<Category> category;
	@JsonProperty("patient")
	private Patient patient;
	@JsonProperty("period")
	private Period period;

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

	@JsonProperty("extension")
	public List<Extension> getExtension() {
	return extension;
	}

	@JsonProperty("extension")
	public void setExtension(List<Extension> extension) {
	this.extension = extension;
	}

	@JsonProperty("category")
	public List<Category> getCategory() {
	return category;
	}

	@JsonProperty("category")
	public void setCategory(List<Category> category) {
	this.category = category;
	}

	@JsonProperty("patient")
	public Patient getPatient() {
	return patient;
	}

	@JsonProperty("patient")
	public void setPatient(Patient patient) {
	this.patient = patient;
	}

	@JsonProperty("period")
	public Period getPeriod() {
	return period;
	}

	@JsonProperty("period")
	public void setPeriod(Period period) {
	this.period = period;
	}

}
