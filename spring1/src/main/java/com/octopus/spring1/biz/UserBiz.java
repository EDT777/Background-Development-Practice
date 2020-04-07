package com.octopus.spring1.biz;

public interface UserBiz {
	public static final String SUCCESS = "success";
	public static final String FAIL = "fail";
	
	public String login(String userName,String pwd);
}
