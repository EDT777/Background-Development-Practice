package com.octopus.project.dao;

import com.octopus.project.domain.TbProductImagesDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 文件上传
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
@Mapper
public interface TbProductImagesDao {

	TbProductImagesDO get(Long id);
	
	List<TbProductImagesDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(TbProductImagesDO tbProductImages);
	
	int update(TbProductImagesDO tbProductImages);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
