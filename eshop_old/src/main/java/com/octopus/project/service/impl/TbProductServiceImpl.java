package com.octopus.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.octopus.project.dao.TbProductDao;
import com.octopus.project.domain.TbProductDO;
import com.octopus.project.service.TbProductService;



@Service
public class TbProductServiceImpl implements TbProductService {
	@Autowired
	private TbProductDao tbProductDao;
	
	@Override
	public TbProductDO get(Long id){
		return tbProductDao.get(id);
	}
	
	@Override
	public List<TbProductDO> list(Map<String, Object> map){
		return tbProductDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tbProductDao.count(map);
	}
	
	@Override
	public int save(TbProductDO tbProduct){
		return tbProductDao.save(tbProduct);
	}
	
	@Override
	public int update(TbProductDO tbProduct){
		return tbProductDao.update(tbProduct);
	}
	
	@Override
	public int remove(Long id){
		return tbProductDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tbProductDao.batchRemove(ids);
	}
	
}
