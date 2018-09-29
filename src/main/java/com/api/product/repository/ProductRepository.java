package com.api.product.repository;

import com.feature.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Provides the repository methods to work on product object model
 */
public interface ProductRepository extends JpaRepository<Product, String> {
}
