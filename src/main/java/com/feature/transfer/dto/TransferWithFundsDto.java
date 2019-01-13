package com.feature.transfer.dto;

import lombok.*;

import java.time.LocalDateTime;

/**
 * Model of transfer dto
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class TransferWithFundsDto {
    private String id;
    private String fromFundId;
    private String toFundId;
    private String sum;
    private LocalDateTime date;
}
