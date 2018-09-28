package com.feature.item.dto;

import com.feature.product.dto.ProductDto;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ItemDto {
    private String id;
    private String type;
    private String amount;
    private LocalDateTime date;
    private String fundId;
    private ProductDto product;
}
