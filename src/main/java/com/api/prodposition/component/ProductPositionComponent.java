package com.api.prodposition.component;

import com.feature.prodposition.dto.ProductPositionDto;
import com.feature.prodposition.model.ProductPosition;
import com.feature.product.model.Product;

import java.util.List;

/**
 * Interface that provides API for UI to work on {@link ProductPosition} objects
 */
public interface ProductPositionComponent {

    /**
     * Find all {@link ProductPosition} objects
     *
     * @return list of {@link ProductPositionDto} objects or empty list
     */
    List<ProductPositionDto> findAll();

    /**
     * Find {@link ProductPositionDto} objects by {@link Product} id
     *
     * @param productId {@link Product} id
     * @return list of {@link ProductPositionDto} objects or empty list
     */
    List<ProductPositionDto> findByProductId(String productId);

    /**
     * Save or update {@link ProductPosition} object
     *
     * @param productPositionDto {@link ProductPositionDto} object for saving or updating
     * @return saved or updated {@link ProductPositionDto} object
     */
    ProductPositionDto save(ProductPositionDto productPositionDto);

    /**
     * Delete {@link ProductPosition} object by its id
     *
     * @param productPositionId id of {@link ProductPosition} object that should be deleted
     */
    void deleteById(String productPositionId);
}
