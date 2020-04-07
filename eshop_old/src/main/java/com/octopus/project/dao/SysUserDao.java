package com.octopus.project.dao;

import com.octopus.project.domain.SysUserDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
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
