package com.octopus.project.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 商品upc
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public class TbProductUpcDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Long id;
	/**
	 * 对应商品
	 */
	private String productId;
	/**
	 * 单品名称，可能是大小，也可能是型号
	 */
	private String name;
	/**
	 * 分类名称
	 */
	private String typeName;
	/**
	 * 标价
	 */
	private BigDecimal price;
	/**
	 * 当前售价
	 */
	private BigDecimal salePrice;
	/**
	 * 是否上架，默认为不上架
	 */
	private Integer onSale;
	/**
	 * 数量
	 */
	private Integer quantity;
	/**
	 * 库存预警阈值
	 */
	private Integer lowStockThreshold;
	/**
	 * 计价单位，参考数据字典ProductUnit
	 */
	private String unity;
	/**
	 * 供应商预留
	 */
	private Long supplierReference;
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
	 * 是否删除，0表示正常，1表示已删除
	 */
	private Integer delFlag;
	/**
	 * 单品编码，预留
	 */
	private String upc;

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
	 * 设置：对应商品
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}
	/**
	 * 获取：对应商品
	 */
	public String getProductId() {
		return productId;
	}
	/**
	 * 设置：单品名称，可能是大小，也可能是型号
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：单品名称，可能是大小，也可能是型号
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：分类名称
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	/**
	 * 获取：分类名称
	 */
	public String getTypeName() {
		return typeName;
	}
	/**
	 * 设置：标价
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：标价
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * 设置：当前售价
	 */
	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}
	/**
	 * 获取：当前售价
	 */
	public BigDecimal getSalePrice() {
		return salePrice;
	}
	/**
	 * 设置：是否上架，默认为不上架
	 */
	public void setOnSale(Integer onSale) {
		this.onSale = onSale;
	}
	/**
	 * 获取：是否上架，默认为不上架
	 */
	public Integer getOnSale() {
		return onSale;
	}
	/**
	 * 设置：数量
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	/**
	 * 获取：数量
	 */
	public Integer getQuantity() {
		return quantity;
	}
	/**
	 * 设置：库存预警阈值
	 */
	public void setLowStockThreshold(Integer lowStockThreshold) {
		this.lowStockThreshold = lowStockThreshold;
	}
	/**
	 * 获取：库存预警阈值
	 */
	public Integer getLowStockThreshold() {
		return lowStockThreshold;
	}
	/**
	 * 设置：计价单位，参考数据字典ProductUnit
	 */
	public void setUnity(String unity) {
		this.unity = unity;
	}
	/**
	 * 获取：计价单位，参考数据字典ProductUnit
	 */
	public String getUnity() {
		return unity;
	}
	/**
	 * 设置：供应商预留
	 */
	public void setSupplierReference(Long supplierReference) {
		this.supplierReference = supplierReference;
	}
	/**
	 * 获取：供应商预留
	 */
	public Long getSupplierReference() {
		return supplierReference;
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
	/**
	 * 设置：是否删除，0表示正常，1表示已删除
	 */
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	/**
	 * 获取：是否删除，0表示正常，1表示已删除
	 */
	public Integer getDelFlag() {
		return delFlag;
	}
	/**
	 * 设置：单品编码，预留
	 */
	public void setUpc(String upc) {
		this.upc = upc;
	}
	/**
	 * 获取：单品编码，预留
	 */
	public String getUpc() {
		return upc;
	}
}
