package com.octopus.entity;

public class ProductType {
	private Long id;
	private String  name;
	private String details;
	private int  parent_id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	@Override
	public String toString() {
		return "ProductType [id=" + id + ", name=" + name + ", details=" + details + ", parent_id=" + parent_id + "]";
	}
	public ProductType(Long id, String name, String details, int parent_id) {
		super();
		this.id = id;
		this.name = name;
		this.details = details;
		this.parent_id = parent_id;
	}
	public ProductType() {
		super();
	}
	
	
}
