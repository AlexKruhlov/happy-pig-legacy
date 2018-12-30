package com.api.item.service;

import com.feature.fund.dto.FundDtoWithItemsAndTransferFunds;
import com.feature.item.dto.ItemDto;

/**
 * Provides possibility of working on item business logic
 */
public interface ItemService {

    /**
     * Saves items model object, transforms it into dto and returns
     *
     * @param itemDto item dto
     * @return itemDto item dto
     * @see ItemDto
     */
    ItemDto save(ItemDto itemDto);

    /**
     * Saves item model object, finds current fund and transforms it into dto
     *
     * @param itemDto item dto
     * @return fund dto with items
     * @see FundDtoWithItemsAndTransferFunds
     */
    FundDtoWithItemsAndTransferFunds saveAndFindCurrentFund(ItemDto itemDto);

    /**
     * Deletes item with particular id, finds current fund and transforms it into dto
     *
     * @param itemId item id
     * @param fundId fund id
     * @return fund dto with items
     * @see FundDtoWithItemsAndTransferFunds
     */
    FundDtoWithItemsAndTransferFunds deleteByIdAndFindCurrentFund(String itemId, String fundId);
}
