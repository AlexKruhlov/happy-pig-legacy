package com.feature.bank.banktransaction.dto;

import com.feature.bank.banktransaction.model.BankTransactionType;
import com.feature.fund.dto.FundDto;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class BankTransactionDto {
    private String id;
    private BankTransactionType bankTransactionType;
    private String amount;
    private FundDto fund;
    private LocalDateTime date;
}
