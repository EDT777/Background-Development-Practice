package com.octopus.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.octopus.project.dao.TbOrderLogisticsDao;
import com.octopus.project.domain.TbOrderLogisticsDO;
import com.octopus.project.service.TbOrderLogisticsService;



@Service
public class TbOrderLogisticsServiceImpl implements TbOrderLogisticsService {
	@Autowired
	private TbOrderLogisticsDao tbOrderLogisticsDao;
	
	@Override
	public TbOrderLogisticsDO get(Long id){
		return tbOrderLogisticsDao.get(id);
	}
	
	@Override
	public List<TbOrderLogisticsDO> list(Map<String, Object> map){
		return tbOrderLogisticsDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tbOrderLogisticsDao.count(map);
	}
	
	@Override
	public int save(TbOrderLogisticsDO tbOrderLogistics){
		return tbOrderLogisticsDao.save(tbOrderLogistics);
	}
	
	@Override
	public int update(TbOrderLogisticsDO tbOrderLogistics){
		return tbOrderLogisticsDao.update(tbOrderLogistics);
	}
	
	@Override
	public int remove(Long id){
		return tbOrderLogisticsDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tbOrderLogisticsDao.batchRemove(ids);
	}
	
}
