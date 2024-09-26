package com.rms.api.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "STOP_REMITTANCE")
public class StopRemittanceData implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String ACCEPT_REQUEST = "REQUEST_ACCEPTED";
	public static final String REJECT_REQUEST = "REQUEST_REJECTED";
	
	public static final String ACCEPTED = "ACCEPTED";
	
	public static final String REJECT_NOT_FOUND = "REJECT_NOT_FOUND";
	public static final String REJECT_ALREADY_PAID = "REJECT_ALREADY_PAID";
	public static final String REJECT_ALREADY_CANCELLED = "REJECT_ALREADY_CANCELLED";
	public static final String REJECT_OTHER = "REJECT_OTHER";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STOP_REMITTANCE_GEN")
	@SequenceGenerator(name = "STOP_REMITTANCE_GEN", sequenceName = "STOP_REMITTANCE_SEQ", allocationSize = 1)
	private Long id;

	@Column(name = "REFERENCE_NO")
	private String referenceNo;

	@Column(name = "REFERENCE_DATE")
	@Temporal(TemporalType.DATE)
	private Date referenceDate;

	@Column(name = "AMOUNT")
	private BigDecimal amount;

	@Column(name = "EXCHANGE_HOUSE_CODE")
	private String exchangeCode;

	@Column(name = "PROCESS_STATUS")
	private String processStatus;

	@Column(name = "MESSAGE")
	private String message;
	
	@Column(name = "REQUEST_BY")
	private String requestBy;

	@Column(name = "REQUEST_ON")
	@Temporal(TemporalType.DATE)
	private Date requestOn;
	
	@Column(name = "EXCHANGE_STATUS")
	private String exchangeStatus;
	
	@Column(name = "RESPONDED")
	private String responed;

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public Date getReferenceDate() {
		return referenceDate;
	}

	public void setReferenceDate(Date referenceDate) {
		this.referenceDate = referenceDate;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getExchangeCode() {
		return exchangeCode;
	}

	public void setExchangeCode(String exchangeCode) {
		this.exchangeCode = exchangeCode;
	}

	public String getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	public String getRequestBy() {
		return requestBy;
	}

	public void setRequestBy(String requestBy) {
		this.requestBy = requestBy;
	}

	public Date getRequestOn() {
		return requestOn;
	}

	public void setRequestOn(Date requestOn) {
		this.requestOn = requestOn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getExchangeStatus() {
		return exchangeStatus;
	}

	public void setExchangeStatus(String exchangeStatus) {
		this.exchangeStatus = exchangeStatus;
	}

	public String getResponed() {
		return responed;
	}

	public void setResponed(String responed) {
		this.responed = responed;
	}
	
	
	
}