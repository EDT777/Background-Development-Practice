package com.octopus.mybatisDemo;

import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.octopus.mybatisDemo.entity.UserInfo;

public class TestMyBatis {
	public static void main(String[] args) {
		//第一步:创建SqlSessionFactoryBuilder类
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		//第二步:使用Builder创建SqlSessionFactory
		InputStream is = TestMyBatis.class.getResourceAsStream("/mybatis-config.xml");
		SqlSessionFactory factory = builder.build(is);
		//第三步:使用factory创建SqlSession
		SqlSession session = factory.openSession();//这就是一个连接，对标java.sql.Connection
		//第四步:使用SqlSession实现数据操作
		//4-1 尝试查询多条数据
//		List<LinkedHashMap<String, Object>> list = session//参数是查询的id，而且是全称
//				.selectList("com.octopus.mybatisDemo.mapper.CommonMapper.selectBySql");
//		List<LinkedHashMap<String, Object>> list = session//参数是查询的id，而且是全称
//				.selectList("com.octopus.mybatisDemo.mapper.CommonMapper.selectBySql","select * from user_info");
//		System.out.println(list);
		
		List<UserInfo> users = session.selectList("com.octopus.mybatisDemo.mapper.CommonMapper.selectUserBySql");
		System.out.println(users);
		//第五步:关闭session
		session.close();
		
	}
}
