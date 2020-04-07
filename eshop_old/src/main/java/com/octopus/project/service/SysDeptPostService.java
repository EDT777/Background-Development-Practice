package com.octopus.project.service;

import com.octopus.project.domain.SysDeptPostDO;

import java.util.List;
import java.util.Map;

/**
 * 部门与岗位对应关系
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public interface SysDeptPostService {
	
	SysDeptPostDO get(Long id);
	
	List<SysDeptPostDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SysDeptPostDO sysDeptPost);
	
	int update(SysDeptPostDO sysDeptPost);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
