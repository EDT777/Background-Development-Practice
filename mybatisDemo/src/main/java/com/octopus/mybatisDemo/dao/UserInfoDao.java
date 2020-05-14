package com.octopus.mybatisDemo.dao;

import java.util.List;
import java.util.Map;

import com.octopus.mybatisDemo.entity.UserInfo;

public interface UserInfoDao {
	public List<UserInfo> findAllUsers();
	
	public int insert(String sql);
	
	public UserInfo findByUserName(String userName);
	
	public List<UserInfo> findByUserNameAndStatus(String userName,Integer userStatus);
	
	/**
	 * 根据用户信息查询，如果用户名不为空则条件包含用户名，所有其他列类似
	 * @param userInfo
	 * @return
	 */
	public List<UserInfo> findByEntity(UserInfo userInfo);
	
	/**
	 * 根据用户信息查询，如果用户名不为空则条件包含用户名，所有其他列类似
	 * @param userInfo
	 * @return
	 */
	public List<UserInfo> findByMap(Map<String,Object> params);

	public int delete(Long id);
	
	public int update(UserInfo user);
	
	/**
	 * 添加
	 * @param userInfo
	 * @return 如果返回1代表添加成功，否则代表添加失败
	 */
	public int insertNew(UserInfo userInfo);
	
	
	/**
	 * 查询给定id的所有的用户s
	 * @param ids
	 * @return
	 */
	public List<UserInfo> findByIds(Long[] ids);
	
	/**
	 * 查询给定id的所有的用户s
	 * @param ids
	 * @return
	 */
	public List<UserInfo> findByIds1(List<Long> ids);
}
