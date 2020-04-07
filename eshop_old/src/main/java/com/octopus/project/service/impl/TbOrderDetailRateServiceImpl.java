package com.octopus.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.octopus.project.dao.TbOrderDetailRateDao;
import com.octopus.project.domain.TbOrderDetailRateDO;
import com.octopus.project.service.TbOrderDetailRateService;



@Service
public class TbOrderDetailRateServiceImpl implements TbOrderDetailRateService {
	@Autowired
	private TbOrderDetailRateDao tbOrderDetailRateDao;
	
	@Override
	public TbOrderDetailRateDO get(Long id){
		return tbOrderDetailRateDao.get(id);
	}
	
	@Override
	public List<TbOrderDetailRateDO> list(Map<String, Object> map){
		return tbOrderDetailRateDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tbOrderDetailRateDao.count(map);
	}
	
	@Override
	public int save(TbOrderDetailRateDO tbOrderDetailRate){
		return tbOrderDetailRateDao.save(tbOrderDetailRate);
	}
	
	@Override
	public int update(TbOrderDetailRateDO tbOrderDetailRate){
		return tbOrderDetailRateDao.update(tbOrderDetailRate);
	}
	
	@Override
	public int remove(Long id){
		return tbOrderDetailRateDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tbOrderDetailRateDao.batchRemove(ids);
	}
	
}
