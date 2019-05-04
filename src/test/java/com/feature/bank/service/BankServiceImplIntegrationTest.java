package com.feature.bank.service;

import com.App;
import com.api.bank.service.BankService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;

import static com.feature.utils.TestUtilMethods.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan(basePackageClasses = App.class)
public class BankServiceImplIntegrationTest {
    private static final BigInteger BANK_BALANCE = ALL_BANK_INCOMES_SUM
            .add(ALL_FROM_FUND_BANK_TRANSACTIONS_SUM)
            .subtract(ALL_TO_FUND_BANK_TRANSACTIONS_SUM);

    @Autowired
    private BankService bankService;

    @Test
    public void shouldGetBank() {
        assertEquals(BANK_BALANCE, bankService.getBank().getBalance());
    }
}
