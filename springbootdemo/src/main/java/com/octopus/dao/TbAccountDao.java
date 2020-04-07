package com.octopus.dao;

import com.octopus.entity.TbAccountDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author jason
 * @email 1626883728@qq.com
 * @date 2019-12-17 18:31:57
 */
@Mapper
public interface TbAccountDao {

	TbAccountDO get(Long id);
	
	List<TbAccountDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(TbAccountDO tbAccount);
	
	int update(TbAccountDO tbAccount);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
