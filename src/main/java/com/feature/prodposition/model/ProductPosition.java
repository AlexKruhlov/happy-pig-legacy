package com.feature.prodposition.model;

import com.feature.product.model.Product;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;

import static com.api.util.AppConstants.IS_EXISTED;

/**
 * Contains specification for appropriate {@link Product}
 */
@Entity
@Table(name = "product_positions")
@Where(clause = IS_EXISTED)
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductPosition implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Column(length = 100)
    private String specification;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column
    private boolean deleted;
}
