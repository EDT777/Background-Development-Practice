package com.octopus.common.utils;

import org.apache.shiro.SecurityUtils;

import com.octopus.project.domain.SysUserDO;

public class ShiroUtil {
	
	//获取当前环境下登陆的用户对象
	public static SysUserDO getCurrentUser() {
		SysUserDO user = (SysUserDO) SecurityUtils.getSubject().getPrincipal();
		return user;
	}
}
