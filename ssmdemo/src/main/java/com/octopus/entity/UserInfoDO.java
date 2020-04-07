package com.octopus.entity;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;



/**
 * 用户信息
 * 
 * @author jason
 * @email 1626883728@qq.com
 * @date 2019-12-05 17:07:53
 */
public class UserInfoDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 用户�?
	 */
	private String userName;
	/**
	 * 主键
	 */
	private String userPwd;
	/**
	 * 用户状�?�，0表示正常�?1表示禁用
	 */
	private Integer userStatus;
	/**
	 * 1表示已经删除�?0表示正常
	 */
	private Integer userDelete;
	/**
	 * 用户积分
	 */
	private Integer userPoint;
	/**
	 * 用户积分
	 */
	private Date userBirthday;

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
	 * 设置：用户名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：用户名
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：主�?
	 */
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	/**
	 * 获取：主�?
	 */
	public String getUserPwd() {
		return userPwd;
	}
	/**
	 * 设置：用户状态，0表示正常�?1表示禁用
	 */
	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}
	/**
	 * 获取：用户状态，0表示正常�?1表示禁用
	 */
	public Integer getUserStatus() {
		return userStatus;
	}
	/**
	 * 设置�?1表示已经删除�?0表示正常
	 */
	public void setUserDelete(Integer userDelete) {
		this.userDelete = userDelete;
	}
	/**
	 * 获取�?1表示已经删除�?0表示正常
	 */
	public Integer getUserDelete() {
		return userDelete;
	}
	/**
	 * 设置：用户积�?
	 */
	public void setUserPoint(Integer userPoint) {
		this.userPoint = userPoint;
	}
	/**
	 * 获取：用户积�?
	 */
	public Integer getUserPoint() {
		return userPoint;
	}
	/**
	 * 设置：用户积�?
	 */
	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}
	/**
	 * 获取：用户积�?
	 */
	public Date getUserBirthday() {
		return userBirthday;
	}
}
