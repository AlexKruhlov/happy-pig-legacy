package com.feature.transfer.model;

import lombok.*;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Model of transfers between funds
 */
@Entity
@Table(name = "transfers")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transfer implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id.transfer", orphanRemoval = true)
    @Singular
    private List<TransferFund> transferFunds;

    @Column
    private BigInteger sum;

    @Column(insertable = false)
    @Generated(value = GenerationTime.INSERT)
    private LocalDateTime date;

    public TransferFund getTransferFundByType(TransferType transferType) {
        return transferFunds.stream()
                .filter(transferFund -> transferFund.getTransferType().equals(transferType))
                .findFirst()
                .orElse(null);
    }
}
