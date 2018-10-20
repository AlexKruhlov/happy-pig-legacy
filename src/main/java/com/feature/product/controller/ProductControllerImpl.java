package com.feature.product.controller;

import com.api.product.controller.ProductController;
import com.api.product.service.ProductService;
import com.feature.product.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductControllerImpl implements ProductController {
    private final ProductService productService;

    @Autowired
    public ProductControllerImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    @GetMapping("/all")
    public List<ProductDto> findAll() {
        return productService.findAll();
    }

    @Override
    @PostMapping("/create")
    public ProductDto create(@RequestBody ProductDto productDto) {
        return productService.save(productDto);
    }

    @Override
    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable String id) {
        productService.deleteById(id);
    }
}
