package com.octopus.project.dao;

import com.octopus.project.domain.SysMenuDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 菜单管理
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
@Mapper
public interface SysMenuDao {

	SysMenuDO get(Long menuId);
	
	List<SysMenuDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(SysMenuDO sysMenu);
	
	int update(SysMenuDO sysMenu);
	
	int remove(Long menuId);
	
	int batchRemove(Long[] menuIds);
	
	List<SysMenuDO> findByUsername(String username);
}
