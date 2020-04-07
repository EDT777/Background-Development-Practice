package com.octopus.biz;

import com.octopus.entity.UserInfo;

public interface UserBiz {

	/**
	 * 登录成功返回的标志
	 */
	public static final String LOGIN_SUCCESS = "success";

	/**
	 * 登录失败返回的标识
	 */
	public static final String LOGIN_FAIL = "fail";

	/**
	 * 实现登录验证
	 * 
	 * @param username
	 * @param pwd
	 * @return 如果登陆成功，则返回success，否则返回错误描述
	 */
	String login(String username, String pwd);

	/**
	 * 根据用户名查找用户信息
	 * 
	 * @param userName
	 * @return
	 */
	UserInfo findByUserName(String userName);

}