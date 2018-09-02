package com.feature.product.transformer;

import com.feature.product.dto.ProductDto;
import com.feature.product.model.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductTransformer {

    ProductDto toDto(Product product);

    Product fromDto(ProductDto productDto);
}
