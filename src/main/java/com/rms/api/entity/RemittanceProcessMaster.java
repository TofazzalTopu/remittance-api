package com.rms.api.entity;

import java.io.Serializable;
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
@Table(name = "REMITTANCE_PROCESS_MASTER")
public class RemittanceProcessMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REMITTANCE_PROCESS_MASTER_GEN")
	@SequenceGenerator(name = "REMITTANCE_PROCESS_MASTER_GEN", sequenceName = "REMITTANCE_PROCESS_MASTER_SEQ", allocationSize = 1)
	private Long id;

	@Column(name="EXCHANGE_HOUSE_CODE",nullable = false, length = 64)
	private String exchangeHouseCode;

	@Column(name="FILE_NAME",nullable = false, length = 128)
	private String fileName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="PROCESS_DATE")
	private Date processDate;
	
	@Column(name="PROCESS_STATUS")
	private String processStatus; 
	
	@Column(name="PROCESS_BY_USER")
	private String processByUser; 
	
	@Column(name="MANUAL_OPEN")
	private Integer manualOpen;
	
	@Column(name="COMMON")
	private boolean common;
	
	@Column(name="TOTAL_EFT")
	private long totalEft;
	
	@Column(name="TOTAL_BEFTN")
	private long totalBeftn;
	
	@Column(name="TOTAL_SPOT")
	private long totalSpot;
	
	@Column(name="TOTAL_WEB")
	private long totalWeb;
	
	@Column(name="TOTAL_MOBILE")
	private long totalMobile;
	
	@Column(name="API_DATA")
	private int apiData;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExchangeHouseCode() {
		return exchangeHouseCode;
	}

	public void setExchangeHouseCode(String exchangeHouseCode) {
		this.exchangeHouseCode = exchangeHouseCode;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getProcessDate() {
		return processDate;
	}

	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}

	public String getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	public String getProcessByUser() {
		return processByUser;
	}

	public void setProcessByUser(String processByUser) {
		this.processByUser = processByUser;
	}

	public Integer getManualOpen() {
		return manualOpen;
	}

	public void setManualOpen(Integer manualOpen) {
		this.manualOpen = manualOpen;
	}

	public boolean getCommon() {
		return common;
	}

	public void setCommon(boolean common) {
		this.common = common;
	}
	
	public long getTotalEft() {
		return totalEft;
	}

	public void setTotalEft(long totalEft) {
		this.totalEft = totalEft;
	}

	public long getTotalBeftn() {
		return totalBeftn;
	}

	public void setTotalBeftn(long totalBeftn) {
		this.totalBeftn = totalBeftn;
	}

	public long getTotalSpot() {
		return totalSpot;
	}

	public void setTotalSpot(long totalSpot) {
		this.totalSpot = totalSpot;
	}

	public long getTotalWeb() {
		return totalWeb;
	}

	public void setTotalWeb(long totalWeb) {
		this.totalWeb = totalWeb;
	}

	public long getTotalMobile() {
		return totalMobile;
	}

	public void setTotalMobile(long totalMobile) {
		this.totalMobile = totalMobile;
	}

	public int getApiData() {
		return apiData;
	}

	public void setApiData(int apiData) {
		this.apiData = apiData;
	}

	@Override
	public String toString() {
		return "RemittanceProcessMaster [id=" + id + ", exchangeHouseCode="
				+ exchangeHouseCode + ", fileName=" + fileName
				+ ", processDate=" + processDate + ", processStatus="
				+ processStatus + ", processByUser=" + processByUser
				+ ", manualOpen=" + manualOpen + ", common=" + common
				+ ", totalEft=" + totalEft + ", totalBeftn=" + totalBeftn
				+ ", totalSpot=" + totalSpot + ", totalWeb=" + totalWeb
				+ ", totalMobile=" + totalMobile + ", apiData=" + apiData + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + apiData;
		result = prime * result + (common ? 1231 : 1237);
		result = prime
				* result
				+ ((exchangeHouseCode == null) ? 0 : exchangeHouseCode
						.hashCode());
		result = prime * result
				+ ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((manualOpen == null) ? 0 : manualOpen.hashCode());
		result = prime * result
				+ ((processByUser == null) ? 0 : processByUser.hashCode());
		result = prime * result
				+ ((processDate == null) ? 0 : processDate.hashCode());
		result = prime * result
				+ ((processStatus == null) ? 0 : processStatus.hashCode());
		result = prime * result + (int) (totalBeftn ^ (totalBeftn >>> 32));
		result = prime * result + (int) (totalEft ^ (totalEft >>> 32));
		result = prime * result + (int) (totalMobile ^ (totalMobile >>> 32));
		result = prime * result + (int) (totalSpot ^ (totalSpot >>> 32));
		result = prime * result + (int) (totalWeb ^ (totalWeb >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RemittanceProcessMaster other = (RemittanceProcessMaster) obj;
		if (apiData != other.apiData)
			return false;
		if (common != other.common)
			return false;
		if (exchangeHouseCode == null) {
			if (other.exchangeHouseCode != null)
				return false;
		} else if (!exchangeHouseCode.equals(other.exchangeHouseCode))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (manualOpen == null) {
			if (other.manualOpen != null)
				return false;
		} else if (!manualOpen.equals(other.manualOpen))
			return false;
		if (processByUser == null) {
			if (other.processByUser != null)
				return false;
		} else if (!processByUser.equals(other.processByUser))
			return false;
		if (processDate == null) {
			if (other.processDate != null)
				return false;
		} else if (!processDate.equals(other.processDate))
			return false;
		if (processStatus == null) {
			if (other.processStatus != null)
				return false;
		} else if (!processStatus.equals(other.processStatus))
			return false;
		if (totalBeftn != other.totalBeftn)
			return false;
		if (totalEft != other.totalEft)
			return false;
		if (totalMobile != other.totalMobile)
			return false;
		if (totalSpot != other.totalSpot)
			return false;
		if (totalWeb != other.totalWeb)
			return false;
		return true;
	}


}