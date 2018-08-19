package com.feature.fund.service;

import com.api.fund.repository.FundRepository;
import com.feature.fund.dto.FundDto;
import com.feature.fund.model.Fund;
import com.feature.fund.transformer.FundTransformer;
import com.feature.fund.transformer.FundTransformerImpl;
import com.feature.item.model.Item;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static com.feature.item.model.ItemTypeConst.EXPENSE;
import static com.feature.item.model.ItemTypeConst.INCOME;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FundServiceUnitTest {
    public static final String FUND_ID = "FUND_ID";
    public static final String FUND_NAME = "FUND_NAME";

    @Mock
    private FundRepository fundRepository;

    @Spy
    private FundTransformer fundTransformer = new FundTransformerImpl();

    @InjectMocks
    public FundServiceImpl fundService;

    @Test
    public void souldCalculateAmountWhenFindById() {
        List<Item> items = new ArrayList<>();
        items.add(createItem("Id1", INCOME, 150));
        items.add(createItem("Id2", EXPENSE, 50));
        items.add(createItem("Id3", INCOME, 27));
        items.add(createItem("Id3", EXPENSE, 32));
        String expectedResult = "95";
        Fund fund = Fund.builder()
                .id(FUND_ID)
                .name(FUND_NAME)
                .amount(BigInteger.ZERO)
                .items(items).build();
        when(fundRepository.findById(FUND_ID)).thenReturn(fund);
        FundDto foundFund = fundService.findById(FUND_ID);
        Assert.assertEquals(expectedResult, foundFund.getAmount());
    }

    @Test
    public void saveOrUpdate() {
    }

    private Fund createFund() {
        return Fund.builder()
                .id(FUND_ID)
                .name(FUND_NAME)
                .amount(BigInteger.ZERO)
                .items(null).build();
    }

    private Item createItem(String id, String type, long amount) {
        return Item.builder()
                .id(id)
                .type(type)
                .amount(BigInteger.valueOf(amount)).build();
    }
}
