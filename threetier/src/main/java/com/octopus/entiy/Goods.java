package com.octopus.entiy;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
 
public class Goods implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1174920677642433961L;
	
	private Long id;
	private String name ;
	private BigDecimal price;
	private int count ;
	private String type;
	private Date upTime;
	private int state;
	private String sourceChannel;
	private BigDecimal inPrice;
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Goods(Long id, String name, BigDecimal price, int count, String type, Date upTime, int state,
			String sourceChannel, BigDecimal inPrice, BigDecimal promtionPrice, Long typeId) {
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
		this.typeId = typeId;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", price=" + price + ", count=" + count + ", type=" + type
				+ ", upTime=" + upTime + ", state=" + state + ", sourceChannel=" + sourceChannel + ", inPrice="
				+ inPrice + ", promtionPrice=" + promtionPrice + ", typeId=" + typeId + "]";
	}
	private BigDecimal promtionPrice;
	private Long typeId;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
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
	public int getState() {
		return state;
	}
	public void setState(int state) {
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
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
}
