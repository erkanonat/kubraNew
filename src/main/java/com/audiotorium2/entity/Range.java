package com.audiotorium2.entity;

public class Range {

	private String criteriaName;
	private String rangeName;
	private double weight;
	
	
	
	
	
	public Range(String criteriaName, String rangeName, double weight) {
		super();
		this.criteriaName = criteriaName;
		this.rangeName = rangeName;
		this.weight = weight;
	}
	public String getCriteriaName() {
		return criteriaName;
	}
	public void setCriteriaName(String criteriaName) {
		this.criteriaName = criteriaName;
	}
	public String getRangeName() {
		return rangeName;
	}
	public void setRangeName(String rangeName) {
		this.rangeName = rangeName;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
	
}
