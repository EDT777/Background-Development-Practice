package com.octopus.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.octopus.project.dao.SysDeptDao;
import com.octopus.project.domain.SysDeptDO;
import com.octopus.project.service.SysDeptService;



@Service
public class SysDeptServiceImpl implements SysDeptService {
	@Autowired
	private SysDeptDao sysDeptDao;
	
	@Override
	public SysDeptDO get(Long deptId){
		return sysDeptDao.get(deptId);
	}
	
	@Override
	public List<SysDeptDO> list(Map<String, Object> map){
		return sysDeptDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sysDeptDao.count(map);
	}
	
	@Override
	public int save(SysDeptDO sysDept){
		return sysDeptDao.save(sysDept);
	}
	
	@Override
	public int update(SysDeptDO sysDept){
		return sysDeptDao.update(sysDept);
	}
	
	@Override
	public int remove(Long deptId){
		return sysDeptDao.remove(deptId);
	}
	
	@Override
	public int batchRemove(Long[] deptIds){
		return sysDeptDao.batchRemove(deptIds);
	}
	
}
