package com.api.prodposition.repository;

import com.feature.prodposition.model.ProductPosition;
import com.feature.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Provides the data access layer API to work on {@link ProductPosition} objects
 **/
public interface ProductPositionRepository extends JpaRepository<ProductPosition, String> {

    /**
     * Find {@link ProductPosition} objects by product id
     *
     * @param productId {@link Product} id
     * @return list of {@link ProductPosition} objects or empty list
     */
    List<ProductPosition> findByProductId(String productId);
}
