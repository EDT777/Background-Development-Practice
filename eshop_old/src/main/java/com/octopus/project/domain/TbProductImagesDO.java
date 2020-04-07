package com.octopus.project.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 文件上传
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public class TbProductImagesDO implements Serializable {
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
	 * 图片路径，以|分割
	 */
	private String imageUrl;
	/**
	 * 内容类型，用于传递正确的值给浏览器，上传时设定
	 */
	private String contentType;
	/**
	 * 图片顺序
	 */
	private Integer order;

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
	 * 设置：图片路径，以|分割
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	/**
	 * 获取：图片路径，以|分割
	 */
	public String getImageUrl() {
		return imageUrl;
	}
	/**
	 * 设置：内容类型，用于传递正确的值给浏览器，上传时设定
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	/**
	 * 获取：内容类型，用于传递正确的值给浏览器，上传时设定
	 */
	public String getContentType() {
		return contentType;
	}
	/**
	 * 设置：图片顺序
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}
	/**
	 * 获取：图片顺序
	 */
	public Integer getOrder() {
		return order;
	}
}
