package com.feature.fund.dto;

import com.feature.item.dto.ItemDto;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FundDto {
    private String id;
    private String name;
    private List<ItemDto> itemDtos;
    private String amount;
}
