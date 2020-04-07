package com.octopus.entity;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;



/**
 * 订单
 * 
 * @author jason
 * @email 1626883728@qq.com
 * @date 2019-12-05 17:07:52
 */
public class OrderInfoDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 收件电话
	 */
	private String mobile;
	/**
	 * 收件地址
	 */
	private String address;
	/**
	 * 收件�?
	 */
	private String contactName;
	/**
	 * 订单下单日期
	 */
	private Date makeDate;
	/**
	 * 订单付款日期
	 */
	private Date payDate;
	/**
	 * 订单总价
	 */
	private BigDecimal totalPrice;
	/**
	 * 订单用户
	 */
	private Long userId;
	/**
	 * 订单状�?�，0表示下单�?1表示已付款，2表示申请�?款中�?3表示已经�?�?
	 */
	private Integer state;
	/**
	 * 备注
	 */
	private String remark;

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
	 * 设置：收件电�?
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：收件电�?
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：收件地�?
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：收件地�?
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：收件人
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	/**
	 * 获取：收件人
	 */
	public String getContactName() {
		return contactName;
	}
	/**
	 * 设置：订单下单日�?
	 */
	public void setMakeDate(Date makeDate) {
		this.makeDate = makeDate;
	}
	/**
	 * 获取：订单下单日�?
	 */
	public Date getMakeDate() {
		return makeDate;
	}
	/**
	 * 设置：订单付款日�?
	 */
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	/**
	 * 获取：订单付款日�?
	 */
	public Date getPayDate() {
		return payDate;
	}
	/**
	 * 设置：订单�?�价
	 */
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	/**
	 * 获取：订单�?�价
	 */
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	/**
	 * 设置：订单用�?
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：订单用�?
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：订单状态，0表示下单�?1表示已付款，2表示申请�?款中�?3表示已经�?�?
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取：订单状态，0表示下单�?1表示已付款，2表示申请�?款中�?3表示已经�?�?
	 */
	public Integer getState() {
		return state;
	}
	/**
	 * 设置：备�?
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备�?
	 */
	public String getRemark() {
		return remark;
	}
}
