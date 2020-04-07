package com.octopus.entity;

import java.math.BigDecimal;

public class Product {
	private Long id;
	private String name;
	private BigDecimal price;
	private int store;
	private String image;
	private String details;
	private long typeId;
	private double score1;
	private double score2;
	private double score3;

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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getStore() {
		return store;
	}

	public void setStore(int store) {
		this.store = store;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	

	public long getTypeId() {
		return typeId;
	}

	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}

	public double getScore1() {
		return score1;
	}

	public void setScore1(double score1) {
		this.score1 = score1;
	}

	public double getScore2() {
		return score2;
	}

	public void setScore2(double score2) {
		this.score2 = score2;
	}

	public double getScore3() {
		return score3;
	}

	public void setScore3(double score3) {
		this.score3 = score3;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", store=" + store + ", image=" + image
				+ ", details=" + details + ", typeId=" + typeId + ", score1=" + score1
				+ ", score2=" + score2 + ", score3=" + score3 + "]";
	}

	public Product(Long id, String name, BigDecimal price, int store, String image, String details, double price1, long typeId,
			double score1, double score2, double score3) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.store = store;
		this.image = image;
		this.details = details;
		this.typeId = typeId;
		this.score1 = score1;
		this.score2 = score2;
		this.score3 = score3;
	}

	public Product() {
		super();
	}

}
