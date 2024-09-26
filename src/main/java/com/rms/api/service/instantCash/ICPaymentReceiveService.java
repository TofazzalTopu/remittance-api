package com.rms.api.service.instantCash;

import com.rms.api.entity.ICCashRemittanceData;
import com.rms.api.entity.RemittanceData;
import com.rms.api.model.instantCash.ICExchangePropertyDTO;
import com.rms.api.model.ria.SearchApiResponse;

import javax.validation.constraints.NotNull;

public interface ICPaymentReceiveService {

    SearchApiResponse paymentReceive(@NotNull ICExchangePropertyDTO dto, @NotNull String referenceNo);

}
