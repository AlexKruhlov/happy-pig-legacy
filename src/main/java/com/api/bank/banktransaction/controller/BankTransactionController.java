package com.api.bank.banktransaction.controller;

import com.feature.bank.banktransaction.dto.BankTransactionDto;
import com.feature.bank.banktransaction.model.BankTransaction;

import java.util.List;

/**
 * Interface that provides API for UI to work on {@link BankTransaction} objects
 */
public interface BankTransactionController {

    /**
     * Find all existed {@link BankTransaction} objects, transform them into {@link BankTransactionDto} objects and return
     *
     * @return list of {@link BankTransactionDto} objects or empty list
     */
    List<BankTransactionDto> findAll();

    /**
     * Find {@link BankTransaction} object, which has appropriate id, transform it into {@link BankTransactionDto} object
     * and return
     *
     * @param bankTransactionId id of appropriate {@link BankTransaction}
     * @return appropriate {@link BankTransactionDto} object or null
     */
    BankTransactionDto findById(String bankTransactionId);

    /**
     * Save or update appropriate {@link BankTransaction} object, which has been transformed from {@link BankTransactionDto},
     * and return it transforming into {@link BankTransactionDto}
     *
     * @param bankTransactionDto appropriate {@link BankTransaction} object
     * @return saved {@link BankTransactionDto} object
     */
    BankTransactionDto save(BankTransactionDto bankTransactionDto);

    /**
     * Delete {@link BankTransaction} logically by its id
     *
     * @param bankTransactionId id  object {@link BankTransaction} object
     */
    void deleteById(String bankTransactionId);
}
