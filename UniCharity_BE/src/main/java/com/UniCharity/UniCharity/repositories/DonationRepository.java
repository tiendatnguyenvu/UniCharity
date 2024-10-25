package com.UniCharity.UniCharity.repositories;

import com.UniCharity.UniCharity.entities.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepository extends JpaRepository<Donation, Integer> {
}
