package com.octopus.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.octopus.project.dao.SysDeptPostDao;
import com.octopus.project.domain.SysDeptPostDO;
import com.octopus.project.service.SysDeptPostService;



@Service
public class SysDeptPostServiceImpl implements SysDeptPostService {
	@Autowired
	private SysDeptPostDao sysDeptPostDao;
	
	@Override
	public SysDeptPostDO get(Long id){
		return sysDeptPostDao.get(id);
	}
	
	@Override
	public List<SysDeptPostDO> list(Map<String, Object> map){
		return sysDeptPostDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sysDeptPostDao.count(map);
	}
	
	@Override
	public int save(SysDeptPostDO sysDeptPost){
		return sysDeptPostDao.save(sysDeptPost);
	}
	
	@Override
	public int update(SysDeptPostDO sysDeptPost){
		return sysDeptPostDao.update(sysDeptPost);
	}
	
	@Override
	public int remove(Long id){
		return sysDeptPostDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return sysDeptPostDao.batchRemove(ids);
	}
	
}
