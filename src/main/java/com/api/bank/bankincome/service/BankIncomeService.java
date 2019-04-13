package com.api.bank.bankincome.service;

import com.feature.bank.bankincome.dto.BankIncomeDto;
import com.feature.bank.bankincome.model.BankIncome;
import com.feature.prodposition.dto.ProductPositionDto;

import java.util.List;

/**
 * Interface that provides service layer API to work on {@link BankIncome} objects
 */
public interface BankIncomeService {

    /**
     * Find all existed {@link BankIncome} objects, transform them into {@link BankIncomeDto} objects and return
     *
     * @return list of {@link ProductPositionDto} objects or empty list
     */
    List<BankIncomeDto> findAll();

    /**
     * Find {@link BankIncome} object, which has appropriate id, transform it into {@link BankIncomeDto} object
     * and return
     *
     * @param bankIncomeId id of appropriate {@link BankIncome}
     * @return appropriate {@link BankIncomeDto} object or null
     */
    BankIncomeDto findById(String bankIncomeId);

    /**
     * Save or update appropriate {@link BankIncome} objects, which has been transformed from {@link BankIncomeDto},
     * and return it transforming into {@link BankIncomeDto}
     *
     * @param bankIncomeDto apropriate {@link BankIncomeDto} object
     * @return saved {@link BankIncomeDto} object
     */
    BankIncomeDto save(BankIncomeDto bankIncomeDto);

    /**
     * Delete {@link BankIncome} logically by its id
     *
     * @param bankIncomeId id  object {@link BankIncomeDto} object
     */
    void deleteById(String bankIncomeId);
}
