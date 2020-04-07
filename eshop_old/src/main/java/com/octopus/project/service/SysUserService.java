package com.octopus.project.service;

import com.octopus.project.domain.SysMenuDO;
import com.octopus.project.domain.SysUserDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public interface SysUserService {
	
	SysUserDO get(Long userId);
	
	List<SysUserDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SysUserDO sysUser);
	
	int update(SysUserDO sysUser);
	
	int remove(Long userId);
	
	int batchRemove(Long[] userIds);
	
	SysUserDO findByUsername(String name);
	
	List<SysMenuDO> findMenusByUser(String username);
}
