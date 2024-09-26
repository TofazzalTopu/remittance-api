package com.rms.api.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "MBRN")
public class Branch implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected BranchKey branchKey;
	@Column(name = "MBRN_NAME", length = 50)
	private String name;
	@Column(name = "MBRN_ADDR1", length = 35)
	private String address1;
	@Column(name = "MBRN_ADDR2", length = 35)
	private String address2;
	@Column(name = "MBRN_ADDR3", length = 35)
	private String address3;
	@Column(name = "MBRN_ADDR4", length = 35)
	private String address4;
	@Column(name = "MBRN_ADDR5", length = 35)
	private String address5;
	@Column(name = "MBRN_LOCN_CODE", length = 6)
	private String locationCode;
	@Column(name = "MBRN_OPENED_ON_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date openDate;
	@Column(name = "MBRN_ADMIN_UNIT_TYPE", length = 6)
	private String adminUnitType;
	@Column(name = "MBRN_PARENT_ADMIN_CODE")
	private Integer parentAdminCode;
	@Column(name = "MBRN_NUM_EXTN_CTR")
	private Short numberOfExtensionCounter;
	@Column(name = "MBRN_CATEGORY", length = 2)
	private String category;
	@Column(name = "MBRN_SIZE", length = 2)
	private String size;
	@Column(name = "MBRN_AUTH_DEAL_FOREX")
	private Character authorizedForexDealer;
	@Column(name = "MBRN_AUTH_FOR_FCDEP")
	private Character authorizedForForeignCurrencyDeposit;
	@Column(name = "MBRN_MICR_CODE")
	private Integer micrCode;
	@Column(name = "MBRN_MAINBRN_IN_LOCN")
	private Character mainBranchInLocation;
	@Column(name = "MBRN_LINK_SERV_MAIN_BRN")
	private Integer linkedServiceMainBranch;
	@Column(name = "MBRN_DD_ISSUE_ALLOWED")
	private Character ddIssueAllowed;
	@Column(name = "MBRN_TT_ISSUE_ALLOWED")
	private Character ttIssueAllowed;
	@Column(name = "MBRN_SPLIT_PREMISES")
	private Character splitPremises;
	@Column(name = "MBRN_NUM_SPLIT_PREMISES")
	private Short numberOfSplitPremises;
	@Column(name = "MBRN_LOCAL_CLG_MEMBER")
	private Character localClearingMember;
	@Column(name = "MBRN_NATNL_CLG_MEMBER")
	private Character nationalClearingMember;
	@Column(name = "MBRN_HIGH_VAL_CLG_MEMBER")
	private Character highValueClearingMember;
	@Column(name = "MBRN_NUM_OFFICERS_AVL")
	private Short numberOfOfficersAvailable;
	@Column(name = "MBRN_IFSC_CODE", length = 15)
	private String ifscCode;
	@Column(name = "MBRN_CLG_BASED_ON_MICR")
	private Character clearingBasedOnMicr;
	@Column(name = "MBRN_CASH_MGMT_BRANCH")
	private Character cashManagementBranch;
	@Column(name = "MBRN_RTGS_DEP_ENABLED")
	private Character realTimeGrossSettlementDepositEnabled;
	@Column(name = "MBRN_BASE_CURR_CODE", length = 3)
	private String baseCurrencyCode;
	@Column(name = "MBRN_TEL_NO1", length = 15)
	private String telephoneNumber1;
	@Column(name = "MBRN_TEL_NO2", length = 15)
	private String telephoneNumber2;
	@Column(name = "MBRN_TEL_NO3", length = 15)
	private String telephoneNumber3;
	@Column(name = "MBRN_TEL_NO4", length = 15)
	private String telephoneNumber4;
	@Column(name = "MBRN_TEL_NO5", length = 15)
	private String telephoneNumber5;
	@Column(name = "MBRN_TEL_NO6", length = 15)
	private String telephoneNumber6;
	@Column(name = "MBRN_FAX_NO1", length = 15)
	private String faxNumber1;
	@Column(name = "MBRN_FAX_NO2", length = 15)
	private String faxNumber2;
	@Column(name = "MBRN_FAX_NO3", length = 15)
	private String faxNumber3;
	@Column(name = "MBRN_FAX_NO4", length = 15)
	private String faxNumber4;
	@Column(name = "MBRN_FAX_NO5", length = 15)
	private String faxNumber5;
	@Column(name = "MBRN_FAX_NO6", length = 15)
	private String faxNumber6;
	@Column(name = "MBRN_EMAIL_ADDR1", length = 50)
	private String emailAddress1;
	@Column(name = "MBRN_EMAIL_ADDR2", length = 50)
	private String emailAddress2;
	@Column(name = "MBRN_SWIFT_BIC_CODE", length = 12)
	private String swiftBicCode;
	@Column(name = "MBRN_WEEK_HOL_MON")
	private Character weeklyHolidayOnMonday;
	@Column(name = "MBRN_WEEK_HOL_TUE")
	private Character weeklyHolidayOnTuesday;
	@Column(name = "MBRN_WEEK_HOL_WED")
	private Character weeklyHolidayOnWednesday;
	@Column(name = "MBRN_WEEK_HOL_THU")
	private Character weeklyHolidayOnThursday;
	@Column(name = "MBRN_WEEK_HOL_FRI")
	private Character weeklyHolidayOnFriday;
	@Column(name = "MBRN_WEEK_HOL_SAT")
	private Character weeklyHolidayOnSaturday;
	@Column(name = "MBRN_WEEK_HOL_SUN")
	private Character weeklyHolidayOnSunday;
	@Column(name = "MBRN_HALF_WORK_MON")
	private Character halfWorkingDayOnMonday;
	@Column(name = "MBRN_HALF_WORK_TUE")
	private Character halfWorkingDayOnTuesday;
	@Column(name = "MBRN_HALF_WORK_WED")
	private Character halfWorkingDayOnWednesday;
	@Column(name = "MBRN_HALF_WORK_THU")
	private Character halfWorkingDayOnThursday;
	@Column(name = "MBRN_HALF_WORK_FRI")
	private Character halfWorkingDayOnFriday;
	@Column(name = "MBRN_HALF_WORK_SAT")
	private Character halfWorkingDayOnSaturday;
	@Column(name = "MBRN_HALF_WORK_SUN")
	private Character halfWorkingDayOnSunday;
	@Column(name = "MBRN_AUTH_DLR_CODE", length = 20)
	private String authorizedDealerCode;
	@Column(name = "MBRN_BSR_CODE", length = 7)
	private String bsrCode;
	@Column(name = "MBRN_STATUS_FLG")
	private Character statusFlag;
	@Column(name = "MBRN_CLOSURE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date closureDate;
	@Basic(optional = false)
	@Column(name = "MBRN_ENTD_BY", nullable = false, length = 8)
	private String enteredBy;
	@Basic(optional = false)
	@Column(name = "MBRN_ENTD_ON", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date enteredOn;
	@Column(name = "MBRN_LAST_MOD_BY", length = 8)
	private String lastModifiedBy;
	@Column(name = "MBRN_LAST_MOD_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedOn;
	@Column(name = "MBRN_AUTH_BY", length = 8)
	private String authorizedBy;
	@Column(name = "MBRN_AUTH_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date authorizedOn;
	@Column(name = "TBA_MAIN_KEY", length = 25)
	private String tbaMainKey;
	@Column(name = "MBRN_CRMS", length = 2)
	private String crmsCode;

	public BranchKey getBranchKey() {
		return branchKey;
	}

	public void setBranchKey(BranchKey branchKey) {
		this.branchKey = branchKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getAddress4() {
		return address4;
	}

	public void setAddress4(String address4) {
		this.address4 = address4;
	}

	public String getAddress5() {
		return address5;
	}

	public void setAddress5(String address5) {
		this.address5 = address5;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public String getAdminUnitType() {
		return adminUnitType;
	}

	public void setAdminUnitType(String adminUnitType) {
		this.adminUnitType = adminUnitType;
	}

	public Integer getParentAdminCode() {
		return parentAdminCode;
	}

	public void setParentAdminCode(Integer parentAdminCode) {
		this.parentAdminCode = parentAdminCode;
	}

	public Short getNumberOfExtensionCounter() {
		return numberOfExtensionCounter;
	}

	public void setNumberOfExtensionCounter(Short numberOfExtensionCounter) {
		this.numberOfExtensionCounter = numberOfExtensionCounter;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Character getAuthorizedForexDealer() {
		return authorizedForexDealer;
	}

	public void setAuthorizedForexDealer(Character authorizedForexDealer) {
		this.authorizedForexDealer = authorizedForexDealer;
	}

	public Character getAuthorizedForForeignCurrencyDeposit() {
		return authorizedForForeignCurrencyDeposit;
	}

	public void setAuthorizedForForeignCurrencyDeposit(Character authorizedForForeignCurrencyDeposit) {
		this.authorizedForForeignCurrencyDeposit = authorizedForForeignCurrencyDeposit;
	}

	public Integer getMicrCode() {
		return micrCode;
	}

	public void setMicrCode(Integer micrCode) {
		this.micrCode = micrCode;
	}

	public Character getMainBranchInLocation() {
		return mainBranchInLocation;
	}

	public void setMainBranchInLocation(Character mainBranchInLocation) {
		this.mainBranchInLocation = mainBranchInLocation;
	}

	public Integer getLinkedServiceMainBranch() {
		return linkedServiceMainBranch;
	}

	public void setLinkedServiceMainBranch(Integer linkedServiceMainBranch) {
		this.linkedServiceMainBranch = linkedServiceMainBranch;
	}

	public Character getDdIssueAllowed() {
		return ddIssueAllowed;
	}

	public void setDdIssueAllowed(Character ddIssueAllowed) {
		this.ddIssueAllowed = ddIssueAllowed;
	}

	public Character getTtIssueAllowed() {
		return ttIssueAllowed;
	}

	public void setTtIssueAllowed(Character ttIssueAllowed) {
		this.ttIssueAllowed = ttIssueAllowed;
	}

	public Character getSplitPremises() {
		return splitPremises;
	}

	public void setSplitPremises(Character splitPremises) {
		this.splitPremises = splitPremises;
	}

	public Short getNumberOfSplitPremises() {
		return numberOfSplitPremises;
	}

	public void setNumberOfSplitPremises(Short numberOfSplitPremises) {
		this.numberOfSplitPremises = numberOfSplitPremises;
	}

	public Character getLocalClearingMember() {
		return localClearingMember;
	}

	public void setLocalClearingMember(Character localClearingMember) {
		this.localClearingMember = localClearingMember;
	}

	public Character getNationalClearingMember() {
		return nationalClearingMember;
	}

	public void setNationalClearingMember(Character nationalClearingMember) {
		this.nationalClearingMember = nationalClearingMember;
	}

	public Character getHighValueClearingMember() {
		return highValueClearingMember;
	}

	public void setHighValueClearingMember(Character highValueClearingMember) {
		this.highValueClearingMember = highValueClearingMember;
	}

	public Short getNumberOfOfficersAvailable() {
		return numberOfOfficersAvailable;
	}

	public void setNumberOfOfficersAvailable(Short numberOfOfficersAvailable) {
		this.numberOfOfficersAvailable = numberOfOfficersAvailable;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public Character getClearingBasedOnMicr() {
		return clearingBasedOnMicr;
	}

	public void setClearingBasedOnMicr(Character clearingBasedOnMicr) {
		this.clearingBasedOnMicr = clearingBasedOnMicr;
	}

	public Character getCashManagementBranch() {
		return cashManagementBranch;
	}

	public void setCashManagementBranch(Character cashManagementBranch) {
		this.cashManagementBranch = cashManagementBranch;
	}

	public Character getRealTimeGrossSettlementDepositEnabled() {
		return realTimeGrossSettlementDepositEnabled;
	}

	public void setRealTimeGrossSettlementDepositEnabled(Character realTimeGrossSettlementDepositEnabled) {
		this.realTimeGrossSettlementDepositEnabled = realTimeGrossSettlementDepositEnabled;
	}

	public String getBaseCurrencyCode() {
		return baseCurrencyCode;
	}

	public void setBaseCurrencyCode(String baseCurrencyCode) {
		this.baseCurrencyCode = baseCurrencyCode;
	}

	public String getTelephoneNumber1() {
		return telephoneNumber1;
	}

	public void setTelephoneNumber1(String telephoneNumber1) {
		this.telephoneNumber1 = telephoneNumber1;
	}

	public String getTelephoneNumber2() {
		return telephoneNumber2;
	}

	public void setTelephoneNumber2(String telephoneNumber2) {
		this.telephoneNumber2 = telephoneNumber2;
	}

	public String getTelephoneNumber3() {
		return telephoneNumber3;
	}

	public void setTelephoneNumber3(String telephoneNumber3) {
		this.telephoneNumber3 = telephoneNumber3;
	}

	public String getTelephoneNumber4() {
		return telephoneNumber4;
	}

	public void setTelephoneNumber4(String telephoneNumber4) {
		this.telephoneNumber4 = telephoneNumber4;
	}

	public String getTelephoneNumber5() {
		return telephoneNumber5;
	}

	public void setTelephoneNumber5(String telephoneNumber5) {
		this.telephoneNumber5 = telephoneNumber5;
	}

	public String getTelephoneNumber6() {
		return telephoneNumber6;
	}

	public void setTelephoneNumber6(String telephoneNumber6) {
		this.telephoneNumber6 = telephoneNumber6;
	}

	public String getFaxNumber1() {
		return faxNumber1;
	}

	public void setFaxNumber1(String faxNumber1) {
		this.faxNumber1 = faxNumber1;
	}

	public String getFaxNumber2() {
		return faxNumber2;
	}

	public void setFaxNumber2(String faxNumber2) {
		this.faxNumber2 = faxNumber2;
	}

	public String getFaxNumber3() {
		return faxNumber3;
	}

	public void setFaxNumber3(String faxNumber3) {
		this.faxNumber3 = faxNumber3;
	}

	public String getFaxNumber4() {
		return faxNumber4;
	}

	public void setFaxNumber4(String faxNumber4) {
		this.faxNumber4 = faxNumber4;
	}

	public String getFaxNumber5() {
		return faxNumber5;
	}

	public void setFaxNumber5(String faxNumber5) {
		this.faxNumber5 = faxNumber5;
	}

	public String getFaxNumber6() {
		return faxNumber6;
	}

	public void setFaxNumber6(String faxNumber6) {
		this.faxNumber6 = faxNumber6;
	}

	public String getEmailAddress1() {
		return emailAddress1;
	}

	public void setEmailAddress1(String emailAddress1) {
		this.emailAddress1 = emailAddress1;
	}

	public String getEmailAddress2() {
		return emailAddress2;
	}

	public void setEmailAddress2(String emailAddress2) {
		this.emailAddress2 = emailAddress2;
	}

	public String getSwiftBicCode() {
		return swiftBicCode;
	}

	public void setSwiftBicCode(String swiftBicCode) {
		this.swiftBicCode = swiftBicCode;
	}

	public Character getWeeklyHolidayOnMonday() {
		return weeklyHolidayOnMonday;
	}

	public void setWeeklyHolidayOnMonday(Character weeklyHolidayOnMonday) {
		this.weeklyHolidayOnMonday = weeklyHolidayOnMonday;
	}

	public Character getWeeklyHolidayOnTuesday() {
		return weeklyHolidayOnTuesday;
	}

	public void setWeeklyHolidayOnTuesday(Character weeklyHolidayOnTuesday) {
		this.weeklyHolidayOnTuesday = weeklyHolidayOnTuesday;
	}

	public Character getWeeklyHolidayOnWednesday() {
		return weeklyHolidayOnWednesday;
	}

	public void setWeeklyHolidayOnWednesday(Character weeklyHolidayOnWednesday) {
		this.weeklyHolidayOnWednesday = weeklyHolidayOnWednesday;
	}

	public Character getWeeklyHolidayOnThursday() {
		return weeklyHolidayOnThursday;
	}

	public void setWeeklyHolidayOnThursday(Character weeklyHolidayOnThursday) {
		this.weeklyHolidayOnThursday = weeklyHolidayOnThursday;
	}

	public Character getWeeklyHolidayOnFriday() {
		return weeklyHolidayOnFriday;
	}

	public void setWeeklyHolidayOnFriday(Character weeklyHolidayOnFriday) {
		this.weeklyHolidayOnFriday = weeklyHolidayOnFriday;
	}

	public Character getWeeklyHolidayOnSaturday() {
		return weeklyHolidayOnSaturday;
	}

	public void setWeeklyHolidayOnSaturday(Character weeklyHolidayOnSaturday) {
		this.weeklyHolidayOnSaturday = weeklyHolidayOnSaturday;
	}

	public Character getWeeklyHolidayOnSunday() {
		return weeklyHolidayOnSunday;
	}

	public void setWeeklyHolidayOnSunday(Character weeklyHolidayOnSunday) {
		this.weeklyHolidayOnSunday = weeklyHolidayOnSunday;
	}

	public Character getHalfWorkingDayOnMonday() {
		return halfWorkingDayOnMonday;
	}

	public void setHalfWorkingDayOnMonday(Character halfWorkingDayOnMonday) {
		this.halfWorkingDayOnMonday = halfWorkingDayOnMonday;
	}

	public Character getHalfWorkingDayOnTuesday() {
		return halfWorkingDayOnTuesday;
	}

	public void setHalfWorkingDayOnTuesday(Character halfWorkingDayOnTuesday) {
		this.halfWorkingDayOnTuesday = halfWorkingDayOnTuesday;
	}

	public Character getHalfWorkingDayOnWednesday() {
		return halfWorkingDayOnWednesday;
	}

	public void setHalfWorkingDayOnWednesday(Character halfWorkingDayOnWednesday) {
		this.halfWorkingDayOnWednesday = halfWorkingDayOnWednesday;
	}

	public Character getHalfWorkingDayOnThursday() {
		return halfWorkingDayOnThursday;
	}

	public void setHalfWorkingDayOnThursday(Character halfWorkingDayOnThursday) {
		this.halfWorkingDayOnThursday = halfWorkingDayOnThursday;
	}

	public Character getHalfWorkingDayOnFriday() {
		return halfWorkingDayOnFriday;
	}

	public void setHalfWorkingDayOnFriday(Character halfWorkingDayOnFriday) {
		this.halfWorkingDayOnFriday = halfWorkingDayOnFriday;
	}

	public Character getHalfWorkingDayOnSaturday() {
		return halfWorkingDayOnSaturday;
	}

	public void setHalfWorkingDayOnSaturday(Character halfWorkingDayOnSaturday) {
		this.halfWorkingDayOnSaturday = halfWorkingDayOnSaturday;
	}

	public Character getHalfWorkingDayOnSunday() {
		return halfWorkingDayOnSunday;
	}

	public void setHalfWorkingDayOnSunday(Character halfWorkingDayOnSunday) {
		this.halfWorkingDayOnSunday = halfWorkingDayOnSunday;
	}

	public String getAuthorizedDealerCode() {
		return authorizedDealerCode;
	}

	public void setAuthorizedDealerCode(String authorizedDealerCode) {
		this.authorizedDealerCode = authorizedDealerCode;
	}

	public String getBsrCode() {
		return bsrCode;
	}

	public void setBsrCode(String bsrCode) {
		this.bsrCode = bsrCode;
	}

	public Character getStatusFlag() {
		return statusFlag;
	}

	public void setStatusFlag(Character statusFlag) {
		this.statusFlag = statusFlag;
	}

	public Date getClosureDate() {
		return closureDate;
	}

	public void setClosureDate(Date closureDate) {
		this.closureDate = closureDate;
	}

	public String getEnteredBy() {
		return enteredBy;
	}

	public void setEnteredBy(String enteredBy) {
		this.enteredBy = enteredBy;
	}

	public Date getEnteredOn() {
		return enteredOn;
	}

	public void setEnteredOn(Date enteredOn) {
		this.enteredOn = enteredOn;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getLastModifiedOn() {
		return lastModifiedOn;
	}

	public void setLastModifiedOn(Date lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}

	public String getAuthorizedBy() {
		return authorizedBy;
	}

	public void setAuthorizedBy(String authorizedBy) {
		this.authorizedBy = authorizedBy;
	}

	public Date getAuthorizedOn() {
		return authorizedOn;
	}

	public void setAuthorizedOn(Date authorizedOn) {
		this.authorizedOn = authorizedOn;
	}

	public String getTbaMainKey() {
		return tbaMainKey;
	}

	public void setTbaMainKey(String tbaMainKey) {
		this.tbaMainKey = tbaMainKey;
	}

	public String getCrmsCode() {
		return crmsCode;
	}

	public void setCrmsCode(String crmsCode) {
		this.crmsCode = crmsCode;
	}

}
