package com.feature.item.service;

import com.App;
import com.api.item.service.ItemService;
import com.feature.fund.dto.FundDtoWithItemsAndTransferFunds;
import com.feature.item.dto.ItemDto;
import com.feature.product.dto.ProductDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import static com.feature.item.model.ItemTypeConst.INCOME;
import static java.time.LocalDateTime.now;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan(basePackageClasses = App.class)
public class ItemServiceIntegrationTest {
    public static final String GROCERY_FUND_ID = "GROCERY_FUND";
    public static final ProductDto PRODUCT_DTO = new ProductDto("POTATO", "Potato");
    public static final String FUND_GROCERY_ITEM_ID = "ITEM_0000001";

    @Autowired
    private ItemService itemService;

    @Test
    public void shouldDeleteItemByIdAndFindCurrentFund() {
        final int expectedItemListSize = 1;
        FundDtoWithItemsAndTransferFunds fundDtoWithItemsAndTransferFunds = itemService.deleteByIdAndFindCurrentFund(FUND_GROCERY_ITEM_ID, GROCERY_FUND_ID);
        assertEquals(expectedItemListSize, fundDtoWithItemsAndTransferFunds.getItems().size());
    }

    @Test
    public void shouldSaveItemAndFindCurrentFund() {
        final int expectedItemListSize = 3;

        ItemDto itemDto = new ItemDto(null, INCOME, "10", now(), GROCERY_FUND_ID, PRODUCT_DTO);
        FundDtoWithItemsAndTransferFunds fundDtoWithNewItem = itemService.saveAndFindCurrentFund(itemDto);

        assertEquals(expectedItemListSize, fundDtoWithNewItem.getItems().size());
    }
}
