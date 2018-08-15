package com.feature.item.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    private String id;
    private String type;
    private String amount;
    private LocalDateTime date;
    private String fundId;
}
