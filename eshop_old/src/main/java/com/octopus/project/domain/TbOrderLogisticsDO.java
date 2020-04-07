package com.octopus.project.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 订单物流信息
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public class TbOrderLogisticsDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 对应用户
	 */
	private Long orderId;
	/**
	 * 快递公司
	 */
	private Long type;
	/**
	 * 物流单号
	 */
	private String logisticsNo;
	/**
	 * 提交物流单号时间
	 */
	private Date submitDate;

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
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取：对应用户
	 */
	public Long getOrderId() {
		return orderId;
	}
	/**
	 * 设置：快递公司
	 */
	public void setType(Long type) {
		this.type = type;
	}
	/**
	 * 获取：快递公司
	 */
	public Long getType() {
		return type;
	}
	/**
	 * 设置：物流单号
	 */
	public void setLogisticsNo(String logisticsNo) {
		this.logisticsNo = logisticsNo;
	}
	/**
	 * 获取：物流单号
	 */
	public String getLogisticsNo() {
		return logisticsNo;
	}
	/**
	 * 设置：提交物流单号时间
	 */
	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}
	/**
	 * 获取：提交物流单号时间
	 */
	public Date getSubmitDate() {
		return submitDate;
	}
}
