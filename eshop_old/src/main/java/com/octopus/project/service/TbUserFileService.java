package com.octopus.project.service;

import com.octopus.project.domain.TbUserFileDO;

import java.util.List;
import java.util.Map;

/**
 * 文件上传
 * 
 * @author Jason
 * @email 1626883728@qq.com
 * @date 2020-02-23 22:23:26
 */
public interface TbUserFileService {
	
	TbUserFileDO get(Long id);
	
	List<TbUserFileDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TbUserFileDO tbUserFile);
	
	int update(TbUserFileDO tbUserFile);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
