package com.octopus.project.dao;

import com.octopus.project.domain.TbProductAttributeDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 商品属性表
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
@Mapper
public interface TbProductAttributeDao {

	TbProductAttributeDO get(Long id);
	
	List<TbProductAttributeDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(TbProductAttributeDO tbProductAttribute);
	
	int update(TbProductAttributeDO tbProductAttribute);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
