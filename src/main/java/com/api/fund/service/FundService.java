package com.api.fund.service;

import com.feature.fund.dto.FundDto;
import com.feature.fund.dto.FundDtoWithItemsAndTransferFunds;

import java.util.List;

/**
 * Provides possibility of working on fund business logic
 */
public interface FundService {

    /**
     * Finds fund model object with particular id and transform it into dto
     *
     * @param id fund id
     * @return fund with items
     * @see FundDtoWithItemsAndTransferFunds
     */
    FundDtoWithItemsAndTransferFunds findById(String id);

    /**
     * Finds all funds and transforms them into dtos
     *
     * @return fund dtos
     * @see FundDto
     */
    List<FundDto> findAll();

    /**
     * Updates (saves) the fund that has been transformed from dto
     * and returns it with transformation into dto
     *
     * @param fundDtoWithItemsAndTransferFunds fund dto
     * @return fund dto
     * @see FundDtoWithItemsAndTransferFunds
     */
    FundDtoWithItemsAndTransferFunds update(FundDtoWithItemsAndTransferFunds fundDtoWithItemsAndTransferFunds);

    /**
     * Updates (saves) the fund that has been transformed from dto
     * and finds returns it with transformation into dto
     *
     * @param fundDto fund dto
     * @return fund dto
     * @see FundDto
     */
    FundDto save(FundDto fundDto);

    /**
     * Updates (saves) the fund that has been transformed from dto
     * and finds all funds with transformation into dtos
     *
     * @param fundDto fund dto
     * @return list of fund dtos
     * @see FundDto
     */
    List<FundDto> saveAndFindAll(FundDto fundDto);

    /**
     * Deletes fund with particular id and finds all funds
     *
     * @param id fund id
     * @return list of fund dtos
     * @see FundDto
     */
    List<FundDto> deleteByIdAndFindAll(String id);
}
