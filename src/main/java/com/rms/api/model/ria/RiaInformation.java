package com.rms.api.model.ria;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RiaInformation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3599979957582594242L;
    
	@JsonProperty("CustID")
	private String custID;
	
	@JsonProperty("CustTypeID")
	private String custTypeID;

	public String getCustID() {
		return custID;
	}

	public void setCustID(String custID) {
		this.custID = custID;
	}

	public String getCustTypeID() {
		return custTypeID;
	}

	public void setCustTypeID(String custTypeID) {
		this.custTypeID = custTypeID;
	}
	
}
