package com.octopus.dao;

import com.octopus.entity.OrderDetailDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 订单详情
 * @author jason
 * @email 1626883728@qq.com
 * @date 2019-12-05 17:07:52
 */
@Mapper
public interface OrderDetailDao {

	OrderDetailDO get(Long id);
	
	List<OrderDetailDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(OrderDetailDO orderDetail);
	
	int update(OrderDetailDO orderDetail);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
