package com.feature.item.service;

import com.api.fund.service.FundService;
import com.api.item.repository.ItemRepository;
import com.api.item.service.ItemService;
import com.feature.fund.dto.FundDtoWithItemsAndTransferFunds;
import com.feature.item.dto.ItemDto;
import com.feature.item.model.Item;
import com.feature.item.transformer.ItemTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final FundService fundService;
    private final ItemTransformer itemTransformer;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, FundService fundService, ItemTransformer itemTransformer) {
        this.itemRepository = itemRepository;
        this.fundService = fundService;
        this.itemTransformer = itemTransformer;
    }

    @Override
    @Transactional
    public ItemDto save(ItemDto itemDto) {
        Item item = itemTransformer.fromDto(itemDto);
        return itemTransformer.toDto(itemRepository.save(item));
    }

    @Override
    @Transactional
    public FundDtoWithItemsAndTransferFunds deleteByIdAndFindCurrentFund(String itemId, String fundId) {
        itemRepository.deleteById(itemId);
        itemRepository.flush();
        return fundService.findById(fundId);
    }

    @Override
    @Transactional
    public FundDtoWithItemsAndTransferFunds saveAndFindCurrentFund(ItemDto itemDto) {
        Item item = itemTransformer.fromDto(itemDto);
        itemRepository.save(item);
        itemRepository.flush();
        return fundService.findById(item.getFundId());
    }
}
