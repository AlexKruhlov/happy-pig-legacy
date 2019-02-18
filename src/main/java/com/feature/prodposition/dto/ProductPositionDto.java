package com.feature.prodposition.dto;

import com.feature.product.dto.ProductDto;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ProductPositionDto {
    private String id;
    private String specification;
    private ProductDto product;
}
