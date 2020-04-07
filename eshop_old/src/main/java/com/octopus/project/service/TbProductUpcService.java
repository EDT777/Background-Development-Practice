package com.octopus.project.service;

import com.octopus.project.domain.TbProductUpcDO;

import java.util.List;
import java.util.Map;

/**
 * 商品upc
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public interface TbProductUpcService {
	
	TbProductUpcDO get(Long id);
	
	List<TbProductUpcDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TbProductUpcDO tbProductUpc);
	
	int update(TbProductUpcDO tbProductUpc);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
