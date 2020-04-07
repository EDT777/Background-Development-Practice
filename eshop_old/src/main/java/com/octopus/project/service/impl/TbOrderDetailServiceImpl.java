package com.octopus.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.octopus.project.dao.TbOrderDetailDao;
import com.octopus.project.domain.TbOrderDetailDO;
import com.octopus.project.service.TbOrderDetailService;



@Service
public class TbOrderDetailServiceImpl implements TbOrderDetailService {
	@Autowired
	private TbOrderDetailDao tbOrderDetailDao;
	
	@Override
	public TbOrderDetailDO get(Long id){
		return tbOrderDetailDao.get(id);
	}
	
	@Override
	public List<TbOrderDetailDO> list(Map<String, Object> map){
		return tbOrderDetailDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tbOrderDetailDao.count(map);
	}
	
	@Override
	public int save(TbOrderDetailDO tbOrderDetail){
		return tbOrderDetailDao.save(tbOrderDetail);
	}
	
	@Override
	public int update(TbOrderDetailDO tbOrderDetail){
		return tbOrderDetailDao.update(tbOrderDetail);
	}
	
	@Override
	public int remove(Long id){
		return tbOrderDetailDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tbOrderDetailDao.batchRemove(ids);
	}
	
}
