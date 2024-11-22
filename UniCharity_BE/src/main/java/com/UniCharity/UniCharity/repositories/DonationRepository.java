package com.UniCharity.UniCharity.repositories;

import com.UniCharity.UniCharity.entities.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonationRepository extends JpaRepository<Donation, Integer> {
    List<Donation> findByUserId(int userId);
}
