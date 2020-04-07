package com.octopus.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.octopus.project.dao.SysUserRoleDao;
import com.octopus.project.domain.SysUserRoleDO;
import com.octopus.project.service.SysUserRoleService;



@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	
	@Override
	public SysUserRoleDO get(Long id){
		return sysUserRoleDao.get(id);
	}
	
	@Override
	public List<SysUserRoleDO> list(Map<String, Object> map){
		return sysUserRoleDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sysUserRoleDao.count(map);
	}
	
	@Override
	public int save(SysUserRoleDO sysUserRole){
		return sysUserRoleDao.save(sysUserRole);
	}
	
	@Override
	public int update(SysUserRoleDO sysUserRole){
		return sysUserRoleDao.update(sysUserRole);
	}
	
	@Override
	public int remove(Long id){
		return sysUserRoleDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return sysUserRoleDao.batchRemove(ids);
	}
	
}
