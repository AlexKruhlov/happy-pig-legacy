package com.feature.bank.bankincome.transformer;

import com.feature.bank.bankincome.dto.BankIncomeDto;
import com.feature.bank.bankincome.model.BankIncome;
import com.feature.bank.bankincomesource.transformer.BankIncomeSourceTransformer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = BankIncomeSourceTransformer.class)
public interface BankIncomeTransformer {

    BankIncomeDto toDto(BankIncome bankIncome);

    BankIncome fromDto(BankIncomeDto bankIncomeDto);

    List<BankIncomeDto> toDtos(List<BankIncome> bankIncomes);
}
