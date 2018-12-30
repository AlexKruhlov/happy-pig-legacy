package com.feature.transfer.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class TransferDto {
    private String id;
    private String sum;
    private LocalDateTime date;
}
