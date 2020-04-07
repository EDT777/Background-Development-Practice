package com.octopus.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.octopus.project.dao.TbProductImagesDao;
import com.octopus.project.domain.TbProductImagesDO;
import com.octopus.project.service.TbProductImagesService;



@Service
public class TbProductImagesServiceImpl implements TbProductImagesService {
	@Autowired
	private TbProductImagesDao tbProductImagesDao;
	
	@Override
	public TbProductImagesDO get(Long id){
		return tbProductImagesDao.get(id);
	}
	
	@Override
	public List<TbProductImagesDO> list(Map<String, Object> map){
		return tbProductImagesDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tbProductImagesDao.count(map);
	}
	
	@Override
	public int save(TbProductImagesDO tbProductImages){
		return tbProductImagesDao.save(tbProductImages);
	}
	
	@Override
	public int update(TbProductImagesDO tbProductImages){
		return tbProductImagesDao.update(tbProductImages);
	}
	
	@Override
	public int remove(Long id){
		return tbProductImagesDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tbProductImagesDao.batchRemove(ids);
	}
	
}
