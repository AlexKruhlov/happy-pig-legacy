package com.feature.transfer.dto;

import com.feature.transfer.model.TransferType;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class TransferFundDto {
    private String fundId;
    private TransferType transferType;
    private TransferDto transfer;
}
