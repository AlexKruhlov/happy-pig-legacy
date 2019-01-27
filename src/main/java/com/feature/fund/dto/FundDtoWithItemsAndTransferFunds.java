package com.feature.fund.dto;

import com.feature.item.dto.ItemDto;
import com.feature.transfer.dto.TransferFundDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class FundDtoWithItemsAndTransferFunds extends FundDto {
    private List<ItemDto> items;
    private List<TransferFundDto> transferFunds;

    @Builder(builderMethodName = "fundDtoWithAddition")
    public FundDtoWithItemsAndTransferFunds(String id, String name, LocalDateTime startDate, String amount,
                                            String income, String expense, List<ItemDto> items,
                                            List<TransferFundDto> transferFunds) {
        super(id, name, startDate, amount, income, expense);
        this.items = items;
        this.transferFunds = transferFunds;
    }
}
