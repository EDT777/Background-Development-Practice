package com.octopus.project.service;

import com.octopus.project.domain.TbOrderInfoDO;

import java.util.List;
import java.util.Map;

/**
 * 订单
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public interface TbOrderInfoService {
	
	TbOrderInfoDO get(Long id);
	
	List<TbOrderInfoDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TbOrderInfoDO tbOrderInfo);
	
	int update(TbOrderInfoDO tbOrderInfo);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
