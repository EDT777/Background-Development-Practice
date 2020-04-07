package com.octopus.project.service;

import com.octopus.project.domain.SysMenuDO;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜单管理
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public interface SysMenuService {
	
	SysMenuDO get(Long menuId);
	
	List<SysMenuDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SysMenuDO sysMenu);
	
	int update(SysMenuDO sysMenu);
	
	int remove(Long menuId);
	
	int batchRemove(Long[] menuIds);
	
	LinkedHashMap<SysMenuDO, List<SysMenuDO>> listAllMenusByUserId(long userId);
}
