package com.UniCharity.UniCharity.repositories;

import com.UniCharity.UniCharity.models.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CampaignRepository extends JpaRepository<Campaign, Integer> {
    Optional<Campaign> findByStatus(String status);
}
