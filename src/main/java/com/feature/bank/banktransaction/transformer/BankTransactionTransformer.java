package com.feature.bank.banktransaction.transformer;


import com.feature.bank.banktransaction.dto.BankTransactionDto;
import com.feature.bank.banktransaction.model.BankTransaction;
import com.feature.fund.transformer.FundTransformer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = FundTransformer.class)
public interface BankTransactionTransformer {

    @Mapping(target = "fund", qualifiedByName = {"FundTransformer", "ToDto"})
    BankTransactionDto toDto(BankTransaction bankTransaction);

    BankTransaction fromDto(BankTransactionDto bankTransactionDto);

    List<BankTransactionDto> toDtos(List<BankTransaction> bankTransactions);
}
