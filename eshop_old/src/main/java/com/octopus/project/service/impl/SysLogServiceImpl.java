package com.octopus.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.octopus.project.dao.SysLogDao;
import com.octopus.project.domain.SysLogDO;
import com.octopus.project.service.SysLogService;



@Service
public class SysLogServiceImpl implements SysLogService {
	@Autowired
	private SysLogDao sysLogDao;
	
	@Override
	public SysLogDO get(Long id){
		return sysLogDao.get(id);
	}
	
	@Override
	public List<SysLogDO> list(Map<String, Object> map){
		return sysLogDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sysLogDao.count(map);
	}
	
	@Override
	public int save(SysLogDO sysLog){
		return sysLogDao.save(sysLog);
	}
	
	@Override
	public int update(SysLogDO sysLog){
		return sysLogDao.update(sysLog);
	}
	
	@Override
	public int remove(Long id){
		return sysLogDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return sysLogDao.batchRemove(ids);
	}
	
}
