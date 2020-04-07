package com.octopus.project.dao;

import com.octopus.project.domain.SysPostDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 岗位管理
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
@Mapper
public interface SysPostDao {

	SysPostDO get(Long postId);
	
	List<SysPostDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(SysPostDO sysPost);
	
	int update(SysPostDO sysPost);
	
	int remove(Long post_id);
	
	int batchRemove(Long[] postIds);
}
