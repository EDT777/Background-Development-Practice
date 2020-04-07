package com.octopus.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.octopus.project.dao.TbUserAddressDao;
import com.octopus.project.domain.TbUserAddressDO;
import com.octopus.project.service.TbUserAddressService;



@Service
public class TbUserAddressServiceImpl implements TbUserAddressService {
	@Autowired
	private TbUserAddressDao tbUserAddressDao;
	
	@Override
	public TbUserAddressDO get(Long id){
		return tbUserAddressDao.get(id);
	}
	
	@Override
	public List<TbUserAddressDO> list(Map<String, Object> map){
		return tbUserAddressDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tbUserAddressDao.count(map);
	}
	
	@Override
	public int save(TbUserAddressDO tbUserAddress){
		return tbUserAddressDao.save(tbUserAddress);
	}
	
	@Override
	public int update(TbUserAddressDO tbUserAddress){
		return tbUserAddressDao.update(tbUserAddress);
	}
	
	@Override
	public int remove(Long id){
		return tbUserAddressDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tbUserAddressDao.batchRemove(ids);
	}
	
}
