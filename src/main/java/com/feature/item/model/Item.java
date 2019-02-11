package com.feature.item.model;

import com.feature.product.model.Product;
import lombok.*;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "items")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Column
    private String type;

    @Column
    private BigInteger cost;

    @Column
    private BigInteger amount;

    @Column(insertable = false)
    @org.hibernate.annotations.Generated(value = GenerationTime.INSERT)
    private LocalDateTime date;

    @Column(name = "fund_id")
    private String fundId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
