package com.octopus.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.octopus.project.dao.TbProductUpcDao;
import com.octopus.project.domain.TbProductUpcDO;
import com.octopus.project.service.TbProductUpcService;



@Service
public class TbProductUpcServiceImpl implements TbProductUpcService {
	@Autowired
	private TbProductUpcDao tbProductUpcDao;
	
	@Override
	public TbProductUpcDO get(Long id){
		return tbProductUpcDao.get(id);
	}
	
	@Override
	public List<TbProductUpcDO> list(Map<String, Object> map){
		return tbProductUpcDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tbProductUpcDao.count(map);
	}
	
	@Override
	public int save(TbProductUpcDO tbProductUpc){
		return tbProductUpcDao.save(tbProductUpc);
	}
	
	@Override
	public int update(TbProductUpcDO tbProductUpc){
		return tbProductUpcDao.update(tbProductUpc);
	}
	
	@Override
	public int remove(Long id){
		return tbProductUpcDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tbProductUpcDao.batchRemove(ids);
	}
	
}
