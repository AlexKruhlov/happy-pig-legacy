package com.feature.bank.bankincome;

import com.App;
import com.api.bank.bankincome.service.BankIncomeService;
import com.feature.bank.bankincome.dto.BankIncomeDto;
import com.feature.bank.bankincome.model.BankIncome;
import com.feature.bank.bankincomesource.model.BankIncomeSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.feature.utils.TestUtilMethods.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan(basePackageClasses = App.class)
public class BankIncomeServiceIntegrationTest {

    @Autowired
    private BankIncomeService bankIncomeService;

    @Test
    public void shouldFindAllBankIncomes() {
        assertEquals(ALL_BANK_INCOMES_COUNT, bankIncomeService.findAll().size());
    }

    @Test
    public void shouldFindBankIncomeById() {
        assertEquals(createBankIncomeDto(BANK_INCOME_SALARY_ID, BANK_INCOME_SALARY_AMOUNT, BANK_INCOME_SOURCE_SALARY),
                bankIncomeService.findById(BANK_INCOME_SALARY_ID));
    }

    @Test
    public void shouldFindBankIncomeByIncorrectId() {
        assertNull(bankIncomeService.findById(INCORRECT_ID));
    }

    @Test
    public void shouldSaveBankIncome() {
        final String bankIncomeAmount = "23654";
        final int expectedBankIncomeCount = ALL_BANK_INCOMES_COUNT + 1;
        BankIncomeDto bankIncomeDto = createBankIncomeDto(null, bankIncomeAmount, BANK_INCOME_SOURCE_SALARY);

        BankIncomeDto savedBankIncomeDto = bankIncomeService.save(bankIncomeDto);
        List<BankIncomeDto> bankIncomeDtos = bankIncomeService.findAll();

        assertEquals(expectedBankIncomeCount, bankIncomeDtos.size());
        assertTrue(bankIncomeDtos.contains(savedBankIncomeDto));
    }

    @Test
    public void shouldUpdateBankIncome() {
        final String newAmount = "7777";

        BankIncomeDto bankIncomeDto = bankIncomeService.findById(BANK_INCOME_SALARY_ID);
        assertNotEquals(newAmount, bankIncomeDto.getAmount());

        bankIncomeDto.setAmount(newAmount);
        bankIncomeService.save(bankIncomeDto);

        BankIncomeDto savedBankIncomeDto = bankIncomeService.save(bankIncomeDto);
        List<BankIncomeDto> bankIncomeDtos = bankIncomeService.findAll();

        assertEquals(ALL_BANK_INCOMES_COUNT, bankIncomeDtos.size());
        assertTrue(bankIncomeDtos.contains(savedBankIncomeDto));
    }

    @Test
    public void shouldDeleteBankIncomeById(){
        final int expectedBankIncomesCount = ALL_BANK_INCOMES_COUNT - 1;

        bankIncomeService.deleteById(BANK_INCOME_SALARY_ID);
        assertEquals(expectedBankIncomesCount, bankIncomeService.findAll().size());
    }
}
