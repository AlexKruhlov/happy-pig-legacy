package com.feature.bank.bankincomesource.transformer;

import com.feature.bank.bankincomesource.model.BankIncomeSource;
import com.feature.bank.bankincomesource.dto.BankIncomeSourceDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface BankIncomeSourceTransformer {

    BankIncomeSourceDto toDto(BankIncomeSource bankIncomeSource);

    BankIncomeSource fromDto(BankIncomeSourceDto bankIncomeSourceDto);

    List<BankIncomeSourceDto> toDtos(List<BankIncomeSource> bankIncomeSources);
}
