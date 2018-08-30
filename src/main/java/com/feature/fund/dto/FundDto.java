package com.feature.fund.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FundDto {
    private String id;
    private String name;
    private LocalDateTime startDate;
    private String amount;
    private String income;
    private String expense;
}
