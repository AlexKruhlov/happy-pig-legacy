package com.feature.item.controller;

import com.api.item.controller.ItemController;
import com.api.item.service.ItemService;
import com.feature.fund.dto.FundDtoWithItems;
import com.feature.item.dto.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/item")
public class ItemControllerImpl implements ItemController {
    private static final String ITEM_ID = "itemId";
    private static final String FUND_ID = "fundId";

    private final ItemService itemService;

    @Autowired
    public ItemControllerImpl(ItemService itemService) {
        this.itemService = itemService;
    }

    @Override
    @PostMapping(value = "/deleteAndFindFund")
    public FundDtoWithItems deleteByIdAndFindFund(@RequestBody Map<String, String> payload) {
        return itemService.deleteByIdAndFindCurrentFund(payload.get(ITEM_ID), payload.get(FUND_ID));
    }

    @Override
    @PostMapping(value = "/saveAndFindFund")
    public FundDtoWithItems saveAndFindCurrentFund(@RequestBody ItemDto itemDto) {
        return itemService.saveAndFindCurrentFund(itemDto);
    }
}
