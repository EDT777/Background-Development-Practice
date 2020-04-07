package com.octopus.project.service;

import com.octopus.project.domain.TbProductDO;

import java.util.List;
import java.util.Map;

/**
 * 商品基础信息
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public interface TbProductService {
	
	TbProductDO get(Long id);
	
	List<TbProductDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TbProductDO tbProduct);
	
	int update(TbProductDO tbProduct);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
