package com.octopus.project.service;

import com.octopus.project.domain.SysPostDO;

import java.util.List;
import java.util.Map;

/**
 * 岗位管理
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public interface SysPostService {
	
	SysPostDO get(Long postId);
	
	List<SysPostDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SysPostDO sysPost);
	
	int update(SysPostDO sysPost);
	
	int remove(Long postId);
	
	int batchRemove(Long[] postIds);
}
