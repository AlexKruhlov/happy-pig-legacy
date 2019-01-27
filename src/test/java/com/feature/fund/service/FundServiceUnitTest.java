package com.feature.fund.service;

import com.api.fund.repository.FundRepository;
import com.feature.fund.dto.FundDto;
import com.feature.fund.model.Fund;
import com.feature.fund.transformer.FundTransformer;
import com.feature.fund.transformer.FundTransformerImpl;
import com.feature.item.model.Item;
import com.feature.transfer.model.TransferFund;
import com.feature.transfer.model.TransferType;
import com.feature.transfer.transformer.TransferFundTransformerImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.feature.item.model.ItemTypeConst.EXPENSE;
import static com.feature.item.model.ItemTypeConst.INCOME;
import static com.feature.utils.TestUtilMethods.TRANSFER_ID;
import static com.feature.utils.TestUtilMethods.createTransferFund;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FundServiceUnitTest {
    private static final String FUND_ID_1 = "FUND_ID_1";
    private static final String FUND_ID_2 = "FUND_ID_2";

    private static final String ITEM_ID_1 = "ITEM_ID_1";
    private static final String ITEM_ID_2 = "ITEM_ID_2";
    private static final String ITEM_ID_3 = "ITEM_ID_3";
    private static final String ITEM_ID_4 = "ITEM_ID_4";

    @Mock
    private FundRepository fundRepository;

    @Spy
    private FundTransformer fundTransformer = new FundTransformerImpl(new TransferFundTransformerImpl());

    @InjectMocks
    private FundServiceImpl fundService;

    @Test
    public void shouldCalculateAmountWhenFindById() {
        long incomeItem1 = 150;
        long expenseItem2 = 50;
        long incomeItem3 = 27;
        long expenseItem4 = 32;
        long incomeTransferFund1 = 10;
        long outcomeTransferFund1 = 25;
        String expectedResult = "80";

        List<Item> items = new ArrayList<>();
        items.add(createItem(ITEM_ID_1, INCOME, incomeItem1));
        items.add(createItem(ITEM_ID_2, EXPENSE, expenseItem2));
        items.add(createItem(ITEM_ID_3, INCOME, incomeItem3));
        items.add(createItem(ITEM_ID_4, EXPENSE, expenseItem4));

        List<TransferFund> transferFunds = new ArrayList<>();
        transferFunds.add(createTransferFund(TRANSFER_ID, FUND_ID_1, TransferType.INCOME, incomeTransferFund1));
        transferFunds.add(createTransferFund(TRANSFER_ID, FUND_ID_1, TransferType.OUTCOME, outcomeTransferFund1));
        Fund fund = createFund(FUND_ID_1, items, transferFunds);

        when(fundRepository.findById(FUND_ID_1)).thenReturn(Optional.of(fund));

        FundDto foundFund = fundService.findById(FUND_ID_1);
        assertEquals(expectedResult, foundFund.getAmount());
    }

    @Test
    public void shouldCalculateAmountOfAllFunds() {
        long incomeItem1 = 150;
        long expenseItem2 = 50;
        long incomeTransferFund1 = 37;
        String expectedResult1 = "137";
        List<Item> items1 = new ArrayList<>();
        items1.add(createItem(ITEM_ID_1, INCOME, incomeItem1));
        items1.add(createItem(ITEM_ID_2, EXPENSE, expenseItem2));
        List<TransferFund> transferFunds1 = new ArrayList<>();
        transferFunds1.add(createTransferFund(TRANSFER_ID, FUND_ID_1, TransferType.INCOME, incomeTransferFund1));

        long incomeItem3 = 27;
        long expenseItem4 = 32;
        long outcomeTransferFund2 = 27;
        String expectedResult2 = "-32";
        List<Item> items2 = new ArrayList<>();
        items2.add(createItem(ITEM_ID_3, INCOME, incomeItem3));
        items2.add(createItem(ITEM_ID_4, EXPENSE, expenseItem4));
        List<TransferFund> transferFunds2 = new ArrayList<>();
        transferFunds2.add(createTransferFund(TRANSFER_ID, FUND_ID_2, TransferType.OUTCOME, outcomeTransferFund2));

        List<Fund> funds = new ArrayList<>();
        funds.add(createFund(FUND_ID_1, items1, transferFunds1));
        funds.add(createFund(FUND_ID_2, items2, transferFunds2));

        when(fundRepository.findAll()).thenReturn(funds);

        List<FundDto> resultedFunds = fundService.findAll();
        assertEquals(expectedResult1, resultedFunds.get(0).getAmount());
        assertEquals(expectedResult2, resultedFunds.get(1).getAmount());
    }

    @Test
    public void shouldSaveFund() {
        Fund fund = new Fund();
        fund.setId(FUND_ID_1);
        FundDto fundDto = new FundDto();
        fundDto.setId(FUND_ID_1);

        when(fundRepository.save(fund)).thenReturn(fund);
        when(fundTransformer.fromDto(fundDto)).thenReturn(fund);

        FundDto actualFundDto = fundService.save(fundDto);
        assertEquals(fundDto.getId(), actualFundDto.getId());
    }

    private Fund createFund(String id, List<Item> items, List<TransferFund> transferFunds) {
        return Fund.builder()
                .id(id)
                .items(items)
                .transferFunds(transferFunds)
                .build();
    }

    private Item createItem(String id, String type, long amount) {
        return Item.builder()
                .id(id)
                .type(type)
                .amount(BigInteger.valueOf(amount)).build();
    }
}
