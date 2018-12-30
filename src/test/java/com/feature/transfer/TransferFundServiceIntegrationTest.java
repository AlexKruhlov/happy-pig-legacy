package com.feature.transfer;

import com.App;
import com.api.transfer.service.TransferFundService;
import com.feature.transfer.dto.TransferFundDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan(basePackageClasses = App.class)
public class TransferFundServiceIntegrationTest {
    private static String GROCERY_FUND_ID = "GROCERY_FUND";

    @Autowired
    private TransferFundService transferFundService;

    @Test
    public void shouldFindByFundId() {
        List<TransferFundDto> transferFunds = transferFundService.findByFundId(GROCERY_FUND_ID);
        assertEquals(2, transferFunds.size());
        assertEquals(transferFunds.get(0).getFundId(), GROCERY_FUND_ID);
    }
}
