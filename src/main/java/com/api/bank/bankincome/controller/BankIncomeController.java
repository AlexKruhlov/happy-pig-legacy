package com.api.bank.bankincome.controller;

import com.feature.bank.bankincome.dto.BankIncomeDto;
import com.feature.bank.bankincome.model.BankIncome;
import com.feature.prodposition.dto.ProductPositionDto;

import java.util.List;

/**
 * Interface that provides API for UI to work on {@link BankIncome} objects
 */
public interface BankIncomeController {

    /**
     * Find all existed {@link BankIncomeDto} objects
     *
     * @return list of {@link ProductPositionDto} objects or empty list
     */
    List<BankIncomeDto> findAll();

    /**
     * Find {@link BankIncomeDto} object, which has appropriate id and return it
     *
     * @param bankIncomeId id of appropriate {@link BankIncome}
     * @return appropriate {@link BankIncomeDto} object or null
     */
    BankIncomeDto findById(String bankIncomeId);

    /**
     * Save or update appropriate {@link BankIncomeDto} object and return it
     *
     * @param bankIncomeDto appropriate {@link BankIncomeDto} object
     * @return saved {@link BankIncomeDto} object
     */
    BankIncomeDto save(BankIncomeDto bankIncomeDto);

    /**
     * Delete {@link BankIncomeDto} logically by its id
     *
     * @param bankIncomeId id  object {@link BankIncomeDto} object
     */
    void deleteById(String bankIncomeId);
}
