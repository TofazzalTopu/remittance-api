package com.rms.api.model.ria;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Errors implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8682910095304397270L;

	@JsonProperty("Error")
	private Error error;

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "Errors [error=" + error + "]";
	}

}
