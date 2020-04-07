package com.octopus.project.service;

import com.octopus.project.domain.SysUserPlusDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public interface SysUserPlusService {
	
	SysUserPlusDO get(Long id);
	
	List<SysUserPlusDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SysUserPlusDO sysUserPlus);
	
	int update(SysUserPlusDO sysUserPlus);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
