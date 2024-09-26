package com.rms.api.service.instantCash;

import com.rms.api.entity.ExchangeHouseProperty;
import com.rms.api.entity.RemittanceData;
import com.rms.api.model.instantCash.ICExchangePropertyDTO;

import java.util.List;

public interface ICOutstandingRemittanceService {

    @Deprecated
    List<RemittanceData> fetchICOutstandingRemittance(ExchangeHouseProperty exchangeHouseProperty, final String key, final String agentId,  final String password);
    List<RemittanceData> fetchICOutstandingRemittance(ICExchangePropertyDTO icExchangePropertyDTO);


}
