package com.octopus.entity;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author jason
 * @email 1626883728@qq.com
 * @date 2019-12-05 17:07:53
 */
public class SysUserDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 用户�?
	 */
	private String username;
	/**
	 * 
	 */
	private String name;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 
	 */
	private Long deptId;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 手机�?
	 */
	private String mobile;
	/**
	 * 状�?? 0:禁用�?1:正常
	 */
	private Integer status;
	/**
	 * 创建用户id
	 */
	private Long userIdCreate;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 修改时间
	 */
	private Date gmtModified;
	/**
	 * 性别
	 */
	private Long sex;
	/**
	 * 出身日期
	 */
	private Date birth;
	/**
	 * 
	 */
	private Long picId;
	/**
	 * 现居住地
	 */
	private String liveAddress;
	/**
	 * 爱好
	 */
	private String hobby;
	/**
	 * 省份
	 */
	private String province;
	/**
	 * �?在城�?
	 */
	private String city;
	/**
	 * �?在地�?
	 */
	private String district;

	/**
	 * 设置�?
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取�?
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：用户名
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置�?
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取�?
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：密�?
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密�?
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置�?
	 */
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	/**
	 * 获取�?
	 */
	public Long getDeptId() {
		return deptId;
	}
	/**
	 * 设置：邮�?
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：邮�?
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：手机号
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：手机号
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：状�? 0:禁用�?1:正常
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状�? 0:禁用�?1:正常
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：创建用户id
	 */
	public void setUserIdCreate(Long userIdCreate) {
		this.userIdCreate = userIdCreate;
	}
	/**
	 * 获取：创建用户id
	 */
	public Long getUserIdCreate() {
		return userIdCreate;
	}
	/**
	 * 设置：创建时�?
	 */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	/**
	 * 获取：创建时�?
	 */
	public Date getGmtCreate() {
		return gmtCreate;
	}
	/**
	 * 设置：修改时�?
	 */
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	/**
	 * 获取：修改时�?
	 */
	public Date getGmtModified() {
		return gmtModified;
	}
	/**
	 * 设置：�?�别
	 */
	public void setSex(Long sex) {
		this.sex = sex;
	}
	/**
	 * 获取：�?�别
	 */
	public Long getSex() {
		return sex;
	}
	/**
	 * 设置：出身日�?
	 */
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	/**
	 * 获取：出身日�?
	 */
	public Date getBirth() {
		return birth;
	}
	/**
	 * 设置�?
	 */
	public void setPicId(Long picId) {
		this.picId = picId;
	}
	/**
	 * 获取�?
	 */
	public Long getPicId() {
		return picId;
	}
	/**
	 * 设置：现居住�?
	 */
	public void setLiveAddress(String liveAddress) {
		this.liveAddress = liveAddress;
	}
	/**
	 * 获取：现居住�?
	 */
	public String getLiveAddress() {
		return liveAddress;
	}
	/**
	 * 设置：爱�?
	 */
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	/**
	 * 获取：爱�?
	 */
	public String getHobby() {
		return hobby;
	}
	/**
	 * 设置：省�?
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取：省�?
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 设置：所在城�?
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：所在城�?
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置：所在地�?
	 */
	public void setDistrict(String district) {
		this.district = district;
	}
	/**
	 * 获取：所在地�?
	 */
	public String getDistrict() {
		return district;
	}
}
