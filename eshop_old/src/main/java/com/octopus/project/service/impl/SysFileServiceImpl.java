package com.octopus.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.octopus.project.dao.SysFileDao;
import com.octopus.project.domain.SysFileDO;
import com.octopus.project.service.SysFileService;



@Service
public class SysFileServiceImpl implements SysFileService {
	@Autowired
	private SysFileDao sysFileDao;
	
	@Override
	public SysFileDO get(Long id){
		return sysFileDao.get(id);
	}
	
	@Override
	public List<SysFileDO> list(Map<String, Object> map){
		return sysFileDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sysFileDao.count(map);
	}
	
	@Override
	public int save(SysFileDO sysFile){
		return sysFileDao.save(sysFile);
	}
	
	@Override
	public int update(SysFileDO sysFile){
		return sysFileDao.update(sysFile);
	}
	
	@Override
	public int remove(Long id){
		return sysFileDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return sysFileDao.batchRemove(ids);
	}
	
}
