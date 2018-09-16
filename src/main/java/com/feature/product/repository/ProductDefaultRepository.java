package com.feature.product.repository;

import com.feature.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDefaultRepository extends JpaRepository<Product, String> {
}
