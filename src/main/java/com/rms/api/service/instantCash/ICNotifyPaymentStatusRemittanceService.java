package com.rms.api.service.instantCash;

import com.rms.api.entity.ExchangeHouseProperty;
import com.rms.api.entity.RemittanceData;
import com.rms.api.model.instantCash.ICExchangePropertyDTO;
import com.rms.api.model.ria.PaymentApiResponse;

import java.util.List;

public interface ICNotifyPaymentStatusRemittanceService {

   @Deprecated
    List<RemittanceData> notifyPaymentStatus(ExchangeHouseProperty exchangeHouseProperty, List<RemittanceData> remittanceDataList, final String key, final String agentId, final String password);

   List<RemittanceData> notifyPaymentStatus(ICExchangePropertyDTO icExchangePropertyDTO);

    PaymentApiResponse notifyCashPaymentStatus(PaymentApiResponse paymentApiResponse, ICExchangePropertyDTO icDTO, String referenceNo);
}
