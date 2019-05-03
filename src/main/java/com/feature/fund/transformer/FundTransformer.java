package com.feature.fund.transformer;

import com.feature.bank.banktransaction.transformer.BankTransactionTransformer;
import com.feature.fund.dto.FundDto;
import com.feature.fund.dto.FundDtoWithItemsAndTransferFunds;
import com.feature.fund.model.Fund;
import com.feature.item.transformer.ItemTransformer;
import com.feature.transfer.transformer.TransferFundTransformer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;

@Named("FundTransformer")
@Mapper(uses = {TransferFundTransformer.class, ItemTransformer.class, BankTransactionTransformer.class},
        injectionStrategy = CONSTRUCTOR)
public interface FundTransformer {

    @Named("ToDto")
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

    @SuppressWarnings("unused")
    @Named("ToFullDto")
    @Mapping(target = "bankTransactions", expression = "java(null)")
    FundDtoWithItemsAndTransferFunds toFullDto(Fund fund);
}
