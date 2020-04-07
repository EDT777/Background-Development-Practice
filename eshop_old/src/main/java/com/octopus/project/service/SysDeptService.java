package com.octopus.project.service;

import com.octopus.project.domain.SysDeptDO;

import java.util.List;
import java.util.Map;

/**
 * 部门管理
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public interface SysDeptService {
	
	SysDeptDO get(Long deptId);
	
	List<SysDeptDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SysDeptDO sysDept);
	
	int update(SysDeptDO sysDept);
	
	int remove(Long deptId);
	
	int batchRemove(Long[] deptIds);
}
