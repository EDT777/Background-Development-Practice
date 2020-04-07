package com.octopus.dao;

import com.octopus.entity.UserInfo;

public interface UserInfoDAO {
	/**
	 * 根据用户名查找用户信息
	 * @param userName
	 * @return
	 */
	public UserInfo findByUserName(String userName);
}
