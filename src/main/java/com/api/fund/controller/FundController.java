package com.api.fund.controller;

import com.feature.fund.dto.FundDto;
import com.feature.fund.dto.FundDtoWithItems;

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
     * @param fundDtoWithItems fund with items object
     * @return all funds with items
     * @see FundDtoWithItems
     */
    FundDtoWithItems update(FundDtoWithItems fundDtoWithItems);

    /**
     * Creates new fund
     *
     * @param fundDto fund object to crate
     * @return all funds
     * @see FundDto
     */
    List<FundDto> saveAndFindAll(FundDto fundDto);

    /**
     * Deletes existed fund with particular id
     *
     * @param id fund id to delete
     * @return all funds
     * @see FundDto
     */
    List<FundDto> deleteByIdAndFindAll(String id);
}
