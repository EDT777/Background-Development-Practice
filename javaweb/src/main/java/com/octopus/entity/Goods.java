package com.octopus.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Goods implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3418657583073526609L;

	private Long id ;
	
	private String name;
	
	private BigDecimal price;
	
	private Integer count ;
	
	private String type;
	
	private Date upTime;
	
	private Short state;
	
	private String sourceChannel;
	
	private BigDecimal inPrice;
	
	private BigDecimal promtionPrice;
	
	private GoodsType goodsType;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getUpTime() {
		return upTime;
	}

	public void setUpTime(Date upTime) {
		this.upTime = upTime;
	}

	public Short getState() {
		return state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public String getSourceChannel() {
		return sourceChannel;
	}

	public void setSourceChannel(String sourceChannel) {
		this.sourceChannel = sourceChannel;
	}

	public BigDecimal getInPrice() {
		return inPrice;
	}

	public void setInPrice(BigDecimal inPrice) {
		this.inPrice = inPrice;
	}

	public BigDecimal getPromtionPrice() {
		return promtionPrice;
	}

	public void setPromtionPrice(BigDecimal promtionPrice) {
		this.promtionPrice = promtionPrice;
	}

	public GoodsType getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}

	public Goods(Long id, String name, BigDecimal price, Integer count, String type, Date upTime, Short state,
			String sourceChannel, BigDecimal inPrice, BigDecimal promtionPrice, GoodsType goodsType) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.count = count;
		this.type = type;
		this.upTime = upTime;
		this.state = state;
		this.sourceChannel = sourceChannel;
		this.inPrice = inPrice;
		this.promtionPrice = promtionPrice;
		this.goodsType = goodsType;
	}

	public Goods() {
		super();
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", price=" + price + ", count=" + count + ", type=" + type
				+ ", upTime=" + upTime + ", state=" + state + ", sourceChannel=" + sourceChannel + ", inPrice="
				+ inPrice + ", promtionPrice=" + promtionPrice + ", goodsType=" + goodsType + "]";
	}
	
	

	

	
	
	

}
