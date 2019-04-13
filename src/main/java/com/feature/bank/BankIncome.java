package com.feature.bank;

import com.feature.bank.bankincomesource.model.BankIncomeSource;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;

import javax.persistence.*;

import java.math.BigInteger;

import static com.api.util.AppConstants.IS_EXISTED;

@Entity
@Table(name = "bank_incomes")
@Where(clause = IS_EXISTED)
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankIncome {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Column
    private BigInteger amount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_income_source_id")
    private BankIncomeSource bankIncomeSource;

    @Column
    private boolean deleted;
}
