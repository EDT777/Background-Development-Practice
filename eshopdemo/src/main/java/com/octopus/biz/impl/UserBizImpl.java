package com.octopus.biz.impl;

import java.util.List;

import com.octopus.biz.UserBiz;
import com.octopus.dao.GenericDAO;
import com.octopus.dao.GenericDAOImpl;
import com.octopus.entity.UserInfo;

public class UserBizImpl implements UserBiz {
	
	private GenericDAO<UserInfo> userDao = new GenericDAOImpl<UserInfo>(UserInfo.class);

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
		List<UserInfo> list = userDao.find(" user_name=?", new Object[] { username }, 1, 1);
		if (list.size() > 0) {
			String pwdDb = list.get(0).getUserPwd();
			if (pwd!=null && pwd.equals(pwdDb)) {
				return LOGIN_SUCCESS;
			} else {
				return LOGIN_FAIL;
			}
		} else {
			return LOGIN_FAIL;
		}
	}

	@Override
	public UserInfo findByUserName(String userName) {
		// 尝试查找用户名
		List<UserInfo> list = userDao.find(" user_name=?", new Object[] { userName }, 1, 1);
		return list.size() > 0 ? list.get(0) : null;
	}
	
	

}
