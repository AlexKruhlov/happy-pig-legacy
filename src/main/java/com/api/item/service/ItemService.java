package com.api.item.service;

import com.feature.fund.dto.FundDtoWithItemsAndTransferFunds;
import com.feature.fund.model.Fund;
import com.feature.item.dto.ItemDto;
import com.feature.item.model.Item;

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
     * Delete (logically) {@link Item} with particular id, find current {@link Fund} transform into dto
     * and return it
     *
     * @param itemId {@link Item} id
     * @param fundId {@link Fund} id
     * @return {@link FundDtoWithItemsAndTransferFunds} with particular fund id
     */
    FundDtoWithItemsAndTransferFunds deleteByIdAndFindCurrentFund(String itemId, String fundId);
}
