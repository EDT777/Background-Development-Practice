package com.octopus.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.octopus.project.dao.TbProductAttributeDao;
import com.octopus.project.domain.TbProductAttributeDO;
import com.octopus.project.service.TbProductAttributeService;



@Service
public class TbProductAttributeServiceImpl implements TbProductAttributeService {
	@Autowired
	private TbProductAttributeDao tbProductAttributeDao;
	
	@Override
	public TbProductAttributeDO get(Long id){
		return tbProductAttributeDao.get(id);
	}
	
	@Override
	public List<TbProductAttributeDO> list(Map<String, Object> map){
		return tbProductAttributeDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tbProductAttributeDao.count(map);
	}
	
	@Override
	public int save(TbProductAttributeDO tbProductAttribute){
		return tbProductAttributeDao.save(tbProductAttribute);
	}
	
	@Override
	public int update(TbProductAttributeDO tbProductAttribute){
		return tbProductAttributeDao.update(tbProductAttribute);
	}
	
	@Override
	public int remove(Long id){
		return tbProductAttributeDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tbProductAttributeDao.batchRemove(ids);
	}
	
}
