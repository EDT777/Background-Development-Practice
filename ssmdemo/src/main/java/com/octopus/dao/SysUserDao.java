package com.octopus.dao;

import com.octopus.entity.SysUserDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author jason
 * @email 1626883728@qq.com
 * @date 2019-12-05 17:07:53
 */
@Mapper
public interface SysUserDao {

	SysUserDO get(Long userId);
	
	List<SysUserDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(SysUserDO sysUser);
	
	int update(SysUserDO sysUser);
	
	int remove(Long user_id);
	
	int batchRemove(Long[] userIds);
}
