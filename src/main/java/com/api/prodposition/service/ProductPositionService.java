package com.api.prodposition.service;

import com.feature.prodposition.dto.ProductPositionDto;
import com.feature.prodposition.model.ProductPosition;
import com.feature.product.model.Product;

import java.util.List;

/**
 * Interface that provides service layer API to work on {@link ProductPosition} objects
 */
public interface ProductPositionService {

    /**
     * Find {@link ProductPosition} objects by {@link Product} id, transform them into
     * {@link ProductPositionDto} objects and return a list
     *
     * @param productId {@link Product} id
     * @return list of {@link ProductPositionDto} objects or empty list
     */
    List<ProductPositionDto> findByProductId(String productId);

}
