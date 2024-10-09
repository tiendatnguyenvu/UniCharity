package com.UniCharity.UniCharity.repositories;

import com.UniCharity.UniCharity.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
