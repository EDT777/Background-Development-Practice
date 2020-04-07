package com.octopus.project.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 订单
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public class TbOrderInfoDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 */
	private Long id;
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
	 * 因付总价
	 */
	private BigDecimal actualPrice;
	/**
	 * 订单状态，0提交，1支付，2发货，3签收，4完成，-1取消，-2申请退款中，-3客服介入中
	 */
	private Integer orderState;
	/**
	 * 支付状态，0未支付，1已支付
	 */
	private Integer payState;
	/**
	 * 完成日期
	 */
	private Date finishDate;
	/**
	 * 收件电话
	 */
	private String mobile;
	/**
	 * 收件地址
	 */
	private String address;
	/**
	 * 收件人
	 */
	private String contactName;
	/**
	 * 订单用户
	 */
	private Long userId;
	/**
	 * 用户备注
	 */
	private String userRemark;

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
	 * 设置：订单下单日期
	 */
	public void setMakeDate(Date makeDate) {
		this.makeDate = makeDate;
	}
	/**
	 * 获取：订单下单日期
	 */
	public Date getMakeDate() {
		return makeDate;
	}
	/**
	 * 设置：订单付款日期
	 */
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	/**
	 * 获取：订单付款日期
	 */
	public Date getPayDate() {
		return payDate;
	}
	/**
	 * 设置：订单总价
	 */
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	/**
	 * 获取：订单总价
	 */
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	/**
	 * 设置：因付总价
	 */
	public void setActualPrice(BigDecimal actualPrice) {
		this.actualPrice = actualPrice;
	}
	/**
	 * 获取：因付总价
	 */
	public BigDecimal getActualPrice() {
		return actualPrice;
	}
	/**
	 * 设置：订单状态，0提交，1支付，2发货，3签收，4完成，-1取消，-2申请退款中，-3客服介入中
	 */
	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}
	/**
	 * 获取：订单状态，0提交，1支付，2发货，3签收，4完成，-1取消，-2申请退款中，-3客服介入中
	 */
	public Integer getOrderState() {
		return orderState;
	}
	/**
	 * 设置：支付状态，0未支付，1已支付
	 */
	public void setPayState(Integer payState) {
		this.payState = payState;
	}
	/**
	 * 获取：支付状态，0未支付，1已支付
	 */
	public Integer getPayState() {
		return payState;
	}
	/**
	 * 设置：完成日期
	 */
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	/**
	 * 获取：完成日期
	 */
	public Date getFinishDate() {
		return finishDate;
	}
	/**
	 * 设置：收件电话
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：收件电话
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：收件地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：收件地址
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
	 * 设置：订单用户
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：订单用户
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：用户备注
	 */
	public void setUserRemark(String userRemark) {
		this.userRemark = userRemark;
	}
	/**
	 * 获取：用户备注
	 */
	public String getUserRemark() {
		return userRemark;
	}
}
