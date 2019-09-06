package com.audiotorium2.entity;

import java.util.ArrayList;
import java.util.List;

public class Criteria {

	private String name="";
	private int value=0;
	private List<Range> ranges= new ArrayList<Range>();

	public Criteria(String name, int value, List<Range> ranges) {
		super();
		this.name = name;
		this.value = value;
		this.ranges=ranges;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public List<Range> getRanges() {
		return ranges;
	}
	public void setRanges(List<Range> ranges) {
		this.ranges = ranges;
	}
	
}
