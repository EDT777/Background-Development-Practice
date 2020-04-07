package com.octopus.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.octopus.project.dao.SysUserDateInfoDao;
import com.octopus.project.domain.SysUserDateInfoDO;
import com.octopus.project.service.SysUserDateInfoService;



@Service
public class SysUserDateInfoServiceImpl implements SysUserDateInfoService {
	@Autowired
	private SysUserDateInfoDao sysUserDateInfoDao;
	
	@Override
	public SysUserDateInfoDO get(Long id){
		return sysUserDateInfoDao.get(id);
	}
	
	@Override
	public List<SysUserDateInfoDO> list(Map<String, Object> map){
		return sysUserDateInfoDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sysUserDateInfoDao.count(map);
	}
	
	@Override
	public int save(SysUserDateInfoDO sysUserDateInfo){
		return sysUserDateInfoDao.save(sysUserDateInfo);
	}
	
	@Override
	public int update(SysUserDateInfoDO sysUserDateInfo){
		return sysUserDateInfoDao.update(sysUserDateInfo);
	}
	
	@Override
	public int remove(Long id){
		return sysUserDateInfoDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return sysUserDateInfoDao.batchRemove(ids);
	}
	
}
