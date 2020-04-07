package com.octopus.project.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 商品分类
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public class TbProductTypeDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Long id;
	/**
	 * 实际存放地址
	 */
	private String typeName;
	/**
	 * 父类型
	 */
	private Long parentId;
	/**
	 * 分类的图标
	 */
	private String iconClass;
	/**
	 * 创建人
	 */
	private Long createBy;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 更新人
	 */
	private Long updateBy;
	/**
	 * 更新时间
	 */
	private Date gmtUpdate;

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
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	/**
	 * 获取：实际存放地址
	 */
	public String getTypeName() {
		return typeName;
	}
	/**
	 * 设置：父类型
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：父类型
	 */
	public Long getParentId() {
		return parentId;
	}
	/**
	 * 设置：分类的图标
	 */
	public void setIconClass(String iconClass) {
		this.iconClass = iconClass;
	}
	/**
	 * 获取：分类的图标
	 */
	public String getIconClass() {
		return iconClass;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}
	/**
	 * 获取：创建人
	 */
	public Long getCreateBy() {
		return createBy;
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
	/**
	 * 设置：更新人
	 */
	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}
	/**
	 * 获取：更新人
	 */
	public Long getUpdateBy() {
		return updateBy;
	}
	/**
	 * 设置：更新时间
	 */
	public void setGmtUpdate(Date gmtUpdate) {
		this.gmtUpdate = gmtUpdate;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getGmtUpdate() {
		return gmtUpdate;
	}
}
