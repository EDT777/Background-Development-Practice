package com.octopus.project.service;

import com.octopus.project.domain.SysRoleMenuDO;

import java.util.List;
import java.util.Map;

/**
 * 角色与菜单对应关系
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public interface SysRoleMenuService {
	
	SysRoleMenuDO get(Long id);
	
	List<SysRoleMenuDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SysRoleMenuDO sysRoleMenu);
	
	int update(SysRoleMenuDO sysRoleMenu);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
