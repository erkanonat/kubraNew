package com.audiotorium2.entity;

public class DataTableColumn {

	private String header;
	private String property;
	public DataTableColumn(String header, String property) {
		super();
		this.header = header;
		this.property = property;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	
	
	
}
