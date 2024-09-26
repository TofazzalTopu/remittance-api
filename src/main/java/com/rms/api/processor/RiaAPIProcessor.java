package com.rms.api.processor;

import com.rms.api.entity.ExchangeHouseProperty;
import com.rms.api.model.ria.RiaExchangePropertyDTO;
import com.rms.api.util.ApiUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class RiaAPIProcessor {

    public static final Logger logger = LoggerFactory.getLogger(RiaAPIProcessor.class);

    private final String RIA_DOWNLOADABLE_API = "RIA_DOWNLOADABLE_API";
    private final String RIA_SEARCH_API = "RIA_SEARCH_API";
    private final String RIA_PAYMENT_API = "RIA_PAYMENT_API";
    private final String RIA_OCP_APIM_SUB_KEY = "RIA_OCP_APIM_SUB_KEY";
    private final String RIA_NOTIFY_REM_STATUS_API = "RIA_NOTIFY_REM_STATUS_API";
    private final String RIA_CANCEL_REQ_API = "RIA_CANCEL_REQ_API";
    private final String CANCEL_REQ_RES = "CANCEL_REQ_RES";


    public void process(Map<String, ExchangeHouseProperty> exchangeHousePropertyMap) {
        try {
            RiaExchangePropertyDTO riaProperties = ApiUtil.getRiaExchangePropertyDTO(exchangeHousePropertyMap);
        } catch (Exception e) {
            logger.info("Exception occurred in RiaAPIProcessor.");
        }

    }




}
