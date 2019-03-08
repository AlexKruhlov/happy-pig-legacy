package com.feature.bankincomesource;

import com.App;
import com.api.bankincomesource.service.BankIncomeSourceService;
import com.feature.bankincomesource.dto.BankIncomeSourceDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import static com.feature.utils.TestUtilMethods.BANK_INCOME_SOURCE_ID;
import static org.junit.Assert.assertEquals;
import static org.springframework.util.Assert.notNull;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan(basePackageClasses = App.class)
public class BankIncomeSourceServiceIntegrationTest {

    @Autowired
    private BankIncomeSourceService bankIncomeSourceService;

    @Test
    public void shouldFindAllBankIncomeSources() {
        int expectedSize = 3;

        assertEquals(expectedSize, bankIncomeSourceService.findAll().size());
    }

    @Test
    public void shouldSaveBankIncomeSource() {
        BankIncomeSourceDto bankIncomeSourceDto = BankIncomeSourceDto.builder()
                .name("Building rental")
                .build();
        int expectedSize = 4;

        bankIncomeSourceService.save(bankIncomeSourceDto);
        assertEquals(expectedSize, bankIncomeSourceService.findAll().size());
    }

    @Test
    public void shouldUpdateBankIncomeSource() {
        final String buildingRentalName = "Building rental";
        final String anoutherSourceName = "Another source";
        BankIncomeSourceDto bankIncomeSourceDto = BankIncomeSourceDto.builder()
                .name(buildingRentalName)
                .build();
        BankIncomeSourceDto savedBankIncomeDto = bankIncomeSourceService.save(bankIncomeSourceDto);

        savedBankIncomeDto.setName(anoutherSourceName);
        bankIncomeSourceService.save(savedBankIncomeDto);
        BankIncomeSourceDto updatedBankIncomeSourceDto = bankIncomeSourceService.findAll().stream()
                .filter(bankIncomeSource -> bankIncomeSource.getId().equals(savedBankIncomeDto.getId()))
                .findFirst().orElse(null);
        notNull(updatedBankIncomeSourceDto, "Object should be found");
        assertEquals(anoutherSourceName, updatedBankIncomeSourceDto.getName());
    }

    @Test
    public void shouldDeleteBankIncomeSourceById() {
        int sizeBeforeDeleting = 3;
        assertEquals(sizeBeforeDeleting, bankIncomeSourceService.findAll().size());

        int sizeAfterDeleting = 2;
        bankIncomeSourceService.deleteById(BANK_INCOME_SOURCE_ID);
        assertEquals(sizeAfterDeleting, bankIncomeSourceService.findAll().size());
    }
}
