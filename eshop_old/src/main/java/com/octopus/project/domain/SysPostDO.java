package com.octopus.project.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 岗位管理
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public class SysPostDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Long postId;
	/**
	 * 岗位名称
	 */
	private String name;
	/**
	 * 排序
	 */
	private Integer orderNum;
	/**
	 * 是否删除  -1：已删除  0：正常
	 */
	private Integer delFlag;

	/**
	 * 设置：
	 */
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	/**
	 * 获取：
	 */
	public Long getPostId() {
		return postId;
	}
	/**
	 * 设置：岗位名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：岗位名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：排序
	 */
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	/**
	 * 获取：排序
	 */
	public Integer getOrderNum() {
		return orderNum;
	}
	/**
	 * 设置：是否删除  -1：已删除  0：正常
	 */
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	/**
	 * 获取：是否删除  -1：已删除  0：正常
	 */
	public Integer getDelFlag() {
		return delFlag;
	}
}