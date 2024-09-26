package com.rms.api.service.common;

import com.rms.api.entity.ExchangeHouseProperty;

import java.util.List;
import java.util.Optional;

public interface ExchangeHousePropertyService {

    List<ExchangeHouseProperty> findAll();

    Optional<ExchangeHouseProperty> findByExchangeCodeAndKeyLabel(String exchangeCode, String keyLabel);

    List<ExchangeHouseProperty> findAllByExchangeCode(String exchangeCode);

    ExchangeHouseProperty findByKeyLabelEquals(String keyLabel);

    public void loadBulkLoadData();

}
