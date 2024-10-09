package com.UniCharity.UniCharity.repositories;

import com.UniCharity.UniCharity.models.StudentApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentApplicationRepository extends JpaRepository<StudentApplication, Integer> {
}
