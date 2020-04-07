package com.octopus.project.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 部门与岗位对应关系
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public class SysDeptPostDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Long id;
	/**
	 * 部门ID
	 */
	private Long deptId;
	/**
	 * 岗位ID
	 */
	private Long postId;
	/**
	 * 父ID
	 */
	private Long parentId;

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
	 * 设置：部门ID
	 */
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	/**
	 * 获取：部门ID
	 */
	public Long getDeptId() {
		return deptId;
	}
	/**
	 * 设置：岗位ID
	 */
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	/**
	 * 获取：岗位ID
	 */
	public Long getPostId() {
		return postId;
	}
	/**
	 * 设置：父ID
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：父ID
	 */
	public Long getParentId() {
		return parentId;
	}
}
