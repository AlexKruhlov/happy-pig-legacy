package com.api.bank.bankincome.repository;

import com.feature.bank.bankincome.model.BankIncome;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Provides the data access layer API to work on {@link BankIncome} objects
 **/
public interface BankIncomeRepository extends JpaRepository<BankIncome, String> {
}
