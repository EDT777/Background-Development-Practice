package com.octopus.project.dao;

import com.octopus.project.domain.SysRoleDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 角色
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
@Mapper
public interface SysRoleDao {

	SysRoleDO get(Long roleId);
	
	List<SysRoleDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(SysRoleDO sysRole);
	
	int update(SysRoleDO sysRole);
	
	int remove(Long role_id);
	
	int batchRemove(Long[] roleIds);
}
