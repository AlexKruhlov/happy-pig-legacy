package com.feature.item.service;

import com.api.fund.service.FundService;
import com.api.item.repository.ItemRepository;
import com.api.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ItemServiceImpl implements ItemService {
    private ItemRepository itemRepository;
    private FundService fundService;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, FundService fundService) {
        this.itemRepository = itemRepository;
        this.fundService = fundService;
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        itemRepository.deleteById(id);
    }
}
