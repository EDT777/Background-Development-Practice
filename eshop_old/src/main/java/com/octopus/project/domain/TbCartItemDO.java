package com.octopus.project.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 购物车项目
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public class TbCartItemDO implements Serializable {
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
	 * 产品，引用tb_product_upc
	 */
	private Long productId;
	/**
	 * 数量
	 */
	private Integer count;
	/**
	 * 加入购物车时价格
	 */
	private BigDecimal price;
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
	 * 设置：产品，引用tb_product_upc
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	/**
	 * 获取：产品，引用tb_product_upc
	 */
	public Long getProductId() {
		return productId;
	}
	/**
	 * 设置：数量
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
	/**
	 * 获取：数量
	 */
	public Integer getCount() {
		return count;
	}
	/**
	 * 设置：加入购物车时价格
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：加入购物车时价格
	 */
	public BigDecimal getPrice() {
		return price;
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
