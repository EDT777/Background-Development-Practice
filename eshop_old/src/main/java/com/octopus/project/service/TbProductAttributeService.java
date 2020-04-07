package com.octopus.project.service;

import com.octopus.project.domain.TbProductAttributeDO;

import java.util.List;
import java.util.Map;

/**
 * 商品属性表
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public interface TbProductAttributeService {
	
	TbProductAttributeDO get(Long id);
	
	List<TbProductAttributeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TbProductAttributeDO tbProductAttribute);
	
	int update(TbProductAttributeDO tbProductAttribute);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
