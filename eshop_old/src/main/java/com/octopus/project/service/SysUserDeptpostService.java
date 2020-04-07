package com.octopus.project.service;

import com.octopus.project.domain.SysUserDeptpostDO;

import java.util.List;
import java.util.Map;

/**
 * 用户与部门岗位对应关系
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public interface SysUserDeptpostService {
	
	SysUserDeptpostDO get(Long id);
	
	List<SysUserDeptpostDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SysUserDeptpostDO sysUserDeptpost);
	
	int update(SysUserDeptpostDO sysUserDeptpost);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
