package com.feature.bank.banktransaction.transformer;


import com.feature.bank.banktransaction.dto.BankTransactionDto;
import com.feature.bank.banktransaction.model.BankTransaction;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface BankTransactionTransformer {

    @Mapping(target = "fund", qualifiedByName = "toFullDto")
    BankTransactionDto toDto(BankTransaction bankTransaction);

    BankTransaction fromDto(BankTransactionDto bankTransactionDto);

    @IterableMapping(qualifiedByName = "toFullDto")
    List<BankTransactionDto> toDtos(List<BankTransaction> bankTransactions);
}
