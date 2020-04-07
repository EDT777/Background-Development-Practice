package com.octopus.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.octopus.project.dao.SysUserPlusDao;
import com.octopus.project.domain.SysUserPlusDO;
import com.octopus.project.service.SysUserPlusService;



@Service
public class SysUserPlusServiceImpl implements SysUserPlusService {
	@Autowired
	private SysUserPlusDao sysUserPlusDao;
	
	@Override
	public SysUserPlusDO get(Long id){
		return sysUserPlusDao.get(id);
	}
	
	@Override
	public List<SysUserPlusDO> list(Map<String, Object> map){
		return sysUserPlusDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sysUserPlusDao.count(map);
	}
	
	@Override
	public int save(SysUserPlusDO sysUserPlus){
		return sysUserPlusDao.save(sysUserPlus);
	}
	
	@Override
	public int update(SysUserPlusDO sysUserPlus){
		return sysUserPlusDao.update(sysUserPlus);
	}
	
	@Override
	public int remove(Long id){
		return sysUserPlusDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return sysUserPlusDao.batchRemove(ids);
	}
	
}
