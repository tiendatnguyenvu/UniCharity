package com.UniCharity.UniCharity.repositories;

import com.UniCharity.UniCharity.models.PolicyViolation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyViolationRepository extends JpaRepository<PolicyViolation, Integer> {
}
