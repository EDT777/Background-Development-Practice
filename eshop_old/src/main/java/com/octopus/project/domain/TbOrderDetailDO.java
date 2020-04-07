package com.octopus.project.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 订单详情
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public class TbOrderDetailDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 对应订单
	 */
	private Long orderId;
	/**
	 * 产品，引用tb_product_upc
	 */
	private Long productId;
	/**
	 * 数量
	 */
	private Integer count;
	/**
	 * 每件单价
	 */
	private BigDecimal price;
	/**
	 * 总价格
	 */
	private BigDecimal totalPrice;
	/**
	 * 总折扣金额
	 */
	private BigDecimal discountPrice;

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
	 * 设置：对应订单
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取：对应订单
	 */
	public Long getOrderId() {
		return orderId;
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
	 * 设置：每件单价
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：每件单价
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * 设置：总价格
	 */
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	/**
	 * 获取：总价格
	 */
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	/**
	 * 设置：总折扣金额
	 */
	public void setDiscountPrice(BigDecimal discountPrice) {
		this.discountPrice = discountPrice;
	}
	/**
	 * 获取：总折扣金额
	 */
	public BigDecimal getDiscountPrice() {
		return discountPrice;
	}
}
