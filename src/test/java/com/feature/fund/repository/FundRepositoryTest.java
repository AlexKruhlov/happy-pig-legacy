package com.feature.fund.repository;

import com.App;
import com.api.fund.repository.FundRepository;
import com.feature.fund.model.Fund;
import com.feature.item.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan(basePackageClasses = App.class)
public class FundRepositoryTest {
    public static final String FUND_ID = "GROCERY_FUND";
    public static final String WRONG_FUND_ID = "WRONG_FUND_ID";
    public static final int ALL_FUND_COUNT = 3;

    @Autowired
    FundRepository fundRepository;

    @Test
    public void shouldFindById() {
        Fund foundFunds = fundRepository.findById(FUND_ID);
        assertNotNull(foundFunds);
        assertEquals(foundFunds.getId(), FUND_ID);
    }

    @Test
    public void shouldFindByIdWithWrongId() {
        assertNull(fundRepository.findById(WRONG_FUND_ID));
    }

    @Test
    public void shouldFindAll() {
        List<Fund> foundFunds = fundRepository.findAll();
        assertNotNull(fundRepository);
        assertEquals(foundFunds.size(), ALL_FUND_COUNT);
    }

    @Test
    public void shouldSaveFund() {
        Fund fund = Fund.builder().name("Family Car").items(singletonList(
           Item.builder().date(LocalDateTime.now()).amount(BigInteger.valueOf(1000)).type("INCOME").build()
        )).build();
        Fund storedFund = fundRepository.save(fund);
        assertNotNull(storedFund);
        System.out.println(storedFund.getItems().get(0).getId());
        assertEquals(storedFund, fundRepository.findById(storedFund.getId()));
    }
}
