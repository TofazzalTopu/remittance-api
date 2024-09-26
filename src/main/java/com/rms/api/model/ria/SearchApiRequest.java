package com.rms.api.model.ria;

import java.io.Serializable;

public class SearchApiRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7713041286281167462L;

	private String bruserid;

	private String brcode;

	private String exchcode;

	private String pinno;
	
	private String ipAddress;

	public String getBruserid() {
		return bruserid;
	}

	public void setBruserid(String bruserid) {
		this.bruserid = bruserid;
	}

	public String getBrcode() {
		return brcode;
	}

	public void setBrcode(String brcode) {
		this.brcode = brcode;
	}

	public String getExchcode() {
		return exchcode;
	}

	public void setExchcode(String exchcode) {
		this.exchcode = exchcode;
	}

	public String getPinno() {
		return pinno;
	}

	public void setPinno(String pinno) {
		this.pinno = pinno;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	

}
