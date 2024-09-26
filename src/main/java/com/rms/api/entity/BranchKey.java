package com.rms.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BranchKey implements Serializable {
	@Column(name = "MBRN_ENTITY_NUM", nullable = false)
	private short entityNumber;
	
	@Column(name = "MBRN_CODE", nullable = false)
	private int branchCode;

	public short getEntityNumber() {
		return entityNumber;
	}

	public void setEntityNumber(short entityNumber) {
		this.entityNumber = entityNumber;
	}

	public int getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(int branchCode) {
		this.branchCode = branchCode;
	}

}
