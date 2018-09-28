package com.api.item.service;

import com.feature.fund.dto.FundDtoWithItems;
import com.feature.item.dto.ItemDto;

public interface ItemService {

    ItemDto save(ItemDto itemDto);

    FundDtoWithItems deleteByIdAndFindCurrentFund(String itemId, String fundId);

    FundDtoWithItems saveAndFindCurrentFund(ItemDto itemDto);
}
