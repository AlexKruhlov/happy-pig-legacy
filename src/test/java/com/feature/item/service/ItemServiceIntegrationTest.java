package com.feature.item.service;

import com.App;
import com.api.item.service.ItemService;
import com.feature.fund.dto.FundDtoWithItemsAndTransferFunds;
import com.feature.item.dto.ItemDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import static com.feature.item.model.ItemTypeConst.INCOME;
import static com.feature.utils.TestUtilMethods.*;
import static java.time.LocalDateTime.now;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan(basePackageClasses = App.class)
public class ItemServiceIntegrationTest {
    private static final String GROCERY_FUND_ID = "GROCERY_FUND";
    private static final String FUND_GROCERY_ITEM_ID = "ITEM_0000001";

    @Autowired
    private ItemService itemService;

    @Test
    public void shouldSaveItemAndFindCurrentFund() {
        final int expectedItemListSize = 3;

        ItemDto itemDto = ItemDto.builder()
                .amount("5")
                .cost("10")
                .type(INCOME)
                .date(now())
                .fundId(GROCERY_FUND_ID)
                .productPositionId(BALL_PRODUCT_POSITION_ID)
                .unitId(PC_UNIT_ID)
                .comment("some comment").build();

        FundDtoWithItemsAndTransferFunds fundDtoWithNewItem = itemService.saveAndFindCurrentFund(itemDto);

        assertEquals(expectedItemListSize, fundDtoWithNewItem.getItems().size());
    }

    @Test
    public void shouldDeleteItemByIdAndFindCurrentFund() {
        final int expectedItemListSize = 1;
        FundDtoWithItemsAndTransferFunds fundDtoWithItemsAndTransferFunds = itemService.deleteByIdAndFindCurrentFund(FUND_GROCERY_ITEM_ID, GROCERY_FUND_ID);
        assertEquals(expectedItemListSize, fundDtoWithItemsAndTransferFunds.getItems().size());
    }
}
