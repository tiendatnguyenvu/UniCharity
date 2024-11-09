package com.UniCharity.UniCharity.repositories;

import com.UniCharity.UniCharity.entities.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PolicyRepository extends JpaRepository<Policy, Integer> {
    List<Policy> findAllPolicyByCampaignId(int campaignId);
}
