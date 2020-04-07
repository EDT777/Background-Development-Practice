package com.octopus.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.octopus.project.dao.SysRoleDao;
import com.octopus.project.domain.SysRoleDO;
import com.octopus.project.service.SysRoleService;



@Service
public class SysRoleServiceImpl implements SysRoleService {
	@Autowired
	private SysRoleDao sysRoleDao;
	
	@Override
	public SysRoleDO get(Long roleId){
		return sysRoleDao.get(roleId);
	}
	
	@Override
	public List<SysRoleDO> list(Map<String, Object> map){
		return sysRoleDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sysRoleDao.count(map);
	}
	
	@Override
	public int save(SysRoleDO sysRole){
		return sysRoleDao.save(sysRole);
	}
	
	@Override
	public int update(SysRoleDO sysRole){
		return sysRoleDao.update(sysRole);
	}
	
	@Override
	public int remove(Long roleId){
		return sysRoleDao.remove(roleId);
	}
	
	@Override
	public int batchRemove(Long[] roleIds){
		return sysRoleDao.batchRemove(roleIds);
	}
	
}
