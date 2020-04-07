package com.octopus.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.octopus.biz.UserLoginBiz;
import com.octopus.dao.UserInfoDao;
import com.octopus.entity.UserInfoDO;

@Service
public class UserLoginBizImpl implements UserLoginBiz{

	private static final Logger logger = LoggerFactory.getLogger(UserLoginBizImpl.class);
	@Autowired
	private UserInfoDao userInfoDao;
	
	public String login(String username, String password) {
	String result = LOGIN_FAILED;
		//实现业务
		UserInfoDO user =null;
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("userName", username);
		List<UserInfoDO> list = userInfoDao.list(map);
		
		if(list.size()!=0) {
			user=list.get(0);
			if(user.getUserPwd().equals(password)) {
				result=LOGIN_SUCCESS;
			}
		}
		//记录日志
		logger.info("用户登录："+username+",结果为："+result);
		return result;
	}

	public UserInfoDO findUserByUsername(String username) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("userName", username);
		List<UserInfoDO> list = userInfoDao.list(map);
		if(list.size()!=0) {
			UserInfoDO user =list.get(0);
			user.setUserPwd("");
			return user;
		}
		return null;
	}

}
