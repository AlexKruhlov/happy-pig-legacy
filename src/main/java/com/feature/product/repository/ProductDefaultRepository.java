package com.feature.product.repository;

import com.feature.product.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDefaultRepository extends CrudRepository<Product, String> {
}
