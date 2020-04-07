package com.octopus.project.service;

import com.octopus.project.domain.TbOrderLogisticsDO;

import java.util.List;
import java.util.Map;

/**
 * 订单物流信息
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public interface TbOrderLogisticsService {
	
	TbOrderLogisticsDO get(Long id);
	
	List<TbOrderLogisticsDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TbOrderLogisticsDO tbOrderLogistics);
	
	int update(TbOrderLogisticsDO tbOrderLogistics);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
