package com.octopus.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.octopus.project.dao.SysTaskDao;
import com.octopus.project.domain.SysTaskDO;
import com.octopus.project.service.SysTaskService;



@Service
public class SysTaskServiceImpl implements SysTaskService {
	@Autowired
	private SysTaskDao sysTaskDao;
	
	@Override
	public SysTaskDO get(Long id){
		return sysTaskDao.get(id);
	}
	
	@Override
	public List<SysTaskDO> list(Map<String, Object> map){
		return sysTaskDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sysTaskDao.count(map);
	}
	
	@Override
	public int save(SysTaskDO sysTask){
		return sysTaskDao.save(sysTask);
	}
	
	@Override
	public int update(SysTaskDO sysTask){
		return sysTaskDao.update(sysTask);
	}
	
	@Override
	public int remove(Long id){
		return sysTaskDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return sysTaskDao.batchRemove(ids);
	}
	
}
