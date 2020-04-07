package com.octopus.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author jason
 * @email 1626883728@qq.com
 * @date 2019-12-17 18:31:57
 */
public class TbAccountDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Long id;
	/**
	 * 
	 */
	private String accountNo;
	/**
	 * 
	 */
	private String accountName;
	/**
	 * 
	 */
	private Long balance;
	/**
	 * 
	 */
	private String remark;

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
	 * 设置：
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	/**
	 * 获取：
	 */
	public String getAccountNo() {
		return accountNo;
	}
	/**
	 * 设置：
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	/**
	 * 获取：
	 */
	public String getAccountName() {
		return accountName;
	}
	/**
	 * 设置：
	 */
	public void setBalance(Long balance) {
		this.balance = balance;
	}
	/**
	 * 获取：
	 */
	public Long getBalance() {
		return balance;
	}
	/**
	 * 设置：
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：
	 */
	public String getRemark() {
		return remark;
	}
}
