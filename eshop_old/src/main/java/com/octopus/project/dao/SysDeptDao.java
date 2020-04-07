package com.octopus.project.dao;

import com.octopus.project.domain.SysDeptDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 部门管理
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
@Mapper
public interface SysDeptDao {

	SysDeptDO get(Long deptId);
	
	List<SysDeptDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(SysDeptDO sysDept);
	
	int update(SysDeptDO sysDept);
	
	int remove(Long dept_id);
	
	int batchRemove(Long[] deptIds);
}
