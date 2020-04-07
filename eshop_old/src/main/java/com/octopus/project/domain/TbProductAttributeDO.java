package com.octopus.project.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 商品属性表
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public class TbProductAttributeDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Long id;
	/**
	 * 对应商品
	 */
	private String productId;
	/**
	 * 属性名称
	 */
	private String attributeName;
	/**
	 * 属性值
	 */
	private String attributeValue;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：对应商品
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}
	/**
	 * 获取：对应商品
	 */
	public String getProductId() {
		return productId;
	}
	/**
	 * 设置：属性名称
	 */
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	/**
	 * 获取：属性名称
	 */
	public String getAttributeName() {
		return attributeName;
	}
	/**
	 * 设置：属性值
	 */
	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}
	/**
	 * 获取：属性值
	 */
	public String getAttributeValue() {
		return attributeValue;
	}
}
