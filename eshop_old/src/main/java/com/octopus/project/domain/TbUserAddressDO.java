package com.octopus.project.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 购物车项目
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public class TbUserAddressDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 对应用户
	 */
	private Long userId;
	/**
	 * 收件电话
	 */
	private String mobile;
	/**
	 * 国家
	 */
	private String country;
	/**
	 * 省份
	 */
	private String province;
	/**
	 * 城市
	 */
	private String city;
	/**
	 * 区
	 */
	private String area;
	/**
	 * 收件地址
	 */
	private String address;
	/**
	 * 收件人
	 */
	private String contactName;
	/**
	 * 是否为默认地址
	 */
	private Integer isDefault;

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
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：对应用户
	 */
	public Long getUserId() {
		return userId;
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
	 * 设置：国家
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * 获取：国家
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * 设置：省份
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取：省份
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 设置：城市
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：城市
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置：区
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * 获取：区
	 */
	public String getArea() {
		return area;
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
	 * 设置：是否为默认地址
	 */
	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}
	/**
	 * 获取：是否为默认地址
	 */
	public Integer getIsDefault() {
		return isDefault;
	}
}
