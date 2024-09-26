package com.rms.api.model.ria;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RequiredField implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8212566366981987097L;

	@JsonProperty("RequiredField")
	private List<RequiredFieldDTO> requiredFieldDTO;

	public List<RequiredFieldDTO> getRequiredFieldDTO() {
		return requiredFieldDTO;
	}

	public void setRequiredFieldDTO(List<RequiredFieldDTO> requiredFieldDTO) {
		this.requiredFieldDTO = requiredFieldDTO;
	}

}
