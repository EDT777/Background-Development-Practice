package com.octopus.project.dao;

import com.octopus.project.domain.SysUserDateInfoDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 用户入职和离职时间信息
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
@Mapper
public interface SysUserDateInfoDao {

	SysUserDateInfoDO get(Long id);
	
	List<SysUserDateInfoDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(SysUserDateInfoDO sysUserDateInfo);
	
	int update(SysUserDateInfoDO sysUserDateInfo);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
