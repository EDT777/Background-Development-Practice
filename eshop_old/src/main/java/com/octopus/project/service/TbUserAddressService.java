package com.octopus.project.service;

import com.octopus.project.domain.TbUserAddressDO;

import java.util.List;
import java.util.Map;

/**
 * 购物车项目
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public interface TbUserAddressService {
	
	TbUserAddressDO get(Long id);
	
	List<TbUserAddressDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TbUserAddressDO tbUserAddress);
	
	int update(TbUserAddressDO tbUserAddress);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
