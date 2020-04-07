package com.octopus.dao;

import com.octopus.entity.GoodsDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author jason
 * @email 1626883728@qq.com
 * @date 2019-12-05 17:07:40
 */
@Mapper
public interface GoodsDao {

	GoodsDO get(Long id);
	
	List<GoodsDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(GoodsDO goods);
	
	int update(GoodsDO goods);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
