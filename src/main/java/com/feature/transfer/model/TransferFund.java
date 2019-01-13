package com.feature.transfer.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Model that defines steps of transfer. Every transfer always has two steps. The first steps means reducing
 * transfer sum from one fund. The second one means adding reduce sum to another fund. So, transfer step is
 * TransferFund object
 */
@Entity
@Table(name = "transfer_funds")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransferFund implements Serializable {
    public static final String FUND_ID_FIELD_NAME = "id.fundId";

    @EmbeddedId
    private TransferFundId id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "transfer_type")
    private TransferType transferType;
}
