package com.octopus.project.service;

import com.octopus.project.domain.SysTaskDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public interface SysTaskService {
	
	SysTaskDO get(Long id);
	
	List<SysTaskDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SysTaskDO sysTask);
	
	int update(SysTaskDO sysTask);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
