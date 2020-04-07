package com.octopus.entity;

import java.io.Serializable;

public class GoodsType implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1744951954501067511L;

	private Long id;
	
	private Long parentId;
	
	private String typeName;

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
	
	
}
