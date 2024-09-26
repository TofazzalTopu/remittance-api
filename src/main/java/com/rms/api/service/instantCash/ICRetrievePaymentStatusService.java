package com.rms.api.service.instantCash;

import com.rms.api.entity.ExchangeHouseProperty;
import com.rms.api.entity.RemittanceData;
import com.rms.api.model.instantCash.ICExchangePropertyDTO;
import com.rms.api.model.instantCash.ICPaymentStatusDTO;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface ICRetrievePaymentStatusService {

    @Deprecated
    List<RemittanceData> retrievePaymentStatus(ExchangeHouseProperty exchangeHouseProperty, List<RemittanceData> remittanceDataList, final String key, final String password);
    ICPaymentStatusDTO retrievePaymentStatus(@NotNull String referenceNo, @NotNull ICExchangePropertyDTO dto);

}
