package com.rms.api.model.instantCash;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Objects;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class ICPaymentReceiveTransactionDTO {

    @NotEmpty
    private String reference;
    private String partnerReference;
    @NotEmpty
    private String payingAgentCorrespondentId;
    @NotEmpty
    private String payingAgentName;
    @NotEmpty
    private BigDecimal payingAmount;
    @NotEmpty
    private String payingCurrency;
    @NotEmpty
    private BigDecimal commissionAmount;

    @NotEmpty
    private BigDecimal settlementAmount;

    @NotEmpty
    private BigDecimal settlementRate;
    @NotEmpty
    private String remittancePurpose;
    @NotEmpty
    private String deliveryMode;
    @NotEmpty
    private String originatingCountry;
    @NotEmpty
    private String destinationCountry;

    private String messagePayeeBranch;
    @NotEmpty
    private String sourceOfFunds;
    /**
     Format: yyyy-MM-dd (ISO-8601)
     */
    @NotEmpty
    private String sentAt;
    @NotEmpty
    private ICRemitterDTO remitter;
    @NotEmpty
    private ICBeneficiaryDTO beneficiary;


    public ICPaymentReceiveTransactionDTO() {
    }

    public ICPaymentReceiveTransactionDTO(String reference, String partnerReference, String payingAgentCorrespondentId, String payingAgentName, BigDecimal payingAmount, String payingCurrency, BigDecimal commissionAmount, BigDecimal settlementAmount, BigDecimal settlementRate, String remittancePurpose, String deliveryMode, String originatingCountry, String destinationCountry, String messagePayeeBranch, String sourceOfFunds, String sentAt, ICRemitterDTO remitter, ICBeneficiaryDTO beneficiary) {
        this.reference = reference;
        this.partnerReference = partnerReference;
        this.payingAgentCorrespondentId = payingAgentCorrespondentId;
        this.payingAgentName = payingAgentName;
        this.payingAmount = payingAmount;
        this.payingCurrency = payingCurrency;
        this.commissionAmount = commissionAmount;
        this.settlementAmount = settlementAmount;
        this.settlementRate = settlementRate;
        this.remittancePurpose = remittancePurpose;
        this.deliveryMode = deliveryMode;
        this.originatingCountry = originatingCountry;
        this.destinationCountry = destinationCountry;
        this.messagePayeeBranch = messagePayeeBranch;
        this.sourceOfFunds = sourceOfFunds;
        this.sentAt = sentAt;
        this.remitter = remitter;
        this.beneficiary = beneficiary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ICPaymentReceiveTransactionDTO that = (ICPaymentReceiveTransactionDTO) o;
        return Objects.equals(reference, that.reference) && Objects.equals(partnerReference, that.partnerReference) && Objects.equals(payingAmount, that.payingAmount) && Objects.equals(originatingCountry, that.originatingCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reference, partnerReference, payingAmount, originatingCountry);
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getPartnerReference() {
        return partnerReference;
    }

    public void setPartnerReference(String partnerReference) {
        this.partnerReference = partnerReference;
    }

    public String getPayingAgentCorrespondentId() {
        return payingAgentCorrespondentId;
    }

    public void setPayingAgentCorrespondentId(String payingAgentCorrespondentId) {
        this.payingAgentCorrespondentId = payingAgentCorrespondentId;
    }

    public String getPayingAgentName() {
        return payingAgentName;
    }

    public void setPayingAgentName(String payingAgentName) {
        this.payingAgentName = payingAgentName;
    }

    public BigDecimal getPayingAmount() {
        return payingAmount;
    }

    public void setPayingAmount(BigDecimal payingAmount) {
        this.payingAmount = payingAmount;
    }

    public String getPayingCurrency() {
        return payingCurrency;
    }

    public void setPayingCurrency(String payingCurrency) {
        this.payingCurrency = payingCurrency;
    }

    public BigDecimal getCommissionAmount() {
        return commissionAmount;
    }

    public void setCommissionAmount(BigDecimal commissionAmount) {
        this.commissionAmount = commissionAmount;
    }

    public BigDecimal getSettlementAmount() {
        return settlementAmount;
    }

    public void setSettlementAmount(BigDecimal settlementAmount) {
        this.settlementAmount = settlementAmount;
    }

    public BigDecimal getSettlementRate() {
        return settlementRate;
    }

    public void setSettlementRate(BigDecimal settlementRate) {
        this.settlementRate = settlementRate;
    }

    public String getRemittancePurpose() {
        return remittancePurpose;
    }

    public void setRemittancePurpose(String remittancePurpose) {
        this.remittancePurpose = remittancePurpose;
    }

    public String getDeliveryMode() {
        return deliveryMode;
    }

    public void setDeliveryMode(String deliveryMode) {
        this.deliveryMode = deliveryMode;
    }

    public String getOriginatingCountry() {
        return originatingCountry;
    }

    public void setOriginatingCountry(String originatingCountry) {
        this.originatingCountry = originatingCountry;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public String getMessagePayeeBranch() {
        return messagePayeeBranch;
    }

    public void setMessagePayeeBranch(String messagePayeeBranch) {
        this.messagePayeeBranch = messagePayeeBranch;
    }

    public String getSourceOfFunds() {
        return sourceOfFunds;
    }

    public void setSourceOfFunds(String sourceOfFunds) {
        this.sourceOfFunds = sourceOfFunds;
    }

    public String getSentAt() {
        return sentAt;
    }

    public void setSentAt(String sentAt) {
        this.sentAt = sentAt;
    }

    public ICRemitterDTO getRemitter() {
        return remitter;
    }

    public void setRemitter(ICRemitterDTO remitter) {
        this.remitter = remitter;
    }

    public ICBeneficiaryDTO getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(ICBeneficiaryDTO beneficiary) {
        this.beneficiary = beneficiary;
    }
}
