package com.feature.fund.repository;

import com.App;
import com.api.fund.repository.FundRepository;
import com.feature.fund.dto.FundDto;
import com.feature.fund.model.Fund;
import com.feature.item.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
//        Fund fund = Fund.builder().name("Family Car").items(singletonList(
//           Item.builder().date(LocalDateTime.now()).amount(BigInteger.valueOf(1000)).type("INCOME").build()
//        )).build();
//        Fund storedFund = fundRepository.save(fund);
//        assertNotNull(storedFund);
//        List<Fund> fund1 = fundRepository.findAll();
//        assertEquals(storedFund, fundRepository.findAll());
//
//        System.out.println(fundRepository.findAll().stream().peek(System.out::println));
    }

    @Test
    public void shouldUpdateFund(){
//        Fund fund = Fund.builder().name("Family Car").build();
//        List<Item> items = new ArrayList<>();
//        items.add(Item.builder().type("INCOME").date(LocalDateTime.now()).amount(BigInteger.TEN).build());
//        fund.setItems(items);
//
//        Fund storedFund = fundRepository.save(fund);
//        assertNotNull(storedFund);
//
//        storedFund.setName("Private Car");
//        Fund twiceStoredFund = fundRepository.save(storedFund);
//        System.out.println(twiceStoredFund.getItems().get(0).getFundId());
//        assertNotNull(twiceStoredFund.getId());
//        System.out.println(fundRepository.findById(storedFund.getId()).getItems().get(0).getId());
//        assertEquals(twiceStoredFund, fundRepository.findById(storedFund.getId()));
    }
}
