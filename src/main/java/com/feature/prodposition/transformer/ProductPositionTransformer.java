package com.feature.prodposition.transformer;

import com.feature.prodposition.dto.ProductPositionDto;
import com.feature.prodposition.model.ProductPosition;
import com.feature.product.transformer.ProductTransformer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = ProductTransformer.class)
public interface ProductPositionTransformer {

    ProductPositionDto toDto(ProductPosition productPosition);

    ProductPosition fromDto(ProductPositionDto productPositionDto);

    List<ProductPositionDto> toDtos(List<ProductPosition> productPositions);
}
