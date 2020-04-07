package com.octopus.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.octopus.project.dao.SysUserDeptpostDao;
import com.octopus.project.domain.SysUserDeptpostDO;
import com.octopus.project.service.SysUserDeptpostService;



@Service
public class SysUserDeptpostServiceImpl implements SysUserDeptpostService {
	@Autowired
	private SysUserDeptpostDao sysUserDeptpostDao;
	
	@Override
	public SysUserDeptpostDO get(Long id){
		return sysUserDeptpostDao.get(id);
	}
	
	@Override
	public List<SysUserDeptpostDO> list(Map<String, Object> map){
		return sysUserDeptpostDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sysUserDeptpostDao.count(map);
	}
	
	@Override
	public int save(SysUserDeptpostDO sysUserDeptpost){
		return sysUserDeptpostDao.save(sysUserDeptpost);
	}
	
	@Override
	public int update(SysUserDeptpostDO sysUserDeptpost){
		return sysUserDeptpostDao.update(sysUserDeptpost);
	}
	
	@Override
	public int remove(Long id){
		return sysUserDeptpostDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return sysUserDeptpostDao.batchRemove(ids);
	}
	
}
