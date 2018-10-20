package com.feature.product.service;

import com.api.product.repository.ProductRepository;
import com.api.product.service.ProductService;
import com.feature.product.dto.ProductDto;
import com.feature.product.model.Product;
import com.feature.product.transformer.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductTransformer productTransformer;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductTransformer productTransformer) {
        this.productRepository = productRepository;
        this.productTransformer = productTransformer;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDto> findAll() {
        return productRepository.findAll().stream()
                .map(productTransformer::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ProductDto save(ProductDto productDto) {
        Product savedProduct = productRepository.save(productTransformer.fromDto(productDto));
        return productTransformer.toDto(savedProduct);
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        productRepository.deleteById(id);
    }
}
