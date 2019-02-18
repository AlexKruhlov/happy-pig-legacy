package com.feature.prodposition.model;

import com.feature.product.model.Product;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Contains specification for appropriate {@link Product}
 */
@Entity
@Table(name = "product_positions")
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
}
