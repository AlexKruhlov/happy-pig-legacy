package com.feature.bank.bankincomesource.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;

import javax.persistence.*;

import static com.api.util.AppConstants.IS_EXISTED;

@Entity
@Table(name="bank_income_sources")
@Where(clause = IS_EXISTED)
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankIncomeSource {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Column
    private String name;

    @Column
    private boolean deleted;
}
