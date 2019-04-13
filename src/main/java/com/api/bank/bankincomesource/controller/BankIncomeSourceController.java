package com.api.bank.bankincomesource.controller;

import com.feature.bank.bankincomesource.dto.BankIncomeSourceDto;
import com.feature.bank.bankincomesource.model.BankIncomeSource;
import com.feature.prodposition.dto.ProductPositionDto;

import java.util.List;

/**
 * Interface that provides API for UI to work on {@link BankIncomeSource} objects
 */
public interface BankIncomeSourceController {

    /**
     * Find all existed {@link BankIncomeSourceDto}
     *
     * @return list of {@link ProductPositionDto} objects or empty list
     */
    List<BankIncomeSourceDto> findAll();

    /**
     * Save or update {@link BankIncomeSource}, transform it into {@link BankIncomeSourceDto} and return
     *
     * @param bankIncomeSourceDto bank income source dto object that should be updated or saved
     * @return updated or saved bank income source dto object
     */
    BankIncomeSourceDto save(BankIncomeSourceDto bankIncomeSourceDto);

    /**
     * Delete {@link BankIncomeSource} by its id
     *
     * @param bankIncomeSourceId id of bank income source object
     */
    void deleteById(String bankIncomeSourceId);
}
