package com.feature.item.dto;

import com.feature.prodposition.dto.ProductPositionDto;
import com.feature.unit.dto.UnitDto;
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
    private UnitDto unit;
    private String comment;
}
