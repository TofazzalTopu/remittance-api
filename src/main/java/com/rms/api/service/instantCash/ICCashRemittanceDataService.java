package com.rms.api.service.instantCash;

import com.rms.api.entity.ICCashRemittanceData;

import java.util.Optional;

public interface ICCashRemittanceDataService {

    ICCashRemittanceData save(ICCashRemittanceData remittanceData);

    Optional<ICCashRemittanceData> findByExchangeCodeAndReferenceNoAndProcessStatus(String exchangeCode, String referenceNo, Integer middlewarePush, String processStatus);

    Optional<ICCashRemittanceData> findByExchangeCodeAndReferenceNo(String exchangeCode, String referenceNo);


}
