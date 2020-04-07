package com.octopus.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.octopus.project.dao.TbOrderInfoDao;
import com.octopus.project.domain.TbOrderInfoDO;
import com.octopus.project.service.TbOrderInfoService;



@Service
public class TbOrderInfoServiceImpl implements TbOrderInfoService {
	@Autowired
	private TbOrderInfoDao tbOrderInfoDao;
	
	@Override
	public TbOrderInfoDO get(Long id){
		return tbOrderInfoDao.get(id);
	}
	
	@Override
	public List<TbOrderInfoDO> list(Map<String, Object> map){
		return tbOrderInfoDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tbOrderInfoDao.count(map);
	}
	
	@Override
	public int save(TbOrderInfoDO tbOrderInfo){
		return tbOrderInfoDao.save(tbOrderInfo);
	}
	
	@Override
	public int update(TbOrderInfoDO tbOrderInfo){
		return tbOrderInfoDao.update(tbOrderInfo);
	}
	
	@Override
	public int remove(Long id){
		return tbOrderInfoDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tbOrderInfoDao.batchRemove(ids);
	}
	
}
