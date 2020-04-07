package com.octopus.dao;

import com.octopus.entity.UserInfoDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 用户信息
 * @author jason
 * @email 1626883728@qq.com
 * @date 2019-12-05 17:07:53
 */
@Mapper
public interface UserInfoDao {

	UserInfoDO get(Long id);
	
	List<UserInfoDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(UserInfoDO userInfo);
	
	int update(UserInfoDO userInfo);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
