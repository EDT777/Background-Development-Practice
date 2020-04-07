package com.octopus.project.service;

import com.octopus.project.domain.TbFavoriteDO;

import java.util.List;
import java.util.Map;

/**
 * 购物车项目
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public interface TbFavoriteService {
	
	TbFavoriteDO get(Long id);
	
	List<TbFavoriteDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TbFavoriteDO tbFavorite);
	
	int update(TbFavoriteDO tbFavorite);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
