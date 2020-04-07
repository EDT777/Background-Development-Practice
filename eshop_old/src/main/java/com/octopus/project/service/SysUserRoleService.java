package com.octopus.project.service;

import com.octopus.project.domain.SysUserRoleDO;

import java.util.List;
import java.util.Map;

/**
 * 用户与角色对应关系
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public interface SysUserRoleService {
	
	SysUserRoleDO get(Long id);
	
	List<SysUserRoleDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SysUserRoleDO sysUserRole);
	
	int update(SysUserRoleDO sysUserRole);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
