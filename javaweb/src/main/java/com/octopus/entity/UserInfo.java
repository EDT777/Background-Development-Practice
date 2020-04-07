package com.octopus.entity;

import java.sql.Date;

public class UserInfo {
	private Long id;
	
	private String userName ;
	
	private String userPwd;
	
	private Integer userStatus;
	
	private Integer userDelete;
	
	private Integer userPoint;
	
	private Date userBirthday;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public Integer getUserDelete() {
		return userDelete;
	}

	public void setUserDelete(Integer userDelete) {
		this.userDelete = userDelete;
	}

	public Integer getUserPoint() {
		return userPoint;
	}

	public void setUserPoint(Integer userPoint) {
		this.userPoint = userPoint;
	}

	public Date getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", userName=" + userName + ", userPwd=" + userPwd + ", userStatus=" + userStatus
				+ ", userDelete=" + userDelete + ", userPoint=" + userPoint + ", userBirthday=" + userBirthday + "]";
	}
	
	
	
	
}
