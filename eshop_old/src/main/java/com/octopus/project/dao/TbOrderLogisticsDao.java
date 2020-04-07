package com.octopus.project.dao;

import com.octopus.project.domain.TbOrderLogisticsDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 订单物流信息
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
@Mapper
public interface TbOrderLogisticsDao {

	TbOrderLogisticsDO get(Long id);
	
	List<TbOrderLogisticsDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(TbOrderLogisticsDO tbOrderLogistics);
	
	int update(TbOrderLogisticsDO tbOrderLogistics);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
