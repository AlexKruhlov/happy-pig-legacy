package com.feature.unit.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "units")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Unit {

    @Id
    private String id;

    @Column
    private String name;
}
