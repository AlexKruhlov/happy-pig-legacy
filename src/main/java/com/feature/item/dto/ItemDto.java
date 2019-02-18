package com.feature.item.dto;

import com.feature.prodposition.dto.ProductPositionDto;
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
    private String cost;
    private String amount;
    private LocalDateTime date;
    private String fundId;
    private ProductPositionDto productPosition;
    private String productPositionId;
    private String unitId;
    private String comment;
}
