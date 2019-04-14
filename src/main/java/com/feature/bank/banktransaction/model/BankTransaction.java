package com.feature.bank.banktransaction.model;

import com.feature.fund.model.Fund;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;

import javax.persistence.*;

import java.math.BigInteger;
import java.time.LocalDateTime;

import static com.api.util.AppConstants.IS_EXISTED;
import static javax.persistence.EnumType.STRING;

@Entity
@Table(name="bank_transactions")
@Where(clause = IS_EXISTED)
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankTransaction {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Enumerated(value = STRING)
    @Column(name = "bank_transaction_type")
    private BankTransactionType bankTransactionType;

    @Column
    private BigInteger amount;

    @ManyToOne
    @JoinColumn(name = "fund_id")
    private Fund fund;

    @Column
    private LocalDateTime date;

    @Column
    private boolean deleted;
}
