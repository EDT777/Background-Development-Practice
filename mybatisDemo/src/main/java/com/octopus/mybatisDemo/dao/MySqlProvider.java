package com.octopus.mybatisDemo.dao;

import java.util.Map;

/**
 * 演示SqlProvider的使用：使用Java代码构建复杂的查询语句
 * @author hw
 *
 */
public class MySqlProvider {
	
	
	public String buildSqlDemo(Map<String,Object> params) {
		StringBuffer sql = new StringBuffer("select * from goods where 1=1 ");
		if(params.containsKey("name")) {
			params.put("name", "%"+params.get("name")+"%");
			sql.append(" and name like #{name}");
		}
		if(params.containsKey("startDate")) {
			sql.append(" and up_time > #{startDate}");
		}
		//......
		return sql.toString();
	}
}
