package com.octopus.entity;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author jason
 * @email 1626883728@qq.com
 * @date 2019-12-05 17:07:47
 */
public class GoodsTypeDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Long id;
	/**
	 * 类型名称
	 */
	private String typeName;
	/**
	 * 父ID，类型的层级关系
	 */
	private Long parentId;

	/**
	 * 设置�?
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取�?
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：类型名�?
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	/**
	 * 获取：类型名�?
	 */
	public String getTypeName() {
		return typeName;
	}
	/**
	 * 设置：父ID，类型的层级关系
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：父ID，类型的层级关系
	 */
	public Long getParentId() {
		return parentId;
	}
}
