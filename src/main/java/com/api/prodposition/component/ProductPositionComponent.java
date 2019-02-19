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
     * Find {@link ProductPositionDto} objects by {@link Product} id
     *
     * @param productId {@link Product} id
     * @return list of {@link ProductPositionDto} objects or empty list
     */
    List<ProductPositionDto> findByProductId(String productId);
}
