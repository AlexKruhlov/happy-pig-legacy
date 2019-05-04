package com.feature.bank.banktransaction;

import com.App;
import com.api.bank.banktransaction.service.BankTransactionService;
import com.feature.bank.banktransaction.dto.BankTransactionDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import static com.feature.bank.banktransaction.model.BankTransactionType.*;
import static com.feature.utils.TestUtilMethods.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan(basePackageClasses = App.class)
public class BankTransactionServiceIntegrationTest {

    @Autowired
    private BankTransactionService bankTransactionService;

    @Test
    public void shouldFindAllBankTransactions() {
        assertEquals(BANK_TRANSACTIONS_COUNT, bankTransactionService.findAll().size());
    }

    @Test
    public void shouldFindBankTransactionById() {
        assertEquals(BANK_TRANSACTION_GROCERY_FUND,
                bankTransactionService.findById(BANK_TRANSACTION_GROCERY_FUND).getId());
    }

    @Test
    public void shouldFindBankTransactionByIncorrectId() {
        assertNull(bankTransactionService.findById(INCORRECT_ID));
    }

    @Test
    public void shouldSaveBankTransaction() {
        final String amount = "589654";
        final int expectedBankTransactionCount = BANK_TRANSACTIONS_COUNT + 1;
        BankTransactionDto bankTransactionDto = createBankTransactionDto(null, FROM_FUND, amount, GROCERY_FUND);

        bankTransactionService.save(bankTransactionDto);
        assertEquals(expectedBankTransactionCount, bankTransactionService.findAll().size());
    }

    @Test
    public void shouldUpdateBankTransaction() {
        final String amount = "589654";
        final String newAmount = "21000";
        final int expectedBankTransactionCount = BANK_TRANSACTIONS_COUNT + 1;
        BankTransactionDto bankTransactionDto = createBankTransactionDto(null, FROM_FUND, amount, GROCERY_FUND);

        BankTransactionDto savedBankTransactionDto = bankTransactionService.save(bankTransactionDto);
        assertEquals(expectedBankTransactionCount, bankTransactionService.findAll().size());

        savedBankTransactionDto.setAmount(newAmount);
        bankTransactionService.save(savedBankTransactionDto);
        BankTransactionDto expectedBankTransaction = bankTransactionService.findAll().stream()
                .filter(currBankTransactionDto -> currBankTransactionDto.getAmount().equals(newAmount))
                .findFirst().orElse(null);
        assertNotNull(expectedBankTransaction);
    }

    @Test
    public void shouldDeleteBankTransaction() {
        final int expectedBankTransactionCount = BANK_TRANSACTIONS_COUNT - 1;
        bankTransactionService.deleteById(BANK_TRANSACTION_GROCERY_FUND);
        assertEquals(expectedBankTransactionCount, bankTransactionService.findAll().size());
    }
}
