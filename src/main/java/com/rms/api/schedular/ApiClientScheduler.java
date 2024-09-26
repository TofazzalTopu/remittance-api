package com.rms.api.schedular;

import com.rms.api.entity.ExchangeHouseProperty;
import com.rms.api.processor.InstantCashAPIProcessor;
import com.rms.api.processor.RiaAPIProcessor;
import com.rms.api.service.common.ExchangeHousePropertyService;
import com.rms.api.util.ApiUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
@EnableScheduling
public class ApiClientScheduler {

    public static final Logger logger = LoggerFactory.getLogger(ApiClientScheduler.class);

    @Autowired
    private InstantCashAPIProcessor instantCashAPIProcessor;

    @Autowired
    private RiaAPIProcessor riaAPIProcessor;

    @Autowired
    private ExchangeHousePropertyService exchangeHousePropertyService;


    @Scheduled(fixedDelay = 1000 * 60 * 4)
    public void apiClientScheduler() {
        System.out.println("ICScheduler started.");
        try {
            Executor instantCashExecutor = Executors.newFixedThreadPool(1);
            logger.info("InstantCashAPIProcessor started");
            instantCashExecutor.execute(() -> instantCashAPIProcessor.process(ApiUtil.getICExchangeProperties()));
            logger.info("InstantCashAPIProcessor end");

            Executor riaExecutor = Executors.newFixedThreadPool(1);
            riaExecutor.execute(() -> {
//                    riaAPIProcessor.process(riaAPIProcessor);
            });
        } catch (Exception ex) {
            System.out.println(ex);
        }

        System.out.println("ICScheduler ended.");
    }


}
