package com.feature.product.repository;

import com.api.product.repository.ProductRepository;
import com.feature.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private ProductDefaultRepository productDefaultRepository;

    @Autowired
    public ProductRepositoryImpl(ProductDefaultRepository productDefaultRepository) {
        this.productDefaultRepository = productDefaultRepository;
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) productDefaultRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productDefaultRepository.save(product);
    }

    @Override
    public void deleteById(String id) {
        productDefaultRepository.deleteById(id);
    }
}
