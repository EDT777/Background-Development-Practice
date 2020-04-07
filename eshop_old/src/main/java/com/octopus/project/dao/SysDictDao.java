package com.octopus.project.dao;

import com.octopus.project.domain.SysDictDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 字典表
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
@Mapper
public interface SysDictDao {

	SysDictDO get(Long id);
	
	List<SysDictDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(SysDictDO sysDict);
	
	int update(SysDictDO sysDict);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
