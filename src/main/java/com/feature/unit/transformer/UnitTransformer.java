package com.feature.unit.transformer;

import com.feature.unit.dto.UnitDto;
import com.feature.unit.model.Unit;
import org.mapstruct.Mapper;

@Mapper
public interface UnitTransformer {

    UnitDto toDto(Unit unit);

    Unit fromDto(UnitDto unitDto);
}
