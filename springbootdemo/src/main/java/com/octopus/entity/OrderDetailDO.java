package com.octopus.entity;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;



/**
 * 订单详情
 * 
 * @author jason
 * @email 1626883728@qq.com
 * @date 2019-12-05 17:07:52
 */
public class OrderDetailDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 对应订单
	 */
	private Long orderid;
	/**
	 * 产品
	 */
	private Long productid;
	/**
	 * 数量
	 */
	private Integer count;
	/**
	 * 每件单价
	 */
	private BigDecimal price;

	/**
	 * 设置：主�?
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：主�?
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：对应订�?
	 */
	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}
	/**
	 * 获取：对应订�?
	 */
	public Long getOrderid() {
		return orderid;
	}
	/**
	 * 设置：产�?
	 */
	public void setProductid(Long productid) {
		this.productid = productid;
	}
	/**
	 * 获取：产�?
	 */
	public Long getProductid() {
		return productid;
	}
	/**
	 * 设置：数�?
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
	/**
	 * 获取：数�?
	 */
	public Integer getCount() {
		return count;
	}
	/**
	 * 设置：每件单�?
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：每件单�?
	 */
	public BigDecimal getPrice() {
		return price;
	}
}
