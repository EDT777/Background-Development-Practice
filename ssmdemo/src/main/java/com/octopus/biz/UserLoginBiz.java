package com.octopus.biz;

import com.octopus.entity.UserInfoDO;

public interface UserLoginBiz {

	public String LOGIN_SUCCESS="success";
	public String LOGIN_FAILED="failed";
	
	public String login(String username,String password);
	
	public UserInfoDO findUserByUsername(String username);
}
