package com.rms.api.model.ria;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CashPickUpPaymentResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8096113080200223388L;

	@JsonProperty("Response")
	private CashPickUpPaymentDTO response;

	@JsonProperty("Errors")
	private Errors errors;

	public CashPickUpPaymentDTO getResponse() {
		return response;
	}

	public void setResponse(CashPickUpPaymentDTO response) {
		this.response = response;
	}

	public Errors getErrors() {
		return errors;
	}

	public void setErrors(Errors errors) {
		this.errors = errors;
	}

}
