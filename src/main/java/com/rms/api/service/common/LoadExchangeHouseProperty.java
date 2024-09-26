package com.rms.api.service.common;

import com.rms.api.entity.ExchangeHouseProperty;
import com.rms.api.service.common.ExchangeHousePropertyService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class LoadExchangeHouseProperty {

    @Autowired
    private ExchangeHousePropertyService exchangeHousePropertyService;

    @Getter
    public static List<ExchangeHouseProperty> exchangeHousePropertyList = new ArrayList<>();

    @PostConstruct
    public void exchangeHouseProperty() throws Exception {
        exchangeHousePropertyList = exchangeHousePropertyService.findAll();
        System.out.println("ExchangeHousePropertyList size: " + exchangeHousePropertyList.size());
    }

}
