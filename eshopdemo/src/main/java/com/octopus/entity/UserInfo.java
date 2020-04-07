package com.octopus.entity;

import java.util.Date;

public class UserInfo {
	private Long id;
	private String userName;
	private String userPwd;
	private int userStatus;
	private int userDelete;
	private int userPoint;
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

	public  void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public int getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}

	public int getUserDelete() {
		return userDelete;
	}

	public void setUserDelete(int userDelete) {
		this.userDelete = userDelete;
	}

	public int getUserPoint() {
		return userPoint;
	}

	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}

	public Date getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public UserInfo(Long id, String userName, String userPwd, int userStatus, int userDelete, int userPoint,
			Date userBirthday) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userStatus = userStatus;
		this.userDelete = userDelete;
		this.userPoint = userPoint;
		this.userBirthday = userBirthday;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", userName=" + userName + ", userPwd=" + userPwd + ", userStatus=" + userStatus
				+ ", userDelete=" + userDelete + ", userPoint=" + userPoint + ", userBirthday=" + userBirthday + "]";
	}

	public UserInfo() {
		super();
	}

}
