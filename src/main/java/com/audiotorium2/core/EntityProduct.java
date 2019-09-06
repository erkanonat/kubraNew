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
    private int issue_id;
    private double grade;

    public EntityProduct() {

    }

    public EntityProduct(String name, int issue_id, double grade) {
        super();
        this.name = name;
        this.issue_id=issue_id;
        this.grade = grade;
    }
}
