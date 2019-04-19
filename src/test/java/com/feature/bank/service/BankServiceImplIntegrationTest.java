package com.feature.bank.service;

import com.App;
import com.api.bank.service.BankService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import static com.feature.utils.TestUtilMethods.BANK_INCOMES_BANK_TRANSACTION_RESIDUAL;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan(basePackageClasses = App.class)
public class BankServiceImplIntegrationTest {

    @Autowired
    private BankService bankService;

    @Test
    public void shouldGetBank() {
        assertEquals(BANK_INCOMES_BANK_TRANSACTION_RESIDUAL, bankService.getBank().getBalance());
    }
}
