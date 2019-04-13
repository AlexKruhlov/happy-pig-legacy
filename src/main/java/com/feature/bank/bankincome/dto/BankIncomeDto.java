package com.feature.bank.bankincome.dto;

import com.feature.bank.bankincomesource.dto.BankIncomeSourceDto;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class BankIncomeDto {
    private String id;
    private String amount;
    private BankIncomeSourceDto bankIncomeSource;
}
