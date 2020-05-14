package com.octopus.mybatisDemo.entity;

import java.io.Serializable;
import java.util.List;

public class GoodsType implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1744951954501067511L;

	private Long id;
	
	private Long parentId;
	
	private String typeName;
	
	
	/**
	 * 当前商品类型对应的所有的商品
	 */
	private List<Goods> goods;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "GoodsType [id=" + id + ", parentId=" + parentId + ", typeName=" + typeName + "]";
	}

	public List<Goods> getGoods() {
		return goods;
	}

	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}
	
	
	
	
}
