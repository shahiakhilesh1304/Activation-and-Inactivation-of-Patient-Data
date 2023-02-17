package com.mphrx.api.reqres;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mphrx.api.ConcentDTO.UpdateCategory;
import com.mphrx.api.ConcentDTO.UpdateExtension;
import com.mphrx.api.ConcentDTO.UpdatePatient;
import com.mphrx.api.ConcentDTO.UpdatePeriod;

public class ConcentUpdateRequest 
{
	@JsonProperty("id")
	private String id;
	@JsonProperty("resourceType")
	private String resourceType;
	@JsonProperty("status")
	private String status;
	@JsonProperty("extension")
	private List<UpdateExtension> extension;
	@JsonProperty("category")
	private List<UpdateCategory> category;
	@JsonProperty("patient")
	private UpdatePatient patient;
	@JsonProperty("period")
	private UpdatePeriod period;
	
	@JsonProperty("id")
	public String getId() {
	return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
	this.id = id;
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

	@JsonProperty("extension")
	public List<UpdateExtension> getExtension() {
	return extension;
	}

	@JsonProperty("extension")
	public void setExtension(List<UpdateExtension> extension) {
	this.extension = extension;
	}

	@JsonProperty("category")
	public List<UpdateCategory> getCategory() {
	return category;
	}

	@JsonProperty("category")
	public void setCategory(List<UpdateCategory> category) {
	this.category = category;
	}

	@JsonProperty("patient")
	public UpdatePatient getPatient() {
	return patient;
	}

	@JsonProperty("patient")
	public void setPatient(UpdatePatient patient) {
	this.patient = patient;
	}

	@JsonProperty("period")
	public UpdatePeriod getPeriod() {
	return period;
	}

	@JsonProperty("period")
	public void setPeriod(UpdatePeriod period) {
	this.period = period;
	}

}
