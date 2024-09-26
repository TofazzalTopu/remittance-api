package com.rms.api.service.impl.instantCash;

import com.rms.api.entity.ApiTrace;
import com.rms.api.entity.ExchangeHouseProperty;
import com.rms.api.entity.RemittanceData;
import com.rms.api.mapper.ICOutstandingRemittanceMapper;
import com.rms.api.model.instantCash.ICExchangePropertyDTO;
import com.rms.api.model.instantCash.ICOutstandingRemittanceDTO;
import com.rms.api.model.instantCash.ICOutstandingTransactionDTO;
import com.rms.api.service.common.ApiTraceService;
import com.rms.api.service.common.RemittanceDataService;
import com.rms.api.service.instantCash.ICOutstandingRemittanceService;
import com.rms.api.util.ApiUtil;
import com.rms.api.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.rms.api.util.ObjectConverter.convertObjectToString;

@Service
//@Transactional
public class ICOutstandingRemittanceServiceImpl implements ICOutstandingRemittanceService {

    public static final Logger logger = LoggerFactory.getLogger(ICOutstandingRemittanceServiceImpl.class);

    @Autowired
    private ApiTraceService apiTraceService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RemittanceDataService remittanceDataService;

    @Autowired
    private ICOutstandingRemittanceMapper mapper;

    @Override
    @Deprecated
    public List<RemittanceData> fetchICOutstandingRemittance(final ExchangeHouseProperty exchangeHouseProperty, final String key, final String agentId, final String password) {
        List<RemittanceData> remittanceDataArrayList = new ArrayList<>();
        if (!ApiUtil.isNonNull(exchangeHouseProperty, key, agentId, password)) {
            logger.error("Error in fetchICOutstandingRemittance()! ExchangeHouseProperty not exist for ICOutstandingRemittance!");
            return remittanceDataArrayList;
        }

        final ApiTrace trace = apiTraceService.create(exchangeHouseProperty.getExchangeCode(), Constants.REQUEST_TYPE_DOWNLOAD_REQ, null);
        StringBuilder response = new StringBuilder();
        String uuid = UUID.randomUUID().toString();
        try {
            if (Objects.isNull(trace)) {
                logger.info("ERROR in fetchICOutstandingRemittance(), Unable to create apiTrace!");
                return new ArrayList<>();
            }

            HttpEntity<String> httpEntity = ApiUtil.createHttpEntity(null, uuid, agentId, key, password);
            exchangeHouseProperty.setKeyValue("http://localhost:8070/api/OK/fetchICOutstandingRemittance");
            int pageNumber = 1;
            List<ICOutstandingTransactionDTO> transactionDTOArrayList = new ArrayList<>();
            while (pageNumber < 2000) {
                String outstandingUrl = exchangeHouseProperty.getKeyValue() + "?pageNumber=" + pageNumber + "&pageSize=500";
                ResponseEntity<ICOutstandingRemittanceDTO> responseEntity = restTemplate.exchange(exchangeHouseProperty.getKeyValue(), HttpMethod.GET, httpEntity, ICOutstandingRemittanceDTO.class);

                if (HttpStatus.OK.equals(responseEntity.getStatusCode()) && Objects.nonNull(responseEntity.getBody())) {
                    ICOutstandingRemittanceDTO icOutstandingRemittanceDTO = responseEntity.getBody();

                    if (Objects.nonNull(icOutstandingRemittanceDTO) && Objects.nonNull(icOutstandingRemittanceDTO.getData()) && !icOutstandingRemittanceDTO.getData().isEmpty()) {
                        transactionDTOArrayList.addAll(icOutstandingRemittanceDTO.getData());
                        response.append(convertObjectToString(responseEntity));
                        pageNumber++;
                    } else {
                        pageNumber = 0;
                    }
                }
            }
            if (!transactionDTOArrayList.isEmpty()) {
//                remittanceDataArrayList = prepareAndProcessOutstandingRemittance(transactionDTOArrayList, exchangeHouseProperty, trace);
                trace.setStatus(Constants.API_STATUS_VALID);
            } else {
                logger.info("Tracing removed because no record found, TraceID: " + trace.getId());
                apiTraceService.deleteById(trace.getId());
                return remittanceDataArrayList;
            }
        } catch (Exception e) {
            logger.error("Error in fetchICOutstandingRemittance for TraceID: " + trace.getId(), e);
            trace.setStatus(Constants.API_STATUS_ERROR);
        }
        trace.setResponseMsg(response.toString());
        apiTraceService.save(trace);
        logger.info("ICOutstandingRemittance download successful!");
        return remittanceDataArrayList;
    }

