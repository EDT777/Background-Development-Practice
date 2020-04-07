package com.octopus.project.dao;

import com.octopus.project.domain.SysUserRoleDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 用户与角色对应关系
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
@Mapper
public interface SysUserRoleDao {

	SysUserRoleDO get(Long id);
	
	List<SysUserRoleDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(SysUserRoleDO sysUserRole);
	
	int update(SysUserRoleDO sysUserRole);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
