package com.api.product.repository;

import com.feature.product.model.Product;

import java.util.List;

/**
 * Provides the repository methods to work on product object model
 */
public interface ProductRepository {

    List<Product> findAll();

    Product save(Product product);

    void deleteById(String id);
}
