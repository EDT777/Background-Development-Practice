package com.octopus.project.service;

import com.octopus.project.domain.SysRoleDO;

import java.util.List;
import java.util.Map;

/**
 * 角色
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public interface SysRoleService {
	
	SysRoleDO get(Long roleId);
	
	List<SysRoleDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SysRoleDO sysRole);
	
	int update(SysRoleDO sysRole);
	
	int remove(Long roleId);
	
	int batchRemove(Long[] roleIds);
}
