package com.rms.api.model.ria;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DownloadableResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7208804016738577490L;

	@JsonProperty("Order")
	private List<DownloadableOrderDTO> order;

	public List<DownloadableOrderDTO> getOrder() {
		return order;
	}

	public void setOrder(List<DownloadableOrderDTO> order) {
		this.order = order;
	}

    
}
