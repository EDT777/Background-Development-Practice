package com.octopus.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.octopus.project.dao.SysRoleMenuDao;
import com.octopus.project.domain.SysRoleMenuDO;
import com.octopus.project.service.SysRoleMenuService;



@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	
	@Override
	public SysRoleMenuDO get(Long id){
		return sysRoleMenuDao.get(id);
	}
	
	@Override
	public List<SysRoleMenuDO> list(Map<String, Object> map){
		return sysRoleMenuDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sysRoleMenuDao.count(map);
	}
	
	@Override
	public int save(SysRoleMenuDO sysRoleMenu){
		return sysRoleMenuDao.save(sysRoleMenu);
	}
	
	@Override
	public int update(SysRoleMenuDO sysRoleMenu){
		return sysRoleMenuDao.update(sysRoleMenu);
	}
	
	@Override
	public int remove(Long id){
		return sysRoleMenuDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return sysRoleMenuDao.batchRemove(ids);
	}
	
}
