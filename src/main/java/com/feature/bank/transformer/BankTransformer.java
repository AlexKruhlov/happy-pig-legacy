package com.feature.bank.transformer;

import com.feature.bank.bankincome.transformer.BankIncomeTransformer;
import com.feature.bank.banktransaction.transformer.BankTransactionTransformer;
import com.feature.bank.dto.BankDto;
import com.feature.bank.model.Bank;
import org.mapstruct.Mapper;

@Mapper(uses = {BankIncomeTransformer.class, BankTransactionTransformer.class})
public interface BankTransformer {

    BankDto toDto(Bank bank);

    Bank fromDto(BankDto bankDto);
}
