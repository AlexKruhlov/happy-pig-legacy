package com.api.item.controller;

import com.feature.fund.dto.FundDtoWithItems;
import com.feature.item.dto.ItemDto;

import java.util.Map;

public interface ItemController {

    FundDtoWithItems deleteBy(Map<String, String> payload);

    FundDtoWithItems saveAndFindCurrentFund(ItemDto itemDto);
}
