package com.feature.prodposition.transformer;

import com.feature.prodposition.dto.ProductPositionDto;
import com.feature.prodposition.model.ProductPosition;
import com.feature.product.transformer.ProductTransformer;
import org.mapstruct.Mapper;

@Mapper(uses = ProductTransformer.class)
public interface ProductPositionTransformer {

    ProductPositionDto toDto(ProductPosition productPosition);

    ProductPosition fromDto(ProductPositionDto productPositionDto);
}
