package com.api.unit.service;

import com.feature.unit.dto.UnitDto;
import com.feature.unit.model.Unit;

import java.util.List;

/**
 * Provides UnitService layer API to work on {@link Unit} objects
 */
public interface UnitService {

    /**
     * Finds all {@link Unit} objects, transforms into {@link UnitDto} objects and returns them
     *
     * @return list of unit dtos
     * @see UnitDto
     */
    List<UnitDto> findAll();

    /**
     * Saves or updates particular {@link Unit} object after transforming it from {@link UnitDto}.
     * After that returns {@link UnitDto} that was transformed from saved or updated {@link Unit}
     *
     * @return unit dto
     * @see UnitDto
     */
    UnitDto saveOrUpdate(UnitDto unitDto);

    /**
     * Deletes {@link Unit} object with particular id
     *
     * @param unitId unit object id
     */
    void deleteById(String unitId);
}
