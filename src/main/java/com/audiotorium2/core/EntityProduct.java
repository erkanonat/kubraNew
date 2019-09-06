package com.audiotorium2.core;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product")
public class EntityProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private double grade;

    public EntityProduct() {

    }

    public EntityProduct(String name, double grade) {
        super();
        this.name = name;
        this.grade = grade;
    }
}