    @Override
    public List<RemittanceData> fetchICOutstandingRemittance(ICExchangePropertyDTO icDTO) {
        List<RemittanceData> remittanceDataArrayList = new ArrayList<>();
        List<ICOutstandingTransactionDTO> transactionDTOArrayList = new ArrayList<>();
        if (ApiUtil.validateIfICPropertiesIsNotExist(icDTO, icDTO.getOutstandingUrl())) {
            logger.error(Constants.EXCHANGE_HOUSE_PROPERTY_NOT_EXIST_FOR_OUTSTANDING_REMITTANCE);
            return remittanceDataArrayList;
        }
        String uuid = UUID.randomUUID().toString();
        StringBuilder response = new StringBuilder();
        ApiTrace trace = apiTraceService.create(icDTO.getExchangeCode(), Constants.REQUEST_TYPE_DOWNLOAD_REQ, null);
        try {
            if (Objects.isNull(trace)) return new ArrayList<>();
            HttpEntity<String> httpEntity = ApiUtil.createHttpEntity("", uuid, icDTO);
            icDTO.setOutstandingUrl("http://localhost:8070/api/OK/fetchICOutstandingRemittance");
            int pageNumber = 1;
            while (pageNumber < 2000) {
                String outstandingUrl = icDTO.getOutstandingUrl() + "?pageNumber=" + pageNumber + "&pageSize=1000";
                ResponseEntity<ICOutstandingRemittanceDTO> responseEntity = restTemplate.exchange(icDTO.getOutstandingUrl(), HttpMethod.GET, httpEntity, ICOutstandingRemittanceDTO.class);

                if (HttpStatus.OK.equals(responseEntity.getStatusCode()) && Objects.nonNull(responseEntity.getBody()) && !responseEntity.getBody().getData().isEmpty()) {
                    transactionDTOArrayList.addAll(responseEntity.getBody().getData());
                    response.append(convertObjectToString(responseEntity.getBody()));
                    pageNumber++;
                } else {
                    pageNumber = 0;
                }
            }

            if (!transactionDTOArrayList.isEmpty()) {
                remittanceDataArrayList = prepareAndProcessOutstandingRemittance(transactionDTOArrayList, icDTO.getExchangeCode(), trace);
                trace.setStatus(Constants.API_STATUS_VALID);
            } else {
                logger.info("Tracing removed because no record found, TraceID: " + trace.getId());
                apiTraceService.deleteById(trace.getId());
                return remittanceDataArrayList;
            }
        } catch (Exception e) {
            logger.error("Error in fetchICOutstandingRemittance for TraceID: " + trace.getId(), e);
            trace.setStatus(Constants.API_STATUS_ERROR);
        }
        long time = System.currentTimeMillis();
        System.out.println("apiTrace Saving started...");
        trace.setResponseMsg(response.toString());
        trace.setCorrelationId(uuid);
        apiTraceService.save(trace);
        long milis = System.currentTimeMillis() - time;
        System.out.println("apiTrace save Total Time: " + TimeUnit.MILLISECONDS.toSeconds(milis));
        logger.info("ICOutstandingRemittance download successful!");
        return remittanceDataArrayList;
    }

