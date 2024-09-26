package com.rms.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.rms.api.entity.Branch;

@Component
public interface BranchRepository extends JpaRepository<Branch, Long> {

	@Query(value = "SELECT m FROM Branch m WHERE m.branchKey.entityNumber = :entity_number and m.branchKey.branchCode = :branch_code")
	Optional<Branch> getBranch(@Param("entity_number") short entityNumber, @Param("branch_code")int branchCode);
}
