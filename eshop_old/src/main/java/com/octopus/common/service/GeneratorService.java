/**
 * 
 */
package com.octopus.common.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @author jason
 * @Time 2018年3月6日
 * @description
 * 
 */
@Service
public interface GeneratorService {
	List<Map<String, Object>> list();

	byte[] generatorCode(String[] tableNames);
	
	
	
	/**
	 * 肖文庆  
	 * 根据数据库表名  去查询  判断是否存在该表
	 * @param tableName
	 * @return
	 */
	boolean getTableName(@Param("tableName")String tableName);
}
