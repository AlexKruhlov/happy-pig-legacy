package com.feature.item.model;

import com.feature.prodposition.model.ProductPosition;
import lombok.*;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

import static com.api.util.AppConstants.IS_EXISTED;

@Entity
@Table(name = "items")
@Where(clause = IS_EXISTED)
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

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_position_id", insertable = false, updatable = false)
    private ProductPosition productPosition;

    @Column(name = "product_position_id")
    private String productPositionId;

    @JoinColumn(name = "unit_id")
    private String unitId;

    @Column(length = 1000)
    private String comment;

    @Column
    private boolean deleted;
}
