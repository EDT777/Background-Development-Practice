package com.octopus.project.dao;

import com.octopus.project.domain.SysFileDO;

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
public interface SysFileDao {

	SysFileDO get(Long id);
	
	List<SysFileDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(SysFileDO sysFile);
	
	int update(SysFileDO sysFile);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
