package com.octopus.springdemo.code.jdbc;

import java.util.List;

public interface UserDao {
	public UserInfo findById(Long id);
	
	public List<UserInfo> findAll();
	
	public List<UserInfo> findByUsername(String name);
	
	public int insert(UserInfo user);
	
	public int count();
}
