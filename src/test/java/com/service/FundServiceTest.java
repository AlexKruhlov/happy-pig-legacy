package com.service;

import com.App;
import com.api.fund.repository.FundRepository;
import com.feature.fund.model.Fund;
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
public class FundServiceTest {
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
}
