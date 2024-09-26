package com.rms.api.model.ria;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RiaBeneInformation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -881152137702516899L;

	@JsonProperty("RiaBeneID")
	private String riaBeneID;
	
	@JsonProperty("BeneTypeID")
	private String beneTypeID;
	
	@JsonProperty("BeneQuestion")
	private String beneQuestion;
	
	@JsonProperty("BeneAnswer")
	private String beneAnswer;

	public String getRiaBeneID() {
		return riaBeneID;
	}

	public void setRiaBeneID(String riaBeneID) {
		this.riaBeneID = riaBeneID;
	}

	public String getBeneTypeID() {
		return beneTypeID;
	}

	public void setBeneTypeID(String beneTypeID) {
		this.beneTypeID = beneTypeID;
	}

	public String getBeneQuestion() {
		return beneQuestion;
	}

	public void setBeneQuestion(String beneQuestion) {
		this.beneQuestion = beneQuestion;
	}

	public String getBeneAnswer() {
		return beneAnswer;
	}

	public void setBeneAnswer(String beneAnswer) {
		this.beneAnswer = beneAnswer;
	}
	
	
}
