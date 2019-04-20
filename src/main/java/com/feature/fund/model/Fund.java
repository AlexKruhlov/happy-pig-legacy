package com.feature.fund.model;

import com.feature.bank.banktransaction.model.BankTransaction;
import com.feature.item.model.Item;
import com.feature.transfer.model.TransferFund;
import lombok.*;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import static com.api.util.AppConstants.IS_EXISTED;
import static com.feature.fund.model.Fund.FIND_ALL;
import static com.feature.transfer.model.TransferFund.FUND_ID_FIELD_NAME;
import static javax.persistence.CascadeType.ALL;
import static org.hibernate.annotations.GenerationTime.INSERT;

/**
 * Model of fund
 */
@Entity
@Table(name = "funds")
@NamedQueries({
        @NamedQuery(name = FIND_ALL, query = "select f from Fund f")})
@Where(clause = IS_EXISTED)
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Fund implements Serializable {
    public static final String FIND_ALL = "findAll";

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Column
    private String name;

    @Column(name = "start_date", insertable = false)
    @Generated(value = INSERT)
    private LocalDateTime startDate;

    @OneToMany(cascade = ALL, mappedBy = "fundId", orphanRemoval = true)
    @Singular
    private List<Item> items;

    @OneToMany(cascade = ALL, mappedBy = FUND_ID_FIELD_NAME, orphanRemoval = true)
    @Singular
    private List<TransferFund> transferFunds;

    @OneToMany(cascade = ALL, mappedBy = "fund", orphanRemoval = true)
    @Singular
    private List<BankTransaction> bankTransactions;

    @Transient
    private BigInteger amount;

    @Transient
    private BigInteger income;

    @Transient
    private BigInteger expense;

    @Column
    private boolean deleted;
}
