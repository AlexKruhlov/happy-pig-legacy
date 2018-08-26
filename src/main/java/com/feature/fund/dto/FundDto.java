package com.feature.fund.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FundDto {
    private String id;
    private String name;
    private String amount;
    private String income;
    private String expense;
}
