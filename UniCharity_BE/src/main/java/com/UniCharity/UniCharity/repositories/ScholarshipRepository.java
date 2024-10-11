package com.UniCharity.UniCharity.repositories;

import com.UniCharity.UniCharity.models.Scholarship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScholarshipRepository extends JpaRepository<Scholarship, Integer> {
    Optional<Scholarship> findByIdAndStatus(int id, String status);
}
