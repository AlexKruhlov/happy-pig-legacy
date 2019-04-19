package com.feature.bank.model;

import com.feature.bank.bankincome.model.BankIncome;
import com.feature.bank.banktransaction.model.BankTransaction;
import lombok.*;

import java.math.BigInteger;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bank {
    private List<BankIncome> bankIncomes;
    private List<BankTransaction> bankTransactions;
    private BigInteger balance;
}
