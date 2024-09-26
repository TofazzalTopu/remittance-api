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
@Table(name = "REM_API_TRACE")
public class ApiTrace implements Serializable {

    private static final long serialVersionUID = 22430169541112512L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REM_API_TRACE_SEQ_GEN")
    @SequenceGenerator(name = "REM_API_TRACE_SEQ_GEN", sequenceName = "REM_API_TRACE_SEQ", allocationSize = 1)
    private long id;

    @Column(name = "EXCHANGE_CODE", nullable = false)
    private String exchangeCode;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "BRANCH_CODE")
    private Integer branchCode;

    @Column(name = "PIN_NO")
    private String pinNo;

    @Column(name = "IP_ADDRESS")
    private String ipAddress;

    @Column(name = "REQ_TYPE")
    private String requestType;

    @Column(name = "RESPONSE_MSG", columnDefinition = "TEXT")
    private String responseMsg;

    @Column(name = "STATUS")
    private String status;

    @Temporal(TemporalType.DATE)
    @Column(name = "CBS_DATE")
    private Date cbsDate;

    @Column(name = "TRAN_NO")
    private String tranno;

    @Column(name = "EX_TRAN_ID")
    private String exTRANID;

    @Column(name = "REQUEST_MSG")
    private String requestMsg;

    @Column(name = "CANCEL_STATUS")
    private String cancelStatus;

    @Column(name = "CBS_BATCH_INFO")
    private String cbsBatchInfo;

    @Column(name = "CBS_SETTLEMENT_STATUS")
    private String cbsSettlementStatus;

    @Column(name = "TRY_COUNT")
    private int tryCount;

    @Column(name = "CORRELATION_ID", nullable = false)
    private String correlationId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExchangeCode() {
        return exchangeCode;
    }

    public void setExchangeCode(String exchangeCode) {
        this.exchangeCode = exchangeCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(Integer branchCode) {
        this.branchCode = branchCode;
    }

    public String getPinNo() {
        return pinNo;
    }

    public void setPinNo(String pinNo) {
        this.pinNo = pinNo;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCbsDate() {
        return cbsDate;
    }

    public void setCbsDate(Date cbsDate) {
        this.cbsDate = cbsDate;
    }

    public String getTranno() {
        return tranno;
    }

    public void setTranno(String tranno) {
        this.tranno = tranno;
    }

    public String getExTRANID() {
        return exTRANID;
    }

    public void setExTRANID(String exTRANID) {
        this.exTRANID = exTRANID;
    }

    public String getRequestMsg() {
        return requestMsg;
    }

    public void setRequestMsg(String requestMsg) {
        this.requestMsg = requestMsg;
    }

    public String getCancelStatus() {
        return cancelStatus;
    }

    public void setCancelStatus(String cancelStatus) {
        this.cancelStatus = cancelStatus;
    }

    public String getCbsBatchInfo() {
        return cbsBatchInfo;
    }

    public void setCbsBatchInfo(String cbsBatchInfo) {
        this.cbsBatchInfo = cbsBatchInfo;
    }

    public String getCbsSettlementStatus() {
        return cbsSettlementStatus;
    }

    public void setCbsSettlementStatus(String cbsSettlementStatus) {
        this.cbsSettlementStatus = cbsSettlementStatus;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }


    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }
}
