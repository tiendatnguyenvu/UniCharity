package com.UniCharity.UniCharity.repositories;

import com.UniCharity.UniCharity.models.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign, Integer> {
}
