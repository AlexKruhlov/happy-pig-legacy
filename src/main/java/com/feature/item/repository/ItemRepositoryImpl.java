package com.feature.item.repository;

import com.api.item.repository.ItemRepositoryCustom;
import com.feature.item.model.Item;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ItemRepositoryImpl implements ItemRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void refresh(Item item) {
        entityManager.refresh(item);
    }
}
