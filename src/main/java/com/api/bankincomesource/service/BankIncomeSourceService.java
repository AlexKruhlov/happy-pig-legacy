package com.api.bankincomesource.service;

import com.feature.bankincomesource.dto.BankIncomeSourceDto;
import com.feature.bankincomesource.model.BankIncomeSource;
import com.feature.prodposition.dto.ProductPositionDto;

import java.util.List;

/**
 * Interface that provides service layer API to work on {@link BankIncomeSource} objects
 */
public interface BankIncomeSourceService {

    /**
     * Find all existed {@link BankIncomeSource} objects, transform them into
     * {@link BankIncomeSourceDto} objects and return
     *
     * @return list of {@link ProductPositionDto} objects or empty list
     */
    List<BankIncomeSourceDto> findAll();

    /**
     * Save or update {@link BankIncomeSource}, that was given by transforming from {@link BankIncomeSourceDto},
     * transform it into {@link BankIncomeSourceDto} and return
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
