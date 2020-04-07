package com.octopus.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.octopus.project.dao.TbCartItemDao;
import com.octopus.project.domain.TbCartItemDO;
import com.octopus.project.service.TbCartItemService;



@Service
public class TbCartItemServiceImpl implements TbCartItemService {
	@Autowired
	private TbCartItemDao tbCartItemDao;
	
	@Override
	public TbCartItemDO get(Long id){
		return tbCartItemDao.get(id);
	}
	
	@Override
	public List<TbCartItemDO> list(Map<String, Object> map){
		return tbCartItemDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tbCartItemDao.count(map);
	}
	
	@Override
	public int save(TbCartItemDO tbCartItem){
		return tbCartItemDao.save(tbCartItem);
	}
	
	@Override
	public int update(TbCartItemDO tbCartItem){
		return tbCartItemDao.update(tbCartItem);
	}
	
	@Override
	public int remove(Long id){
		return tbCartItemDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tbCartItemDao.batchRemove(ids);
	}
	
}
