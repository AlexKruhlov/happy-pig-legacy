package com.api.fund.controller;

import com.feature.fund.dto.FundDto;
import com.feature.fund.dto.FundDtoWithItemsAndTransferFunds;
import com.feature.fund.model.Fund;

import java.util.List;

/**
 * Provides the endpoints to work on funds
 */
public interface FundController {

    /**
     * Finds the fund with the particular id
     *
     * @param id fund id
     * @return fund with the same id
     * @see FundDto
     */
    FundDto findById(String id);

    /**
     * Finds all funds
     *
     * @return list of all funds
     * @see FundDto
     */
    List<FundDto> findAll();

    /**
     * Updates existed fund if it is existed, otherwise saves the fund
     *
     * @param fundDtoWithItemsAndTransferFunds fund with items object
     * @return all funds with items
     * @see FundDtoWithItemsAndTransferFunds
     */
    FundDtoWithItemsAndTransferFunds update(FundDtoWithItemsAndTransferFunds fundDtoWithItemsAndTransferFunds);

    /**
     * Saves new fund and finds all funds
     *
     * @param fundDto fund object to save
     * @return all funds
     * @see FundDto
     */
    List<FundDto> saveAndFindAll(FundDto fundDto);

    /**
     * Delete (logically) {@link Fund} with particular id, find and return all {@link FundDto} objects
     * @param id fund id
     * @return list of {@link FundDto} objects
     */
    List<FundDto> deleteByIdAndFindAll(String id);
}