    private List<RemittanceData> prepareAndProcessOutstandingRemittance(List<ICOutstandingTransactionDTO> transactionDTOArrayList, String exchangeCode, ApiTrace trace) throws ParseException {
        DateFormat dt = new SimpleDateFormat("yyyyMMdd");
        List<String> references = transactionDTOArrayList.stream().map(ICOutstandingTransactionDTO::getReference).distinct().collect(Collectors.toList());
        List<String> existingReferences = remittanceDataService.findAllByExchangeCodeAndReferenceDateAndReferenceNumbers(exchangeCode, dt.parse(transactionDTOArrayList.get(0).getSentAt()), references);
        Predicate<ICOutstandingTransactionDTO> removeDuplicateReference = dto -> existingReferences.contains(dto.getReference());
        if (!existingReferences.isEmpty()) transactionDTOArrayList = transactionDTOArrayList.stream().filter(removeDuplicateReference.negate()).collect(Collectors.toList());

        List<RemittanceData> remittanceDataArrayList = transactionDTOArrayList.stream().map(dto -> mapper.prepareRemittanceData(dto, exchangeCode, trace)).collect(Collectors.toList());
//        remittanceDataArrayList.addAll(remittanceDataArrayList);
        System.out.println("Total Records: " + remittanceDataArrayList.size());
        return remittanceDataService.processAndSaveRemittanceData(remittanceDataArrayList, exchangeCode, Constants.EXCHANGE_HOUSE_INSTANT_CASH);
    }

    private List<RemittanceData> prepareAndProcessOutstandingRemittance1(List<ICOutstandingTransactionDTO> transactionDTOArrayList, String exchangeCode, ApiTrace trace) throws ParseException {
        long skip = 0;
        long limit = 1000;
        DateFormat dt = new SimpleDateFormat("yyyyMMdd");
        List<RemittanceData> remittanceDataList = new ArrayList<>();
        while (limit <= transactionDTOArrayList.size()) {
            List<ICOutstandingTransactionDTO> dtoList = new ArrayList<>();
            if (skip == 0) {
                dtoList = transactionDTOArrayList.stream().limit(limit).collect(Collectors.toList());
            } else {
                dtoList = transactionDTOArrayList.stream().skip(skip).limit(limit).collect(Collectors.toList());
            }
            List<String> newReferences = dtoList.stream().map(ICOutstandingTransactionDTO::getReference).distinct().collect(Collectors.toList());
            List<String> existingReferences = remittanceDataService.findAllByExchangeCodeAndReferenceDateAndReferenceNumbers(exchangeCode, dt.parse(transactionDTOArrayList.get(0).getSentAt()), newReferences);

            List<RemittanceData> remittanceDataArrayList = dtoList.stream().map(dto -> mapper.prepareRemittanceData(dto, exchangeCode, trace))
                    .map(rem-> mapDuplicate(rem, existingReferences)).collect(Collectors.toList());
            remittanceDataList.addAll(remittanceDataArrayList);
            //duplicateList = remittanceDataArrayList.stream().map(this::mapDuplicate).collect(Collectors.toList());
            List<RemittanceData> uniqueList = remittanceDataArrayList.stream().filter(e -> !e.isDuplicate()).collect(Collectors.toList());
            skip = skip + 1000;
            limit = limit + 1000;
        }

        remittanceDataService.processAndSaveRemittanceData(remittanceDataList, exchangeCode, Constants.EXCHANGE_HOUSE_INSTANT_CASH);
        return remittanceDataList;
    }

    public RemittanceData mapDuplicate(RemittanceData rem, List<String> existingReferences) {
        if (existingReferences.contains(rem.getReferenceNo())) {
            rem.setDuplicate(true);
            return rem;
        }
        return rem;
    }

    public RemittanceData mapDuplicate(RemittanceData rem) {
        rem.setDuplicate(true);
        return rem;
    }

}
