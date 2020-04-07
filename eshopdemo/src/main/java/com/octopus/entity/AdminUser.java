package com.octopus.entity;

public class AdminUser {
	private Long id;
	private String userName;
	private String userPwd;
	private int userStatus;
	private int userDelete;

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
	
	

	public AdminUser() {
		super();
	}

	public AdminUser(Long id, String userName, String userPwd, int userStatus, int userDelete) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userStatus = userStatus;
		this.userDelete = userDelete;
	}

	@Override
	public String toString() {
		return "AdminUser [id=" + id + ", userName=" + userName + ", userPwd=" + userPwd + ", userStatus=" + userStatus
				+ ", userDelete=" + userDelete + "]";
	}

}
