package com.octopus.project.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 购物车项目
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public class TbFavoriteDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 对应用户
	 */
	private Long userId;
	/**
	 * 产品，引用tb_product
	 */
	private Long productId;
	/**
	 * 加入购物车时间
	 */
	private Date joinDate;

	/**
	 * 设置：主键
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：对应用户
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：对应用户
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：产品，引用tb_product
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	/**
	 * 获取：产品，引用tb_product
	 */
	public Long getProductId() {
		return productId;
	}
	/**
	 * 设置：加入购物车时间
	 */
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	/**
	 * 获取：加入购物车时间
	 */
	public Date getJoinDate() {
		return joinDate;
	}
}
