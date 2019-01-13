package com.feature.fund.dto;

import com.feature.item.dto.ItemDto;
import com.feature.transfer.dto.TransferFundDto;
import lombok.*;

import java.util.List;

@Builder(builderMethodName = "buildFundWithItemsAndTransferFunds")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class FundDtoWithItemsAndTransferFunds extends FundDto {
    private List<ItemDto> items;
    private List<TransferFundDto> transferFunds;
}
