package com.api.item.repository;

import com.feature.item.model.Item;

/**
 * Provides additional opportunity to work with {@link Item}
 */
public interface ItemRepositoryCustom {

    /**
     * Use cash clearing
     */
    void clear();
}
