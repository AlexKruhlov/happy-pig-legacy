package com.feature.bank.banktransaction.transformer;


import com.feature.bank.bankincome.dto.BankIncomeDto;
import com.feature.bank.banktransaction.dto.BankTransactionDto;
import com.feature.bank.banktransaction.model.BankTransaction;
import com.feature.fund.transformer.FundTransformer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = FundTransformer.class)
public interface BankTransactionTransformer {

    BankIncomeDto toDto(BankTransaction bankTransaction);

    BankTransaction fromDto(BankTransactionDto bankTransactionDto);

    List<BankTransactionDto> toDtos(List<BankTransaction> bankTransactions);
}
