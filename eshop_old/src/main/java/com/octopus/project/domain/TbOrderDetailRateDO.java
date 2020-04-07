package com.octopus.project.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 订单详情
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public class TbOrderDetailRateDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 对应订单详情
	 */
	private Long orderDetailId;
	/**
	 * 物流评价，0-5代表星级
	 */
	private Integer logisticsRate;
	/**
	 * 服务评价，0-5代表星级
	 */
	private Integer serviceRate;
	/**
	 * 产品评价，0-5代表星级
	 */
	private Integer productRate;
	/**
	 * 评价内容
	 */
	private String message;
	/**
	 * 评价时间
	 */
	private Date rateTime;
	/**
	 * 状态，0表示评价，1表示已生效，2表示已取消
	 */
	private Integer state;

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
	 * 设置：对应订单详情
	 */
	public void setOrderDetailId(Long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	/**
	 * 获取：对应订单详情
	 */
	public Long getOrderDetailId() {
		return orderDetailId;
	}
	/**
	 * 设置：物流评价，0-5代表星级
	 */
	public void setLogisticsRate(Integer logisticsRate) {
		this.logisticsRate = logisticsRate;
	}
	/**
	 * 获取：物流评价，0-5代表星级
	 */
	public Integer getLogisticsRate() {
		return logisticsRate;
	}
	/**
	 * 设置：服务评价，0-5代表星级
	 */
	public void setServiceRate(Integer serviceRate) {
		this.serviceRate = serviceRate;
	}
	/**
	 * 获取：服务评价，0-5代表星级
	 */
	public Integer getServiceRate() {
		return serviceRate;
	}
	/**
	 * 设置：产品评价，0-5代表星级
	 */
	public void setProductRate(Integer productRate) {
		this.productRate = productRate;
	}
	/**
	 * 获取：产品评价，0-5代表星级
	 */
	public Integer getProductRate() {
		return productRate;
	}
	/**
	 * 设置：评价内容
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * 获取：评价内容
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * 设置：评价时间
	 */
	public void setRateTime(Date rateTime) {
		this.rateTime = rateTime;
	}
	/**
	 * 获取：评价时间
	 */
	public Date getRateTime() {
		return rateTime;
	}
	/**
	 * 设置：状态，0表示评价，1表示已生效，2表示已取消
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取：状态，0表示评价，1表示已生效，2表示已取消
	 */
	public Integer getState() {
		return state;
	}
}
