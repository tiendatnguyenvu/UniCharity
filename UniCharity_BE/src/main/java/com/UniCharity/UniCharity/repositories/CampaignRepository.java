package com.UniCharity.UniCharity.repositories;

import com.UniCharity.UniCharity.entities.Campaign;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampaignRepository extends JpaRepository<Campaign, Integer> {
    List<Campaign> findByStatus(String status, Pageable pageable);
}
