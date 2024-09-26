package com.rms.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.rms.api.entity.StopRemittanceData;

@Component
public interface StopRemittanceDataRepository extends JpaRepository<StopRemittanceData, Long> {
	
}
