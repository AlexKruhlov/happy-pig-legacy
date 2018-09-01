package com.feature.fund.service;

import com.App;
import com.api.fund.service.FundService;
import com.feature.fund.dto.FundDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan(basePackageClasses = App.class)
public class FundServiceTest {

    @Autowired
    private FundService fundService;

    @Test
    @Transactional(propagation = Propagation.NEVER)
    public void shouldDeleteById() {
        FundDto newFundDto = FundDto.builder()
                .name("New fund").build();
        FundDto savedFundDto = fundService.save(newFundDto);
        int fundAmountBeforeDeleting = 4;
        int expectedFundAmount = 3;
        assertEquals(fundAmountBeforeDeleting, fundService.findAll().size());

        fundService.deleteById(savedFundDto.getId());
        assertEquals(expectedFundAmount, fundService.findAll().size());
    }
}
