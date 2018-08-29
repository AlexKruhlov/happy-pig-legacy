package com.api.item.controller;

import com.feature.fund.dto.FundDtoWithItems;

import java.util.Map;

public interface ItemController {

    FundDtoWithItems deleteBy(Map<String, String> payload);
}
