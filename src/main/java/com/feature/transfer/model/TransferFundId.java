package com.feature.transfer.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Embeddable class is needed for define TransferFund's ({@link TransferFund}) composite primary key
 */
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class TransferFundId implements Serializable {

    @Column(name = "fund_id")
    private String fundId;

    @ManyToOne
    @JoinColumn(name = "transfer_id")
    private Transfer transfer;
}
