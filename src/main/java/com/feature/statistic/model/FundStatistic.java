package com.feature.statistic.model;

import com.feature.fund.dto.FundDto;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FundStatistic {
    private List<FundDto> funds;
    private String total;
}
