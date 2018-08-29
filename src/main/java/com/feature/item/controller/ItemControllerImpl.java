package com.feature.item.controller;

import com.api.fund.service.FundService;
import com.api.item.controller.ItemController;
import com.api.item.service.ItemService;
import com.feature.fund.dto.FundDtoWithItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/item")
public class ItemControllerImpl implements ItemController {
    private ItemService itemService;
    private FundService fundService;

    @Autowired
    public ItemControllerImpl(ItemService itemService, FundService fundService) {
        this.itemService = itemService;
        this.fundService = fundService;
    }

    @Override
    @PostMapping(value = "/delete")
    public FundDtoWithItems deleteBy(@RequestBody Map<String, String> payload) {
        itemService.deleteById(payload.get("itemId"));
        return fundService.findById(payload.get("fundId"));
    }
}
