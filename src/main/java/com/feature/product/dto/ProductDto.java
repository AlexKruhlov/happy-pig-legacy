package com.feature.product.dto;

import com.feature.unit.dto.UnitDto;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ProductDto {
    private String id;
    private String name;
    private String specification;
    private UnitDto unit;
}
