package com.api.product.service;

import com.feature.product.dto.ProductDto;

import java.util.List;

/**
 * Provides possibility of working on product business logic
 */
public interface ProductService {

    /**
     * Finds all product model objects and transforms them into dtos
     *
     * @return list of product dtos
     * @see ProductDto
     */
    List<ProductDto> findAll();

    /**
     * Saves product model object that has been transformed from product dto previously and return saved product
     *
     * @param productDto product dto
     * @return product dto
     * @see ProductDto
     */
    ProductDto save(ProductDto productDto);

    /**
     * Deletes product model with particular id
     *
     * @param id product id
     */
    void deleteById(String id);
}
