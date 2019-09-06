package com.audiotorium2.core;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "range")
public class EntityRange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int criteria_id;

    private String range_name;
    private double range_value;

    public EntityRange() {

    }

    public EntityRange(int criteria_id, String range_name, double range_value) {
        super();
        this.criteria_id = criteria_id;
        this.range_name = range_name;
        this.range_value = range_value;
    }
}
