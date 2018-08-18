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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan(basePackageClasses = App.class)
public class FundRepositoryTest {
    public static final String FUND_ID = "GROCERY_FUND";
    public static final String FUND_TYPE = "INCOME";
    public static final String WRONG_FUND_ID = "WRONG_FUND_ID";
    public static final int ALL_FUND_COUNT = 3;

    @Autowired
    FundRepository fundRepository;

    @Test
    public void shouldFindById() {
        Fund foundFund = fundRepository.findById(FUND_ID);
        assertNotNull(foundFund);
        assertEquals(foundFund.getId(), FUND_ID);
    }

    @Test
    public void shouldFindByIdWithWrongId() {
        assertNull(fundRepository.findById(WRONG_FUND_ID));
    }

    @Test
    public void shouldFindAll() {
        List<Fund> foundFund = fundRepository.findAll();
        assertNotNull(foundFund);
        assertEquals(foundFund.size(), ALL_FUND_COUNT);
    }

    @Test
    public void shouldSaveFund() {
        Fund fund = Fund.builder().name("Family Car").build();
        Fund storedFund = fundRepository.save(fund);
        assertNotNull(storedFund.getId());
    }

    @Test
    public void shouldUpdateFund(){
        Fund fund = fundRepository.findById(FUND_ID);
        fund.getItems().add(
                Item.builder()
                        .amount(BigInteger.TEN)
                        .date(LocalDateTime.now())
                        .type(FUND_TYPE)
                        .fundId(FUND_ID).build()
        );
        fundRepository.save(fund);
        Fund updatedFund = fundRepository.findById(FUND_ID);
        assertEquals(fund, updatedFund);
    }
}
