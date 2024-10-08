package com.rms.api.service.impl.common;

import com.rms.api.entity.ApiTrace;
import com.rms.api.model.ria.PaymentApiRequest;
import com.rms.api.model.ria.PaymentApiResponse;
import com.rms.api.model.ria.SearchApiRequest;
import com.rms.api.model.ria.SearchApiResponse;
import com.rms.api.repository.ApiTraceRepository;
import com.rms.api.service.common.ApiTraceService;
import com.rms.api.util.Constants;
import com.rms.api.util.DateUtil;
import com.rms.api.util.ObjectConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class ApiTraceServiceImpl implements ApiTraceService {
    private static final Logger logger = LoggerFactory.getLogger(ApiTraceServiceImpl.class);

    @Autowired
    private ApiTraceRepository apiTraceRepository;

    @Override
    public Optional<ApiTrace> findById(Long apiTraceId) {
        return apiTraceRepository.findById(apiTraceId);
    }

    @Override
    public ApiTrace save(ApiTrace apiTrace) {
        try {
            return apiTraceRepository.save(apiTrace);
        } catch (Exception e) {
            logger.error("Error in save() ApiTrace.Error = " + e);
        }
        return null;
    }

    @Override
    public void addToApiTrace(Long apiTraceId, SearchApiResponse response, SearchApiRequest searchApiRequest) {
        ApiTrace api = new ApiTrace();
        if (response == null || searchApiRequest == null)
            return;

        if (Objects.nonNull(apiTraceId)) {
            Optional<ApiTrace> apiOptional = findById(apiTraceId);
            if (apiOptional.isPresent()) {
                api = apiOptional.get();
            }
        }


        if (searchApiRequest.getBrcode() != null)
            api.setBranchCode(Integer.valueOf(searchApiRequest.getBrcode()));
        api.setCbsDate(getCurrentBusinessDate());
        api.setExchangeCode(searchApiRequest.getExchcode());
        api.setIpAddress(searchApiRequest.getIpAddress());
        api.setRequestType(Constants.REQUEST_TYPE_SEARCH);
        api.setRequestMsg(response.getOriginalRequest());
        api.setResponseMsg(response.getOriginalResponse());
        api.setStatus(response.getApiStatus());
        if (Constants.API_STATUS_VALID.equals(response.getApiStatus())) {
            api.setTranno("" + getApiTranSequence());
            response.setTranNo(String.valueOf(api.getTranno()));
        }
        api.setPinNo(searchApiRequest.getPinno());
        api.setExTRANID(response.getExchTranId());
        api.setUserId(searchApiRequest.getBruserid());
        api.setStatus(response.getApiStatus());
        apiTraceRepository.save(api);
    }

    @Override
    public void addToApiTrace(Long apiTraceId, PaymentApiResponse response, PaymentApiRequest paymentApiRequest) {
        ApiTrace api = new ApiTrace();
        if (response == null || paymentApiRequest == null)
            return;

        if (Objects.nonNull(apiTraceId)) {
            Optional<ApiTrace> apiOptional = findById(apiTraceId);
            if (apiOptional.isPresent()) {
                api = apiOptional.get();
            }
        }

        if (paymentApiRequest.getBrCode() != null) {
            api.setBranchCode(Integer.valueOf(paymentApiRequest.getBrCode()));
        }
        api.setCbsDate(getCurrentBusinessDate());
        api.setExchangeCode(paymentApiRequest.getExchCode());
        api.setIpAddress(paymentApiRequest.getIpAddress());
        api.setRequestType(Constants.REQUEST_TYPE_PAYMENT);
        api.setRequestMsg(response.getOriginalRequest());
        api.setResponseMsg(response.getOriginalResponse());
        api.setStatus(response.getApiStatus());
        if (Constants.API_STATUS_VALID.equals(response.getApiStatus())) {
            api.setTranno("" + getApiTranSequence());
            response.setTranNo(String.valueOf(api.getTranno()));
        }
        api.setPinNo(paymentApiRequest.getPinno());
        api.setExTRANID(response.getTransRefID());
        api.setUserId(paymentApiRequest.getBrUserId());
        api.setStatus(response.getApiStatus());
        apiTraceRepository.save(api);
    }

    @Override
    public void deleteById(long id) {
        apiTraceRepository.deleteById(id);
    }

    @Override
    public Long initiateApiTrace(String exchangeCode, String requestType, Date businessDate) {
        try {
            ApiTrace api = create(exchangeCode, requestType, businessDate);
            return api.getId();
        } catch (Exception e) {
            logger.error("Error in initiateApiTrace.Error = " + e);
        }

        return null;
    }

    @Override
    public ApiTrace create(String exchangeCode, String requestType, Date businessDate) {
        // Make initial footprint of API call
        try {
            ApiTrace api = new ApiTrace();
            api.setExchangeCode(exchangeCode);
            api.setRequestType(requestType);
            if (Objects.nonNull(businessDate)) {
                api.setCbsDate(businessDate);
            } else {
                api.setCbsDate(getCurrentBusinessDate());
            }
            api = apiTraceRepository.save(api);
            return api;
        } catch (Exception e) {
            logger.error("Error in ApiTrace create().Error = " + e);
        }

        return null;
    }

    @Override
    public ApiTrace updateStatus(Long apiTraceId, String status) {
        ApiTrace api = new ApiTrace();
        Optional<ApiTrace> apiOptional = findById(apiTraceId);
        if (apiOptional.isPresent()) {
            api = apiOptional.get();
        }
        api.setStatus(status);
        return apiTraceRepository.save(api);
    }

    @Override
    public void saveRequestResponse(Long apiTraceId, String exchangeCode, String request, String response, String requestType) {
        try {
            ApiTrace api = new ApiTrace();

            if (Objects.nonNull(apiTraceId)) {
                Optional<ApiTrace> apiOptional = findById(apiTraceId);
                if (apiOptional.isPresent()) {
                    api = apiOptional.get();
                }
            }
            api.setExchangeCode(exchangeCode);
            api.setCbsDate(getCurrentBusinessDate());
            api.setRequestType(requestType);

            if (Objects.nonNull(request)) {
                api.setRequestMsg(request);
            }
            if (Objects.nonNull(response)) {
                api.setResponseMsg(response);
            }

        } catch (Exception e) {
            logger.error("Error in saveResponse.Error = " + e);
        }
    }

    @Override
    public List<ApiTrace> saveAllApiTrace(List<ApiTrace> apiTraceList) {
        List<ApiTrace> traceList = new ArrayList<>();
        try {
            traceList = apiTraceRepository.saveAll(apiTraceList);
        } catch (Exception e) {
            logger.error("Error in save saveAllApiTrace() = " + e);
        }
        return traceList;
    }

    public Date getCurrentBusinessDate() {
        Timestamp date = apiTraceRepository.getCurrentBusinessDate();
        return DateUtil.convertTimestampToCalendar(date).getTime();
    }

    @Override
    public Optional<ApiTrace> findByTranNo(String tranNo, String requestType) {
        return apiTraceRepository.findByTranNo(tranNo, requestType);
    }

    @Override
    public Timestamp getRefDate(String exchangeCode, String pin, Date tranDate) {
        return apiTraceRepository.getRefDate(exchangeCode, pin, tranDate);
    }

    @Override
    public void updatePayoutStatus(String payoutStatus, List<String> spotIds) {
        apiTraceRepository.updatePayoutStatus(payoutStatus, spotIds);
    }

    @Override
    public void updateSyncFlag(String exchangeCode, String pin, Date tranDate) {
        apiTraceRepository.updateSyncFlag(exchangeCode, pin, tranDate);
    }

    @Override
    public Long getApiTranSequence() {
        return apiTraceRepository.getApiTranSequence();
    }


    @Override
    public <T> ApiTrace buildApiTrace(Long apiTrace, String exchangeCode, String referenceNo, T response, String status) {
        ApiTrace trace = new ApiTrace();
        try {
            Optional<ApiTrace> apTrace = findById(apiTrace);
            if (apTrace.isPresent()) {
                trace = apTrace.get();
            }
            trace.setExchangeCode(exchangeCode);
//            trace.setCbsDate(businessDate);

            if (Objects.nonNull(referenceNo)) trace.setRequestMsg(referenceNo);

            if (Objects.nonNull(response)) {
                trace.setResponseMsg(ObjectConverter.convertObjectToString(response));
            }
            trace.setStatus(status);
        } catch (Exception e) {
            logger.error("Error occurred on processConfirmedRemittanceData buildApiTrace", e);
        }
        return trace;
    }

    @Override
    public ApiTrace saveApiTrace(String exchangeCode, String request, String response, String status, String requestType, String correlationId) {
        try {
            ApiTrace apiTrace = new ApiTrace();
            apiTrace.setExchangeCode(exchangeCode);
            apiTrace.setRequestMsg(request);
            apiTrace.setResponseMsg(response);
            apiTrace.setRequestType(requestType);
            apiTrace.setStatus(status);
            apiTrace.setCbsDate(getCurrentBusinessDate());
            apiTrace.setCorrelationId(correlationId);
            return apiTraceRepository.save(apiTrace);
        } catch (Exception e) {
            logger.error("Error occurred on saveApiTrace", e);
        }
        return null;
    }

}
