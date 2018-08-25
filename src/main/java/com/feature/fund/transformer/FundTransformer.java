package com.feature.fund.transformer;

import com.feature.fund.dto.FundDto;
import com.feature.fund.dto.FundDtoWithItems;
import com.feature.fund.model.Fund;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper
public interface FundTransformer {

    FundDto toDto(Fund fund);

    @InheritInverseConfiguration
    Fund fromDto(FundDto fundIdDto);

    FundDtoWithItems toDtoWithItems(Fund fund);
}
