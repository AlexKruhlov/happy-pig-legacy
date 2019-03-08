package com.feature.bankincomesource.transformer;

import com.feature.bankincomesource.model.BankIncomeSource;
import com.feature.bankincomesource.dto.BankIncomeSourceDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface BankIncomeSourceTransformer {

    BankIncomeSourceDto toDto(BankIncomeSource bankIncomeSource);

    BankIncomeSource fromDto(BankIncomeSourceDto bankIncomeSourceDto);

    List<BankIncomeSourceDto> toDtos(List<BankIncomeSource> bankIncomeSources);
}
