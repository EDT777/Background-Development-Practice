package com.octopus.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.octopus.project.dao.SysPostDao;
import com.octopus.project.domain.SysPostDO;
import com.octopus.project.service.SysPostService;



@Service
public class SysPostServiceImpl implements SysPostService {
	@Autowired
	private SysPostDao sysPostDao;
	
	@Override
	public SysPostDO get(Long postId){
		return sysPostDao.get(postId);
	}
	
	@Override
	public List<SysPostDO> list(Map<String, Object> map){
		return sysPostDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sysPostDao.count(map);
	}
	
	@Override
	public int save(SysPostDO sysPost){
		return sysPostDao.save(sysPost);
	}
	
	@Override
	public int update(SysPostDO sysPost){
		return sysPostDao.update(sysPost);
	}
	
	@Override
	public int remove(Long postId){
		return sysPostDao.remove(postId);
	}
	
	@Override
	public int batchRemove(Long[] postIds){
		return sysPostDao.batchRemove(postIds);
	}
	
}
