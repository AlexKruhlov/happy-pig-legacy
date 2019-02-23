package com.api.item.controller;

import com.feature.fund.dto.FundDtoWithItemsAndTransferFunds;
import com.feature.item.dto.ItemDto;

import java.util.Map;

/**
 * Provides the endpoints to work on items
 */
public interface ItemController {

    /**
     * Saves the item and finds current fund dto
     *
     * @param itemDto item dto
     * @return fund dto
     * @see FundDtoWithItemsAndTransferFunds
     */
    FundDtoWithItemsAndTransferFunds saveAndFindCurrentFund(ItemDto itemDto);

    /**
     * Delete (logically) the item with the particular id and finds current fund dto
     *
     * @param payload object with item id
     * @return fund dto with the same id
     * @see FundDtoWithItemsAndTransferFunds
     */
    FundDtoWithItemsAndTransferFunds deleteByIdAndFindFund(Map<String, String> payload);
}
