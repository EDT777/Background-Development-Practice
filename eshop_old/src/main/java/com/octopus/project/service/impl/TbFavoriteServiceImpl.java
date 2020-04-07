package com.octopus.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.octopus.project.dao.TbFavoriteDao;
import com.octopus.project.domain.TbFavoriteDO;
import com.octopus.project.service.TbFavoriteService;



@Service
public class TbFavoriteServiceImpl implements TbFavoriteService {
	@Autowired
	private TbFavoriteDao tbFavoriteDao;
	
	@Override
	public TbFavoriteDO get(Long id){
		return tbFavoriteDao.get(id);
	}
	
	@Override
	public List<TbFavoriteDO> list(Map<String, Object> map){
		return tbFavoriteDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tbFavoriteDao.count(map);
	}
	
	@Override
	public int save(TbFavoriteDO tbFavorite){
		return tbFavoriteDao.save(tbFavorite);
	}
	
	@Override
	public int update(TbFavoriteDO tbFavorite){
		return tbFavoriteDao.update(tbFavorite);
	}
	
	@Override
	public int remove(Long id){
		return tbFavoriteDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tbFavoriteDao.batchRemove(ids);
	}
	
}
