package com.octopus.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.octopus.project.dao.SysDictDao;
import com.octopus.project.domain.SysDictDO;
import com.octopus.project.service.SysDictService;



@Service
public class SysDictServiceImpl implements SysDictService {
	@Autowired
	private SysDictDao sysDictDao;
	
	@Override
	public SysDictDO get(Long id){
		return sysDictDao.get(id);
	}
	
	@Override
	public List<SysDictDO> list(Map<String, Object> map){
		return sysDictDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sysDictDao.count(map);
	}
	
	@Override
	public int save(SysDictDO sysDict){
		return sysDictDao.save(sysDict);
	}
	
	@Override
	public int update(SysDictDO sysDict){
		return sysDictDao.update(sysDict);
	}
	
	@Override
	public int remove(Long id){
		return sysDictDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return sysDictDao.batchRemove(ids);
	}
	
}
