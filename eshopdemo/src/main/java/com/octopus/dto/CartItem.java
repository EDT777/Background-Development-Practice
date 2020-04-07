package com.octopus.dto;

import java.math.BigDecimal;

import com.octopus.entity.Product;

public class CartItem {
	private Product product;
	
	private int count;
	
	private BigDecimal price;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
}
