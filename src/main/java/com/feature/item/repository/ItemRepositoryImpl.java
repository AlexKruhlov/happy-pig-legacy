package com.feature.item.repository;

import com.api.item.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

    private ItemDefaultRepository itemRepository;

    @Autowired
    public ItemRepositoryImpl(ItemDefaultRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void deleteById(String id) {
        itemRepository.deleteById(id);
    }
}
