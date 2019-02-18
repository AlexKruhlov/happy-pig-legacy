package com.api.item.repository;

import com.feature.item.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Provides the repository methods to work on items
 */
public interface ItemRepository extends JpaRepository<Item, String>, ItemRepositoryCustom {
}
