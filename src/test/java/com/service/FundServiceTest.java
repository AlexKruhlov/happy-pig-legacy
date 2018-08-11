package com.service;

import com.api.fund.repository.FundRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
public class FundServiceTest {

    @Autowired
    FundRepository fundRepository;


    @Test
    public void findById() {

    }
//
//    @Test
//    public void findAll() {
//        Assert.assertEquals(fundService.findAll().size(), 1);
//    }
}
