package com.rms.api.service.impl.instantCash;

import com.rms.api.entity.ICCashRemittanceData;
import com.rms.api.repository.instantCash.ICCashRemittanceDataRepository;
import com.rms.api.service.instantCash.ICCashRemittanceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ICCashRemittanceDataServiceImpl implements ICCashRemittanceDataService {

    @Autowired
    private ICCashRemittanceDataRepository icCashRemittanceDataRepository;

    @Override
    public ICCashRemittanceData save(ICCashRemittanceData remittanceData) {
        return icCashRemittanceDataRepository.save(remittanceData);
    }

    @Override
    public Optional<ICCashRemittanceData> findByExchangeCodeAndReferenceNoAndProcessStatus(String exchangeCode, String referenceNo, Integer middlewarePush, String processStatus) {
        return icCashRemittanceDataRepository.findByExchangeCodeAndReferenceNoAndMiddlewarePushAndProcessStatus(exchangeCode, referenceNo, middlewarePush, processStatus);
    }

    @Override
    public Optional<ICCashRemittanceData> findByExchangeCodeAndReferenceNo(String exchangeCode, String referenceNo) {
        return icCashRemittanceDataRepository.findByExchangeCodeAndReferenceNo(exchangeCode, referenceNo);
    }


}
