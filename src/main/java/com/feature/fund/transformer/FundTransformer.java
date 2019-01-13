package com.feature.fund.transformer;

import com.feature.fund.dto.FundDto;
import com.feature.fund.dto.FundDtoWithItemsAndTransferFunds;
import com.feature.fund.model.Fund;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface FundTransformer {

    FundDto toDto(Fund fund);

    @Mappings({
            @Mapping(target = "amount", ignore = true),
            @Mapping(target = "income", ignore = true),
            @Mapping(target = "expense", ignore = true)
    })
    Fund fromDto(FundDto fundIdDto);

    FundDtoWithItemsAndTransferFunds toDtoWithItemsAndTransferFunds(Fund fund);

    @Mappings({
            @Mapping(target = "amount", ignore = true),
            @Mapping(target = "income", ignore = true),
            @Mapping(target = "expense", ignore = true)
    })
    Fund fromDtoWithItemsAndTransferFunds(FundDtoWithItemsAndTransferFunds fundDtoWithItemsAndTransferFunds);
}
