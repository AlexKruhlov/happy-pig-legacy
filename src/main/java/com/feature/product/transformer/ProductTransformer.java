package com.feature.product.transformer;

import com.feature.product.dto.ProductDto;
import com.feature.product.model.Product;
import com.feature.unit.transformer.UnitTransformer;
import org.mapstruct.Mapper;

@Mapper(uses = UnitTransformer.class)
public interface ProductTransformer {

    ProductDto toDto(Product product);

    Product fromDto(ProductDto productDto);
}
