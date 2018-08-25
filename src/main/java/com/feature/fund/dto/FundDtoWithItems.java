package com.feature.fund.dto;

import com.feature.item.dto.ItemDto;
import lombok.*;

import java.util.List;

@Builder(builderMethodName = "buildFundWithItems")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FundDtoWithItems extends FundDto {
    private List<ItemDto> items;
}
