package com.rms.api.processor;

import com.rms.api.entity.RemittanceData;
import com.rms.api.model.instantCash.ICExchangePropertyDTO;
import com.rms.api.service.common.RemittanceDataService;
import com.rms.api.service.instantCash.ICNotifyPaymentStatusRemittanceService;
import com.rms.api.service.instantCash.ICOutstandingRemittanceService;
import com.rms.api.service.instantCash.ICPaymentReceiveService;
import com.rms.api.service.instantCash.ICUnlockRemittanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

import static com.rms.api.util.PasswordUtil.generateBase64Hash;

@Component
public class InstantCashAPIProcessor {

    public static final Logger logger = LoggerFactory.getLogger(InstantCashAPIProcessor.class);

    @Autowired
    private ICOutstandingRemittanceService icOutstandingRemittanceService;

    @Autowired
    private ICUnlockRemittanceService icUnlockRemittanceService;

    @Autowired
    private ICNotifyPaymentStatusRemittanceService icNotifyPaymentStatusRemittanceService;
    @Autowired
    private ICPaymentReceiveService icPaymentReceiveService;
    @Autowired
    private RemittanceDataService remittanceDataService;

    @Value("${INSTANT_CASH_API_USER_ID}")
    String icUserId;
    @Value("${INSTANT_CASH_API_USER_RECEIVE_PAYMENT_API_USER_ID}")
    String icPaymentUserId;

    @Value("${INSTANT_CASH_API_USER_PASSWORD}")
    String icPassword;

    public void process(ICExchangePropertyDTO icExchangePropertyDTO) {
        logger.info("InstantCashAPIProcessor..........");
        System.out.println("InstantCashAPIProcessor started.");
        if (Objects.nonNull(icExchangePropertyDTO)) {
            try {
                icExchangePropertyDTO.setPassword(generateBase64Hash(icUserId, icPassword));
                long time = System.currentTimeMillis();
                List<RemittanceData> remittanceDataList = icOutstandingRemittanceService.fetchICOutstandingRemittance(icExchangePropertyDTO);
                List<RemittanceData> notifiedList = icNotifyPaymentStatusRemittanceService.notifyPaymentStatus(icExchangePropertyDTO);
                icUnlockRemittanceService.unlockICOutstandingRemittance(icExchangePropertyDTO);

                logger.info("InstantCashAPIProcessor end.");
            } catch (Exception ex) {
                System.out.println(ex.getLocalizedMessage());
            }
        } else {
            logger.info("Instant Cash API Properties is missing. Please add properties in the DB.");
        }
    }


}
