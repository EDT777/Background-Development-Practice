package com.octopus.project.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 用户入职和离职时间信息
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public class SysUserDateInfoDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 用户
	 */
	private String userId;
	/**
	 * 入职日期
	 */
	private Date enroleDate;
	/**
	 * 离职日期
	 */
	private Date leaveDate;
	/**
	 * 状态，0表示在职，1表示离职
	 */
	private Integer status;

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
	 * 设置：用户
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：入职日期
	 */
	public void setEnroleDate(Date enroleDate) {
		this.enroleDate = enroleDate;
	}
	/**
	 * 获取：入职日期
	 */
	public Date getEnroleDate() {
		return enroleDate;
	}
	/**
	 * 设置：离职日期
	 */
	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}
	/**
	 * 获取：离职日期
	 */
	public Date getLeaveDate() {
		return leaveDate;
	}
	/**
	 * 设置：状态，0表示在职，1表示离职
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态，0表示在职，1表示离职
	 */
	public Integer getStatus() {
		return status;
	}
}
