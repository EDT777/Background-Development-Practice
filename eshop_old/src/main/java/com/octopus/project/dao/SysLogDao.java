package com.octopus.project.dao;

import com.octopus.project.domain.SysLogDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 系统日志
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
@Mapper
public interface SysLogDao {

	SysLogDO get(Long id);
	
	List<SysLogDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(SysLogDO sysLog);
	
	int update(SysLogDO sysLog);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
