package com.feature.item.service;

import com.App;
import com.api.fund.service.FundService;
import com.api.item.service.ItemService;
import com.api.product.repository.ProductRepository;
import com.feature.item.dto.ItemDto;
import com.feature.item.model.Item;
import com.feature.item.model.ItemTypeConst;
import com.feature.item.repository.ItemDefaultRepository;
import com.feature.product.dto.ProductDto;
import com.feature.product.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan(basePackageClasses = App.class)
public class ItemServiceIntegrationTest {
    public static final String FUND_ID = "GROCERY_FUND";
    public static final Product PRODUCT  = new Product("POTATO", "Potato");

    @Autowired
    private FundService fundService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private ProductRepository productRepository;
    @Autowired

    private ItemDefaultRepository itemDefaultRepository;

    @Test
    @Transactional(propagation = Propagation.NEVER)
    public void shouldDeleteItemById() {
        final int itemListSizeBeforeDeleting = 3;
        final int expectedItemListSize = 2;
        Item item = Item.builder()
                .amount(BigInteger.TEN)
                .fundId(FUND_ID)
                .type(ItemTypeConst.INCOME)
                .product(PRODUCT)
                .date(LocalDateTime.now()).build();
        String newItemId = itemDefaultRepository.save(item).getId();
        assertEquals(itemListSizeBeforeDeleting, fundService.findById(FUND_ID).getItems().size());

        itemService.deleteById(newItemId);
        assertEquals(expectedItemListSize, fundService.findById(FUND_ID).getItems().size());
    }
}
