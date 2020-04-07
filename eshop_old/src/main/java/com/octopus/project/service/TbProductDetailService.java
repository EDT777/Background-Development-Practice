package com.octopus.project.service;

import com.octopus.project.domain.TbProductDetailDO;

import java.util.List;
import java.util.Map;

/**
 * 商品详情页
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public interface TbProductDetailService {
	
	TbProductDetailDO get(Long id);
	
	List<TbProductDetailDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TbProductDetailDO tbProductDetail);
	
	int update(TbProductDetailDO tbProductDetail);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
