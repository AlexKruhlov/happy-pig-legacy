package com.feature.item.repository;

import com.feature.item.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDefaultRepository extends JpaRepository<Item, String> {
}
