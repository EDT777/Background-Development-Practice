package com.octopus.biz.impl;

import java.util.List;

import com.octopus.biz.AdminUserBiz;
import com.octopus.dao.GenericDAO;
import com.octopus.dao.GenericDAOImpl;
import com.octopus.entity.AdminUser;

public class AdminUserBizImpl implements AdminUserBiz {
	private GenericDAO<AdminUser> adminUserDao = new GenericDAOImpl<AdminUser>(AdminUser.class);

	/**
	 * 实现登录验证
	 * 
	 * @param username
	 * @param pwd
	 * @return 如果登陆成功，则返回success，否则返回错误描述
	 */
	@Override
	public String login(String username, String pwd) {
		// 尝试查找用户名
		List<AdminUser> list = adminUserDao.find(" user_name=?", new Object[] { username }, 1, 1);
		if (list.size() > 0) {
			if (list.get(0).getUserPwd().equals(pwd)) {
				return "success";
			} else {
				return "密码错误";
			}
		} else {
			return "没有这个用户";
		}
	}

	@Override
	public AdminUser findByUserName(String userName) {
		// 尝试查找用户名
		List<AdminUser> list = adminUserDao.find(" user_name=?", new Object[] { userName }, 1, 1);
		return list.size() > 0 ? list.get(0) : null;
	}
	
	

}
