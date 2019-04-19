package com.feature.bank.dto;

import com.feature.bank.bankincome.dto.BankIncomeDto;
import com.feature.bank.banktransaction.dto.BankTransactionDto;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class BankDto {
    private List<BankIncomeDto> bankIncomes;
    private List<BankTransactionDto> bankTransactions;
    private String balance;
}
