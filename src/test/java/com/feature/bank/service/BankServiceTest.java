package com.feature.bank.service;

import com.api.bank.bankincome.repository.BankIncomeRepository;
import com.api.bank.banktransaction.repository.BankTransactionRepository;
import com.feature.bank.bankincome.model.BankIncome;
import com.feature.bank.bankincomesource.model.BankIncomeSource;
import com.feature.bank.banktransaction.model.BankTransaction;
import com.feature.bank.model.Bank;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static com.feature.bank.banktransaction.model.BankTransactionType.FROM_FUND;
import static com.feature.bank.banktransaction.model.BankTransactionType.TO_FUND;
import static com.feature.utils.TestUtilMethods.*;
import static java.math.BigInteger.valueOf;
import static java.util.Collections.emptyList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BankServiceTest {
    private static final BigInteger BANK_TRANSACTION_FROM_FUND_AMOUNT = valueOf(125_000L);
    private static final BigInteger BANK_TRANSACTION_TO_FUND_AMOUNT = valueOf(85_000L);
    private static final String BANK_TRANSACTION_ID_1 = "BANK_TRANSACTION_ID_1";
    private static final String BANK_TRANSACTION_ID_2 = "BANK_TRANSACTION_ID_2";

    private static final String FUND_1 = "FUND_1";
    private static final String FUND_2 = "FUND_2";

    private static final String BANK_INCOME_ID_1 = "BANK_INCOME_ID_1";
    private static final String BANK_INCOME_ID_2 = "BANK_INCOME_ID_2";
    private static final BigInteger BANK_INCOME_AMOUNT_1 = valueOf(452_987L);
    private static final BigInteger BANK_INCOME_AMOUNT_2 = valueOf(100_000L);
    private static final BankIncomeSource BANK_INCOME_SOURCE = createBankIncomeSource("SALARY", "Salary");

    @Mock
    private BankIncomeRepository bankIncomeRepository;

    @Mock
    private BankTransactionRepository bankTransactionRepository;

    @InjectMocks
    private BankServiceImpl bankServiceImpl;

    @Test
    public void shouldCalculateBankBalance() {
        List<BankTransaction> bankTransactions = new ArrayList<>();
        bankTransactions.add(createBankTransaction(BANK_TRANSACTION_ID_1, FROM_FUND, BANK_TRANSACTION_FROM_FUND_AMOUNT, FUND_1));
        bankTransactions.add(createBankTransaction(BANK_TRANSACTION_ID_2, TO_FUND, BANK_TRANSACTION_TO_FUND_AMOUNT, FUND_2));

        List<BankIncome> bankIncomes = new ArrayList<>();
        bankIncomes.add(createBankIncome(BANK_INCOME_ID_1, BANK_INCOME_AMOUNT_1, BANK_INCOME_SOURCE));
        bankIncomes.add(createBankIncome(BANK_INCOME_ID_2, BANK_INCOME_AMOUNT_2, BANK_INCOME_SOURCE));

        BigInteger expectedBankBalance = BANK_INCOME_AMOUNT_1.add(BANK_INCOME_AMOUNT_2)
                .add(BANK_TRANSACTION_FROM_FUND_AMOUNT).subtract(BANK_TRANSACTION_TO_FUND_AMOUNT);

        when(bankIncomeRepository.findAll()).thenReturn(bankIncomes);
        when(bankTransactionRepository.findAll()).thenReturn(bankTransactions);

        Bank bank = bankServiceImpl.getBank();
        assertEquals(expectedBankBalance, bank.getBalance());
    }

    @Test
    public void shouldCalculateBankBalanceWithEmptyBankIncomes() {
        List<BankTransaction> bankTransactions = new ArrayList<>();
        bankTransactions.add(createBankTransaction(BANK_TRANSACTION_ID_1, FROM_FUND, BANK_TRANSACTION_FROM_FUND_AMOUNT, FUND_1));
        bankTransactions.add(createBankTransaction(BANK_TRANSACTION_ID_2, TO_FUND, BANK_TRANSACTION_TO_FUND_AMOUNT, FUND_2));
        BigInteger expectedBankBalance =
                BANK_TRANSACTION_FROM_FUND_AMOUNT.subtract(BANK_TRANSACTION_TO_FUND_AMOUNT);

        when(bankIncomeRepository.findAll()).thenReturn(emptyList());
        when(bankTransactionRepository.findAll()).thenReturn(bankTransactions);

        Bank bank = bankServiceImpl.getBank();
        assertEquals(expectedBankBalance, bank.getBalance());
    }

    @Test
    public void shouldCalculateBankBalanceWithEmptyBankTransactions() {
        List<BankIncome> bankIncomes = new ArrayList<>();
        bankIncomes.add(createBankIncome(BANK_INCOME_ID_1, BANK_INCOME_AMOUNT_1, BANK_INCOME_SOURCE));
        bankIncomes.add(createBankIncome(BANK_INCOME_ID_2, BANK_INCOME_AMOUNT_2, BANK_INCOME_SOURCE));
        BigInteger expectedBankBalance = BANK_INCOME_AMOUNT_1.add(BANK_INCOME_AMOUNT_2);

        when(bankIncomeRepository.findAll()).thenReturn(bankIncomes);
        when(bankTransactionRepository.findAll()).thenReturn(emptyList());

        Bank bank = bankServiceImpl.getBank();
        assertEquals(expectedBankBalance, bank.getBalance());
    }
}
