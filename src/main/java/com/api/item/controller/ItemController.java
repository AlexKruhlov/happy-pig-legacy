package com.api.item.controller;

import com.feature.fund.dto.FundDtoWithItems;
import com.feature.item.dto.ItemDto;

import java.util.Map;

/**
 * Provides the endpoints to work on items
 */
public interface ItemController {

    /**
     * Deletes the item with the particular id and finds current fund dto
     *
     * @param payload object with item id
     * @return fund dto with the same id
     * @see FundDtoWithItems
     */
    FundDtoWithItems deleteBy(Map<String, String> payload);

    /**
     * Saves the item and finds current fund dto
     *
     * @param itemDto item dto
     * @return fund dto
     * @see FundDtoWithItems
     */
    FundDtoWithItems saveAndFindCurrentFund(ItemDto itemDto);
}
