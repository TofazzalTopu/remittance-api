package com.rms.api.repository.instantCash;

import com.rms.api.entity.ICCashRemittanceData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICCashRemittanceDataRepository extends JpaRepository<ICCashRemittanceData, Long> {
    Optional<ICCashRemittanceData> findByExchangeCodeAndReferenceNoAndMiddlewarePushAndProcessStatus(String exchangeCode, String referenceNo, Integer middlewarePush, String processStatus);

    Optional<ICCashRemittanceData> findByExchangeCodeAndReferenceNo(String exchangeCode, String referenceNo);
}
