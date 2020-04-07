package com.octopus.biz;

import com.octopus.entity.AdminUser;

public interface AdminUserBiz {

	/**
	 * 实现登录验证
	 * 
	 * @param username
	 * @param pwd
	 * @return 如果登陆成功，则返回success，否则返回错误描述
	 */
	String login(String username, String pwd);

	AdminUser findByUserName(String userName);

}