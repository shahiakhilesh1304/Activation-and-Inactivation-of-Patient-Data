package com.mphrx.api.reqres;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mphrx.api.DTO.Entry;

public class PatientIdResponse 
{
	@JsonProperty("entry")
	private List<Entry> entry;
	
	
	@JsonProperty("entry")
	public List<Entry> getEntry() {
		return entry;
	}

	@JsonProperty("entry")
	public void setEntry(List<Entry> entry) {
		this.entry = entry;
	}
}
