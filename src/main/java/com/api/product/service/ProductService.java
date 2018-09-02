package com.api.product.service;

import com.feature.product.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> findAll();

    ProductDto save(ProductDto productDto);

    void deleteById(String id);
}
