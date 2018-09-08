package com.api.fund.service;

import com.feature.fund.dto.FundDto;
import com.feature.fund.dto.FundDtoWithItems;

import java.util.List;

/**
 * Provides possibility of working on funds business logic
 */
public interface FundService {

    /**
     * Finds fund model object with particular id and transform it to dto
     *
     * @param id fund id
     * @return fund with items
     * @see FundDtoWithItems
     */
    FundDtoWithItems findById(String id);

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
     * @param fundDtoWithItems fund dto
     * @return fund dto
     * @see FundDtoWithItems
     */
    FundDtoWithItems update(FundDtoWithItems fundDtoWithItems);

    /**
     * Updates (saves) the fund that has been transformed from dto
     * and ruturns it with transformation into dto
     *
     * @param fundDto fund dto
     * @return fund dto
     * @see FundDto
     */
    FundDto save(FundDto fundDto);

    /**
     * Deletes fund by its id
     *
     * @param id fund id
     */
    List<FundDto> saveAndFindAll(FundDto fundDto);

    List<FundDto> deleteByIdAndFindAll(String id);
}
