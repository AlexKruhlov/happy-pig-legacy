package com.feature.item.repository;

import com.feature.item.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemDefaultRepository extends CrudRepository<Item, String> {
}
