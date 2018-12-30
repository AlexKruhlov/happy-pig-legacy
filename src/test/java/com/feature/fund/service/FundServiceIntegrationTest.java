package com.feature.fund.service;

import com.App;
import com.api.fund.service.FundService;
import com.feature.fund.dto.FundDto;
import com.feature.fund.dto.FundDtoWithItemsAndTransferFunds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan(basePackageClasses = App.class)
public class FundServiceIntegrationTest {
    private static final String FUND_ID = "GROCERY_FUND";
    private static final String WRONG_FUND_ID = "WRONG_FUND_ID";
    private static final int ALL_FUND_COUNT = 3;

    @Autowired
    private FundService fundService;

    @Test
    public void shouldFindById() {
        FundDtoWithItemsAndTransferFunds foundFund = fundService.findById(FUND_ID);
        assertNotNull(foundFund);
        assertEquals(FUND_ID, foundFund.getId());
    }

    @Test
    public void shouldFindByIdWithWrongId() {
        assertNull(fundService.findById(WRONG_FUND_ID));
    }

    @Test
    public void shouldFindAll() {
        List<FundDto> fundDtos = fundService.findAll();
        assertNotNull(fundDtos);
        assertEquals(ALL_FUND_COUNT, fundDtos.size());
    }

    @Test
    public void shouldSaveAndFindAll() {
        final String newFund = "Family Car";
        FundDto fundDto = FundDto.builder().name(newFund).build();
        List<FundDto> storedFundDtos = fundService.saveAndFindAll(fundDto);
        int currentFundAmount = ALL_FUND_COUNT + 1;
        assertEquals(storedFundDtos.size(), currentFundAmount);
    }

    @Test
    public void shouldDeleteByIdAndFindAll() {
        FundDto newFundDto = FundDto.builder()
                .name("New fund").build();
        FundDto savedFundDto = fundService.save(newFundDto);
        int fundAmountBeforeDeleting = 4;
        int expectedFundAmount = 3;
        assertEquals(fundAmountBeforeDeleting, fundService.findAll().size());

        fundService.deleteByIdAndFindAll(savedFundDto.getId());
        assertEquals(expectedFundAmount, fundService.findAll().size());
    }
}
