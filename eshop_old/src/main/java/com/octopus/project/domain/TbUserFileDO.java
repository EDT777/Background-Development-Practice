package com.octopus.project.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 文件上传
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public class TbUserFileDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Long id;
	/**
	 * 实际存放地址
	 */
	private String url;
	/**
	 * 原文件名
	 */
	private String orignalName;
	/**
	 * 内容类型
	 */
	private String contentType;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;

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
	 * 设置：实际存放地址
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：实际存放地址
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：原文件名
	 */
	public void setOrignalName(String orignalName) {
		this.orignalName = orignalName;
	}
	/**
	 * 获取：原文件名
	 */
	public String getOrignalName() {
		return orignalName;
	}
	/**
	 * 设置：内容类型
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	/**
	 * 获取：内容类型
	 */
	public String getContentType() {
		return contentType;
	}
	/**
	 * 设置：创建时间
	 */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getGmtCreate() {
		return gmtCreate;
	}
}
