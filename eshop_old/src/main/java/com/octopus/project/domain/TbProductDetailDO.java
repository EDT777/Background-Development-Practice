package com.octopus.project.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 商品详情页
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public class TbProductDetailDO implements Serializable {
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
	 * 详情内容，html代码
	 */
	private String detailHtml;

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
	 * 设置：详情内容，html代码
	 */
	public void setDetailHtml(String detailHtml) {
		this.detailHtml = detailHtml;
	}
	/**
	 * 获取：详情内容，html代码
	 */
	public String getDetailHtml() {
		return detailHtml;
	}
}
