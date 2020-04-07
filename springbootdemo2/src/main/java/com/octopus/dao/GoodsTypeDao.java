package com.octopus.dao;

import com.octopus.entity.GoodsTypeDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author jason
 * @email 1626883728@qq.com
 * @date 2019-12-05 17:07:47
 */
@Mapper
public interface GoodsTypeDao {

	GoodsTypeDO get(Long id);
	
	List<GoodsTypeDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(GoodsTypeDO goodsType);
	
	int update(GoodsTypeDO goodsType);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
