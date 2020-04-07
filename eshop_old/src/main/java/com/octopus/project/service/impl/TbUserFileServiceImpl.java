package com.octopus.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.octopus.project.dao.TbUserFileDao;
import com.octopus.project.domain.TbUserFileDO;
import com.octopus.project.service.TbUserFileService;



@Service
public class TbUserFileServiceImpl implements TbUserFileService {
	@Autowired
	private TbUserFileDao tbUserFileDao;
	
	@Override
	public TbUserFileDO get(Long id){
		return tbUserFileDao.get(id);
	}
	
	@Override
	public List<TbUserFileDO> list(Map<String, Object> map){
		return tbUserFileDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tbUserFileDao.count(map);
	}
	
	@Override
	public int save(TbUserFileDO tbUserFile){
		return tbUserFileDao.save(tbUserFile);
	}
	
	@Override
	public int update(TbUserFileDO tbUserFile){
		return tbUserFileDao.update(tbUserFile);
	}
	
	@Override
	public int remove(Long id){
		return tbUserFileDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tbUserFileDao.batchRemove(ids);
	}
	
}
