package com.octopus.project.dao;

import com.octopus.project.domain.TbOrderDetailDO;

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
public interface TbOrderDetailDao {

	TbOrderDetailDO get(Long id);
	
	List<TbOrderDetailDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(TbOrderDetailDO tbOrderDetail);
	
	int update(TbOrderDetailDO tbOrderDetail);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
