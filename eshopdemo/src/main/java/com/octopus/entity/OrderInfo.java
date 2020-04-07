package com.octopus.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import com.octopus.dao.NoPersistent;

public class OrderInfo {
	private Long id;
	
	private Timestamp makeDate;
	
	public Timestamp getMakeDate() {
		return makeDate;
	}

	public void setMakeDate(Timestamp makeDate) {
		this.makeDate = makeDate;
	}

	public Timestamp getPayDate() {
		return payDate;
	}

	public void setPayDate(Timestamp payDate) {
		this.payDate = payDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	private Timestamp payDate;
	
	private String contactName;
	
	private String mobile;
	
	private String address;
	
	private BigDecimal totalPrice;
	
	private Long userId;
	
	private String remark;
	
	private Short state ;
	
	@NoPersistent
	private List<OrderDetail> orderDetails ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Short getState() {
		return state;
	}

	public void setState(Short state) {
		this.state = state;
	}
	
	
}
