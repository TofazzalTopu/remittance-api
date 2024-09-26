package com.rms.api.service.impl.common;

import com.rms.api.entity.ExchangeHouseProperty;
import com.rms.api.repository.ExchangeHousePropertyRepository;
import com.rms.api.service.common.ExchangeHousePropertyService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ExchangeHousePropertyServiceImpl implements ExchangeHousePropertyService {

    private static final Logger logger = LoggerFactory.getLogger(ExchangeHousePropertyServiceImpl.class);

    @Autowired
    private ExchangeHousePropertyRepository exchangeHousePropertyRepository;


    @Override
    public List<ExchangeHouseProperty> findAll() {
        return exchangeHousePropertyRepository.findAll(Sort.by("exchangeCode").ascending());
    }

    @Override
    public Optional<ExchangeHouseProperty> findByExchangeCodeAndKeyLabel(String exchangeCode, String keyLabel) {
        return exchangeHousePropertyRepository.findByExchangeCodeAndKeyLabel(exchangeCode, keyLabel);
    }

    @Override
    public List<ExchangeHouseProperty> findAllByExchangeCode(String exchangeCode) {
        return exchangeHousePropertyRepository.findAllByExchangeCode(exchangeCode);
    }

    @Override
    public ExchangeHouseProperty findByKeyLabelEquals(String keyLabel) {
        return exchangeHousePropertyRepository.findByKeyLabelEquals(keyLabel);
    }

    @Override
    public void loadBulkLoadData() {
        exchangeHousePropertyRepository.loadBulkLoadData();
    }


}
