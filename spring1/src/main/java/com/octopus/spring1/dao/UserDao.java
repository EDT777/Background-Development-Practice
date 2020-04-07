package com.octopus.spring1.dao;

import java.util.List;

import com.octopus.spring1.entity.UserInfo;

public interface UserDao {

	UserInfo getById(int i);

	UserInfo findByUserName(String userName);

	List<UserInfo> findAll();

	int insert(UserInfo user);

}