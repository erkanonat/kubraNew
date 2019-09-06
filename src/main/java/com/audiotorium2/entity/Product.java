package com.audiotorium2.entity;

import java.util.HashMap;
import java.util.Map;

public class Product {

	private String name="";
	private double price=0;
	private Map<String, String> criteriaRangeMap=new HashMap<String, String>();
	private double grade=0;
	
	
	public Product(String name, double price, Map<String, String> criteriaRangeMap, double grade) {
		super();
		this.name = name;
		this.price = price;
		this.criteriaRangeMap = criteriaRangeMap;
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Map<String, String> getCriteriaRangeMap() {
		return criteriaRangeMap;
	}
	public void setCriteriaRangeMap(Map<String, String> criteriaRangeMap) {
		this.criteriaRangeMap = criteriaRangeMap;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	
	
	
}
