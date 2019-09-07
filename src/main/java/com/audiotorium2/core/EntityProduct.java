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
    private double price;
    private int selected;

    public EntityProduct() {

    }

    public EntityProduct(String name, int issue_id, double grade, double price, int selected) {
        super();
        this.name = name;
        this.issue_id=issue_id;
        this.grade = grade;
        this.price=price;
        this.selected=selected;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIssue_id() {
        return issue_id;
    }

    public void setIssue_id(int issue_id) {
        this.issue_id = issue_id;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }
}
