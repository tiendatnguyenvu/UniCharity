package com.UniCharity.UniCharity.repositories;

import com.UniCharity.UniCharity.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
