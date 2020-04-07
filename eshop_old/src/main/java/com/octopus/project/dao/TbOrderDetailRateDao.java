package com.octopus.project.dao;

import com.octopus.project.domain.TbOrderDetailRateDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 订单详情
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
@Mapper
public interface TbOrderDetailRateDao {

	TbOrderDetailRateDO get(Long id);
	
	List<TbOrderDetailRateDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(TbOrderDetailRateDO tbOrderDetailRate);
	
	int update(TbOrderDetailRateDO tbOrderDetailRate);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
