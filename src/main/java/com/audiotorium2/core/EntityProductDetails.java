package com.audiotorium2.core;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "product_Details")
public class EntityProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int product_id;
    private int criteria_id;
    private int range_id;

    private double weight;


    public EntityProductDetails(int product_id, int criteria_id, int range_id, double weight) {
        super();
        this.product_id = product_id;
        this.criteria_id = criteria_id;
        this.range_id = range_id;
        this.weight = weight;
    }
}
