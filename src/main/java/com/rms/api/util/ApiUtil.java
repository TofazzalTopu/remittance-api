package com.rms.api.util;

import com.rms.api.entity.ExchangeHouseProperty;
import com.rms.api.model.instantCash.ICExchangePropertyDTO;
import com.rms.api.model.ria.RiaExchangePropertyDTO;
import com.rms.api.service.common.LoadExchangeHouseProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ApiUtil {

    public static final Logger logger = LoggerFactory.getLogger(ApiUtil.class);


    public final static String IC_OUTSTANDING_API = "IC_OUTSTANDING_API";
    public final static String IC_CONFIRM_API = "IC_CONFIRM_API";
    public final static String IC_STATUS_API = "IC_STATUS_API";
    public final static String IC_UNLOCK_API = "IC_UNLOCK_API";
    public final static String IC_RECEIVE_PAYMENT_API = "IC_RECEIVE_PAYMENT_API";
    public final static String IC_SUB_KEY_PRIMARY = "IC_OCP_APIM_SUB_KEY_PRIMARY";
    public final static String IC_AGENT_ID = "IC_AGENT_ID";
    public final static String IC_PAYMENT_API_AGENT_ID = "IC_PAYMENT_API_AGENT_ID";


    public static HttpHeaders createHeader(String correlationId, String apiFinancialId, String apiKey, String password) {
        HttpHeaders headers = new HttpHeaders();
        try {
            headers.set("x-fapi-financial-id", apiFinancialId);
            headers.set("Authorization", "Basic " + password);
            headers.set("x-correlation-id", correlationId);
            headers.set("x-idempotency-key", UUID.randomUUID().toString());
            headers.set("Ocp-Apim-Subscription-Key", apiKey);
            headers.set("Content-Type", "application/json");
        } catch (Exception e) {
            logger.error("Error in createHeader. Error = " + e);
        }
        return headers;
    }

    public static <T> HttpEntity<T> createHttpEntity(T body, String correlationId, String apiFinancialId, String apiKey, String password) {
        return new HttpEntity<>(body, createHeader(correlationId, apiFinancialId, apiKey, password));
    }

    public static <T> HttpEntity<T> createHttpEntity(T body, String correlationId, ICExchangePropertyDTO dto) {
        return new HttpEntity<>(body, createHeader(correlationId, dto.getAgentId(), dto.getOcpApimSubKey(), dto.getPassword()));
    }

    public static boolean isNonNull(ExchangeHouseProperty property, final String key, final String agentId, final String password) {
        return Objects.nonNull(property.getExchangeCode()) && Objects.nonNull(property.getKeyLabel()) && Objects.nonNull(property.getKeyValue()) && Objects.nonNull(key) && Objects.nonNull(agentId) && Objects.nonNull(password);
    }

    public static boolean validateIfICPropertiesIsNotExist(ICExchangePropertyDTO dto, String url) {
        return Objects.isNull(url) || Objects.isNull(dto.getExchangeCode()) || Objects.isNull(dto.getOcpApimSubKey()) || Objects.isNull(dto.getAgentId()) || Objects.isNull(dto.getPassword());
    }

    public static void validateICExchangePropertiesBeforeProceed(ICExchangePropertyDTO dto, String url, String message) {
        if (validateIfICPropertiesIsNotExist(dto, url)) {
            logger.error(message);
            throw new NullPointerException(message);
        }
    }

    public static ICExchangePropertyDTO getICExchangeProperties() {
        Predicate<ExchangeHouseProperty> icPredicate = e -> e.getKeyLabel().startsWith("IC_");
        List<ExchangeHouseProperty> exchangeHousePropertyList = LoadExchangeHouseProperty.getExchangeHousePropertyList().stream().filter(icPredicate).collect(Collectors.toList());
        ICExchangePropertyDTO icDto = new ICExchangePropertyDTO();
        exchangeHousePropertyList.forEach(e -> {
            icDto.setExchangeCode(e.getExchangeCode());
            if (e.getKeyLabel().equals(IC_AGENT_ID)) {
                icDto.setAgentId(e.getKeyValue());
            } else if (e.getKeyLabel().equals(IC_SUB_KEY_PRIMARY)) {
                icDto.setOcpApimSubKey(e.getKeyValue());
            } else if (e.getKeyLabel().equals(IC_OUTSTANDING_API)) {
                icDto.setOutstandingUrl(e.getKeyValue());
            } else if (e.getKeyLabel().equals(IC_CONFIRM_API)) {
                icDto.setNotifyRemStatusUrl(e.getKeyValue());
            } else if (e.getKeyLabel().equals(IC_RECEIVE_PAYMENT_API)) {
                icDto.setPaymentReceiveUrl(e.getKeyValue());
            } else if (e.getKeyLabel().equals(IC_UNLOCK_API)) {
                icDto.setUnlockUrl(e.getKeyValue());
            } else if (e.getKeyLabel().equals(IC_PAYMENT_API_AGENT_ID)) {
                icDto.setPaymentAgentId(e.getKeyValue());
            } else if (e.getKeyLabel().equals(IC_STATUS_API)) {
                icDto.setStatusUrl(e.getKeyValue());
            }
        });
        return icDto;
    }

    public static RiaExchangePropertyDTO getRiaExchangePropertyDTO(Map<String, ExchangeHouseProperty> exchangeHousePropertyMap) {
        RiaExchangePropertyDTO riaProperties = new RiaExchangePropertyDTO();
        List<ExchangeHouseProperty> riaExchangeHousePropertyList = exchangeHousePropertyMap.values().stream().filter(exchangeHouseProperty -> exchangeHouseProperty.getKeyLabel().startsWith("RIA")).collect(Collectors.toList());
        for (ExchangeHouseProperty p : riaExchangeHousePropertyList) {
            riaProperties.setExchangeCode(p.getExchangeCode());
            if (p.getKeyLabel().equals("RIA_API_VERSION")) {
                riaProperties.setApiVersion(p.getKeyValue());
            } else if (p.getKeyLabel().equals("RIA_AGENT_ID")) {
                riaProperties.setAgentId(p.getKeyValue());
            } else if (p.getKeyLabel().equals("RIA_DOWNLOADABLE_API")) {
                riaProperties.setDownloadableUrl(p.getKeyValue());
            } else if (p.getKeyLabel().equals("RIA_SEARCH_API")) {
                riaProperties.setSearchUrl(p.getKeyValue());
            } else if (p.getKeyLabel().equals("RIA_PAYMENT_API")) {
                riaProperties.setPaymentUrl(p.getKeyValue());
            } else if (p.getKeyLabel().equals("RIA_OCP_APIM_SUB_KEY")) {
                riaProperties.setOcpApimSubKey(p.getKeyValue());
            } else if (p.getKeyLabel().equals("RIA_CASH_PICKUP_CANCEL_API")) {
                riaProperties.setCashPickUpCancelUrl(p.getKeyValue());
            } else if (p.getKeyLabel().equals("RIA_NOTIFY_REM_STATUS_API")) {
                riaProperties.setNotifyRemStatusUrl(p.getKeyValue());
            } else if (p.getKeyLabel().equals("RIA_CANCEL_REQ_API")) {
                riaProperties.setNotifyCancelReqUrl(p.getKeyValue());
            }
        }
        return riaProperties;
    }
}
