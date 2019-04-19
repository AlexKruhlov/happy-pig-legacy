package com.feature.bank.service;

import com.api.bank.bankincome.repository.BankIncomeRepository;
import com.api.bank.banktransaction.repository.BankTransactionRepository;
import com.api.bank.service.BankService;
import com.feature.bank.bankincome.model.BankIncome;
import com.feature.bank.banktransaction.model.BankTransaction;
import com.feature.bank.model.Bank;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BankServiceImpl implements BankService {
    private final BankIncomeRepository bankIncomeRepository;
    private final BankTransactionRepository bankTransactionRepository;

    @Override
    public Bank getBank() {
        List<BankIncome> bankIncomes = bankIncomeRepository.findAll();
        List<BankTransaction> bankTransactions = bankTransactionRepository.findAll();
        return Bank.builder()
                .bankIncomes(bankIncomes)
                .bankTransactions(bankTransactions)
                .balance(calculateBalance(bankIncomes, bankTransactions)).build();
    }

    private BigInteger calculateBalance(List<BankIncome> bankIncomes, List<BankTransaction> bankTransactions) {
        return sumBankIncomes(bankIncomes).subtract(sumBankTransactions(bankTransactions));
    }

    private BigInteger sumBankIncomes(List<BankIncome> bankIncomes) {
        return bankIncomes.stream()
                .map(BankIncome::getAmount)
                .reduce(BigInteger.ZERO, BigInteger::add);
    }

    private BigInteger sumBankTransactions(List<BankTransaction> bankTransactions) {
        return bankTransactions.stream()
                .map(BankTransaction::getAmount)
                .reduce(BigInteger.ZERO, BigInteger::add);
    }
}
