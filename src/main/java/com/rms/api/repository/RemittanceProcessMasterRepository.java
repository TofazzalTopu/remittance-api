package com.rms.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.rms.api.entity.RemittanceProcessMaster;

@Component
public interface RemittanceProcessMasterRepository extends JpaRepository<RemittanceProcessMaster, Long> {
	
}
