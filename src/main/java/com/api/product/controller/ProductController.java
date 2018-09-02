package com.api.product.controller;

import com.feature.product.dto.ProductDto;

import java.util.List;

public interface ProductController {

    List<ProductDto> findAll();

    ProductDto create(ProductDto productDto);

    void deleteById(String id);
}
