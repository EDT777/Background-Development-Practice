package com.octopus.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.octopus.project.dao.TbProductTypeDao;
import com.octopus.project.domain.TbProductTypeDO;
import com.octopus.project.service.TbProductTypeService;



@Service
public class TbProductTypeServiceImpl implements TbProductTypeService {
	@Autowired
	private TbProductTypeDao tbProductTypeDao;
	
	@Override
	public TbProductTypeDO get(Long id){
		return tbProductTypeDao.get(id);
	}
	
	@Override
	public List<TbProductTypeDO> list(Map<String, Object> map){
		return tbProductTypeDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tbProductTypeDao.count(map);
	}
	
	@Override
	public int save(TbProductTypeDO tbProductType){
		return tbProductTypeDao.save(tbProductType);
	}
	
	@Override
	public int update(TbProductTypeDO tbProductType){
		return tbProductTypeDao.update(tbProductType);
	}
	
	@Override
	public int remove(Long id){
		return tbProductTypeDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tbProductTypeDao.batchRemove(ids);
	}
	
}
