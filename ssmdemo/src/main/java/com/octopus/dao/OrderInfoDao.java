package com.octopus.dao;

import com.octopus.entity.OrderInfoDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * @author jason
 * @email 1626883728@qq.com
 * @date 2019-12-05 17:07:52
 */
@Mapper
public interface OrderInfoDao {

	OrderInfoDO get(Long id);
	
	List<OrderInfoDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(OrderInfoDO orderInfo);
	
	int update(OrderInfoDO orderInfo);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
