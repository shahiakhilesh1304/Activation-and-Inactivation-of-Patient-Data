package com.mphrx.api.reqres;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mphrx.api.ConcentDTO.Entry;
import com.mphrx.api.ConcentDTO.Link;

public class Concent 
{
	@JsonProperty("entry")
	private List<Entry> entry;
	@JsonProperty("total")
	private Integer total;
	@JsonProperty("link")
	private List<Link> link;
	@JsonProperty("type")
	private String type;
	@JsonProperty("resourceType")
	private String resourceType;
	
	@JsonProperty("entry")
	public List<Entry> getEntry() {
	return entry;
	}

	@JsonProperty("entry")
	public void setEntry(List<Entry> entry) {
	this.entry = entry;
	}

	@JsonProperty("total")
	public Integer getTotal() {
	return total;
	}

	@JsonProperty("total")
	public void setTotal(Integer total) {
	this.total = total;
	}

	@JsonProperty("link")
	public List<Link> getLink() {
	return link;
	}

	@JsonProperty("link")
	public void setLink(List<Link> link) {
	this.link = link;
	}

	@JsonProperty("type")
	public String getType() {
	return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
	this.type = type;
	}

	@JsonProperty("resourceType")
	public String getResourceType() {
	return resourceType;
	}

	@JsonProperty("resourceType")
	public void setResourceType(String resourceType) {
	this.resourceType = resourceType;
	}

}
