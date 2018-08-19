package com.feature.fund.transformer;

import com.feature.fund.dto.FundDto;
import com.feature.fund.model.Fund;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface FundTransformer {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "items", target = "itemDtos"),
            @Mapping(source = "amount", target = "amount")
    })
    FundDto toDto(Fund fund);

    @InheritInverseConfiguration
    Fund fromDto(FundDto fundIdDto);
}
