package com.octopus.entity;

import java.math.BigDecimal;
import java.io.Serializable;

import java.util.Date;



/**
 * 
 * 
 * @author jason
 * @email 1626883728@qq.com
 * @date 2019-12-05 17:07:40
 */
public class GoodsDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Long id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 价格
	 */
	private BigDecimal price;
	/**
	 * 数量
	 */
	private Integer count;
	/**
	 * 商品类型
	 */
	private String type;
	/**
	 * 上架时间
	 */
	private Date upTime;
	/**
	 * 商品状�?�，0表示正常�?1表示库存预警�?-1表示无货�?-2表示已下�?
	 */
	private Integer state;
	/**
	 * 进货渠道
	 */
	private String sourceChannel;
	/**
	 * 进货价格
	 */
	private BigDecimal inPrice;
	/**
	 * 促销价格
	 */
	private BigDecimal promtionPrice;
	/**
	 * 商品类型的引用上类型表的id
	 */
	private Long typeId;

	/**
	 * 设置�?
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取�?
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：名�?
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：名�?
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：价�?
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：价�?
	 */
	public BigDecimal getPrice() {
		return price;
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
	 * 设置：商品类�?
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：商品类�?
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：上架时�?
	 */
	public void setUpTime(Date upTime) {
		this.upTime = upTime;
	}
	/**
	 * 获取：上架时�?
	 */
	public Date getUpTime() {
		return upTime;
	}
	/**
	 * 设置：商品状态，0表示正常�?1表示库存预警�?-1表示无货�?-2表示已下�?
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取：商品状态，0表示正常�?1表示库存预警�?-1表示无货�?-2表示已下�?
	 */
	public Integer getState() {
		return state;
	}
	/**
	 * 设置：进货渠�?
	 */
	public void setSourceChannel(String sourceChannel) {
		this.sourceChannel = sourceChannel;
	}
	/**
	 * 获取：进货渠�?
	 */
	public String getSourceChannel() {
		return sourceChannel;
	}
	/**
	 * 设置：进货价�?
	 */
	public void setInPrice(BigDecimal inPrice) {
		this.inPrice = inPrice;
	}
	/**
	 * 获取：进货价�?
	 */
	public BigDecimal getInPrice() {
		return inPrice;
	}
	/**
	 * 设置：促�?价格
	 */
	public void setPromtionPrice(BigDecimal promtionPrice) {
		this.promtionPrice = promtionPrice;
	}
	/**
	 * 获取：促�?价格
	 */
	public BigDecimal getPromtionPrice() {
		return promtionPrice;
	}
	/**
	 * 设置：商品类型的引用上类型表的id
	 */
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	/**
	 * 获取：商品类型的引用上类型表的id
	 */
	public Long getTypeId() {
		return typeId;
	}
}
