package com.feature.fund.transformer;

import com.feature.fund.dto.FundDto;
import com.feature.fund.dto.FundDtoWithItemsAndTransferFunds;
import com.feature.fund.model.Fund;
import com.feature.transfer.transformer.TransferFundTransformer;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = TransferFundTransformer.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface FundTransformer {

    FundDto toDto(Fund fund);

    @Mapping(target = "amount", ignore = true)
    @Mapping(target = "income", ignore = true)
    @Mapping(target = "expense", ignore = true)
    Fund fromDto(FundDto fundIdDto);

    FundDtoWithItemsAndTransferFunds toDtoWithItemsAndTransferFunds(Fund fund);

    @Mapping(target = "amount", ignore = true)
    @Mapping(target = "income", ignore = true)
    @Mapping(target = "expense", ignore = true)
    Fund fromDtoWithItemsAndTransferFunds(FundDtoWithItemsAndTransferFunds fundDtoWithItemsAndTransferFunds);
}
