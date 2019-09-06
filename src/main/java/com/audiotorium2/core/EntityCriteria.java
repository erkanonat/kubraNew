package com.audiotorium2.core;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Criteria")
public class EntityCriteria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int issue_id;
    private String name;
    private double weight;

    public EntityCriteria(){

    }


    public EntityCriteria(int issue_id, String name, double weight) {
        super();
        this.issue_id = issue_id;
        this.name = name;
        this.weight = weight;
    }



}
