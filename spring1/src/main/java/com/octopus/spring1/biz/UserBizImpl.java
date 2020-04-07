package com.octopus.spring1.biz;

import com.octopus.spring1.dao.UserDao;
import com.octopus.spring1.entity.UserInfo;

public class UserBizImpl  implements UserBiz{
	
	private UserDao userDao  ;
	public String login(String userName,String pwd) {
		if("user1".equals(userName) && "123456".equals(pwd)) {
			return SUCCESS;
		}else {
			return FAIL;
		}
//		UserInfo userInfo = this.userDao.findByUserName(userName);
//		if(userInfo!=null && pwd!=null) {
//			return pwd.equals(userInfo.getUserPwd())?SUCCESS:FAIL;
//		}
//		return FAIL;
	}
	
	public UserDao getUserDao() {
		return this.userDao;
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}
