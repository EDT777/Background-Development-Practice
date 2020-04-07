package com.octopus.project.dao;

import com.octopus.project.domain.SysTaskDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
@Mapper
public interface SysTaskDao {

	SysTaskDO get(Long id);
	
	List<SysTaskDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(SysTaskDO sysTask);
	
	int update(SysTaskDO sysTask);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
