package com.audiotorium2.core;

import lombok.Data;

import java.util.List;

@Data
public class ProductView {

    public int product_id;
    public String name;
    public double grade;
    public double price;
    public int selected;

    public List<CriteriaRangeView> criterias;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<CriteriaRangeView> getCriterias() {
        return criterias;
    }

    public void setCriterias(List<CriteriaRangeView> criterias) {
        this.criterias = criterias;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }
}
