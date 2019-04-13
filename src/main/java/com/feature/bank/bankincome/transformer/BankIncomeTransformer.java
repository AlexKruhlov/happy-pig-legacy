package com.feature.bank.bankincome.transformer;

import com.feature.bank.bankincome.dto.BankIncomeDto;
import com.feature.bank.bankincome.model.BankIncome;
import com.feature.bank.bankincomesource.transformer.BankIncomeSourceTransformer;
import org.mapstruct.Mapper;

@Mapper(uses = BankIncomeSourceTransformer.class)
public interface BankIncomeTransformer {

    BankIncomeDto toDto(BankIncome bankIncome);

    BankIncome fromDto(BankIncomeDto bankIncomeDto);
}
