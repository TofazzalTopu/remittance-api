package com.rms.api.model.ria;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaxInformation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7571889451446934814L;
    
	@JsonProperty("CustTaxID")
	private String custTaxID;
	
	@JsonProperty("CustTaxCountry")
	private String custTaxCountry;

	public String getCustTaxID() {
		return custTaxID;
	}

	public void setCustTaxID(String custTaxID) {
		this.custTaxID = custTaxID;
	}

	public String getCustTaxCountry() {
		return custTaxCountry;
	}

	public void setCustTaxCountry(String custTaxCountry) {
		this.custTaxCountry = custTaxCountry;
	}
	
}
