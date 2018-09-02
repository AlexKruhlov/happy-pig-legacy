package com.api.product.repository;

import com.feature.product.model.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();

    Product save(Product product);

    void deleteById(String id);
}
