package com.feature.transfer.service;

import com.App;
import com.api.transfer.service.TransferService;
import com.feature.transfer.dto.TransferWithFundsDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.feature.utils.TestUtilMethods.DRESS_FUND;
import static com.feature.utils.TestUtilMethods.GROCERY_FUND;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan(basePackageClasses = App.class)
public class TransferServiceIntegrationTest {

    @Autowired
    private TransferService transferService;

    @Test
    public void shouldFindAll() {
        List<TransferWithFundsDto> transferWithFundsDtos = transferService.findAll();
        assertNotNull(transferWithFundsDtos);
        assertEquals(2, transferWithFundsDtos.size());
    }

    @Test
    public void shouldSaveTransfer() {
        String sum = "50";
        TransferWithFundsDto transferWithFundsDto = TransferWithFundsDto.builder()
                .fromFundId(GROCERY_FUND)
                .toFundId(DRESS_FUND)
                .sum(sum)
                .build();

        transferService.save(transferWithFundsDto);

        List<TransferWithFundsDto> actualTransferWithFundsDtos = transferService.findAll();
        assertNotNull(actualTransferWithFundsDtos);
        assertEquals(3, actualTransferWithFundsDtos.size());
    }
}
