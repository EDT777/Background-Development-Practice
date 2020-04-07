package com.octopus.project.dao;

import com.octopus.project.domain.TbOrderInfoDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
@Mapper
public interface TbOrderInfoDao {

	TbOrderInfoDO get(Long id);
	
	List<TbOrderInfoDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(TbOrderInfoDO tbOrderInfo);
	
	int update(TbOrderInfoDO tbOrderInfo);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
