package com.api.product.controller;

import com.feature.product.dto.ProductDto;

import java.util.List;

/**
 * Provides the endpoints to work on products
 */
public interface ProductController {

    /**
     * Finds all product dtos
     *
     * @return fund dtos
     * @see ProductDto
     */
    List<ProductDto> findAll();

    /**
     * Saves product and returns it
     *
     * @param productDto product dto
     * @return fund dt
     * @see ProductDto
     */
    ProductDto create(ProductDto productDto);

    /**
     * Deletes product with particular id
     */
    void deleteById(String id);
}
