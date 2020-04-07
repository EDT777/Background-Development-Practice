package com.octopus.project.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 用户与部门岗位对应关系
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public class SysUserDeptpostDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Long id;
	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 部门岗位ID
	 */
	private Long deptpostId;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：用户ID
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户ID
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：部门岗位ID
	 */
	public void setDeptpostId(Long deptpostId) {
		this.deptpostId = deptpostId;
	}
	/**
	 * 获取：部门岗位ID
	 */
	public Long getDeptpostId() {
		return deptpostId;
	}
}
