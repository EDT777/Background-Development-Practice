package com.octopus.project.dao;

import com.octopus.project.domain.TbProductTypeDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 商品分类
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
@Mapper
public interface TbProductTypeDao {

	TbProductTypeDO get(Long id);
	
	List<TbProductTypeDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(TbProductTypeDO tbProductType);
	
	int update(TbProductTypeDO tbProductType);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
