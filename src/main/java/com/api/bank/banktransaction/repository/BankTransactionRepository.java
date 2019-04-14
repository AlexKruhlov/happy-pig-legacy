package com.api.bank.banktransaction.repository;

import com.feature.bank.banktransaction.model.BankTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface that provides the data access layer API to work on {@link BankTransaction} objects
 **/
public interface BankTransactionRepository extends JpaRepository<BankTransaction, String> {
}
