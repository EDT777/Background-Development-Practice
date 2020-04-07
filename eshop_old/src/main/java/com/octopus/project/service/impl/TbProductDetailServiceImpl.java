package com.octopus.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.octopus.project.dao.TbProductDetailDao;
import com.octopus.project.domain.TbProductDetailDO;
import com.octopus.project.service.TbProductDetailService;



@Service
public class TbProductDetailServiceImpl implements TbProductDetailService {
	@Autowired
	private TbProductDetailDao tbProductDetailDao;
	
	@Override
	public TbProductDetailDO get(Long id){
		return tbProductDetailDao.get(id);
	}
	
	@Override
	public List<TbProductDetailDO> list(Map<String, Object> map){
		return tbProductDetailDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tbProductDetailDao.count(map);
	}
	
	@Override
	public int save(TbProductDetailDO tbProductDetail){
		return tbProductDetailDao.save(tbProductDetail);
	}
	
	@Override
	public int update(TbProductDetailDO tbProductDetail){
		return tbProductDetailDao.update(tbProductDetail);
	}
	
	@Override
	public int remove(Long id){
		return tbProductDetailDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tbProductDetailDao.batchRemove(ids);
	}
	
}
