package com.rms.api.test;

import com.rms.api.entity.RemittanceData;
import com.rms.api.repository.RemittanceDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TestService {

    @Autowired
    private RemittanceDataRepository remittanceDataRepository;


    Specification<RemittanceData> ageLessThan18 = (root, query, cb) -> cb.lessThan(root.get("age").as(Integer.class), 18);
    Specification<RemittanceData> ageLessThan17 = (root, query, cb) -> cb.lessThan(root.get("age").as(Integer.class), 18);
    Predicate<RemittanceData> predicate = r -> r.getExchangeCode().equals("1452070054");
    Specification<RemittanceData> ageLessThan = ageLessThan17;


    public Specification<RemittanceData> isLongTermCustomer() {
        return (root, query, builder) -> {
            LocalDate date = LocalDate.now().minusDays(1);
            builder.equal(root.get("referenceNo"), "1452070054");
            builder.lessThan(root.get("processDate"), date);
            return builder.and();
        };
    }
}
