package com.feature.item.controller;

import com.api.fund.service.FundService;
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
    public enum Params {
        itemId,
        fundId
    }

    private ItemService itemService;
    private FundService fundService;

    @Autowired
    public ItemControllerImpl(ItemService itemService, FundService fundService) {
        this.itemService = itemService;
        this.fundService = fundService;
    }

    @Override
    @PostMapping(value = "/deleteAndFindFund")
    public FundDtoWithItems deleteByIdAndFindFund(@RequestBody Map<String, String> payload) {
        return itemService.deleteByIdAndFindCurrentFund(payload.get(Params.itemId.name()), payload.get(Params.fundId.name()));
    }

    @Override
    @PostMapping(value = "/saveAndFindFund")
    public FundDtoWithItems saveAndFindCurrentFund(@RequestBody ItemDto itemDto) {
        return itemService.saveAndFindCurrentFund(itemDto);
    }
}
