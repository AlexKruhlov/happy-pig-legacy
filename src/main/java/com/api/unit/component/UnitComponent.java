package com.api.unit.component;

import com.feature.unit.dto.UnitDto;
import com.feature.unit.model.Unit;

import java.util.List;

/**
 * Provides API for UI to work with {@link Unit} objects
 */
public interface UnitComponent {

    /**
     * Finds all unit dtos
     *
     * @return list of unit dtos
     * @see Unit
     * @see UnitDto
     */
    List<UnitDto> findAll();

    /**
     * Saves or updates particular unit and returns it
     *
     * @param unitDto unit dto
     * @return unit dto
     * @see UnitDto
     */
    UnitDto saveOrUpdate(UnitDto unitDto);

    /**
     * Deletes unit object with particular id
     *
     * @param unitId unit object id
     */
    void deleteById(String unitId);
}
