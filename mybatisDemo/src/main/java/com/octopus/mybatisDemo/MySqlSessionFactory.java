package com.octopus.mybatisDemo;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 专门编写好sessionfactory的代码
 * 
 * @author hw
 *
 */
public class MySqlSessionFactory {
	private static volatile SqlSessionFactory factory;

	static {
		// 初始化
		// 第一步:创建SqlSessionFactoryBuilder类
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		// 第二步:使用Builder创建SqlSessionFactory
		InputStream is = TestMyBatis.class.getResourceAsStream("/mybatis-config.xml");
		factory = builder.build(is);
	}

	public static SqlSession openSession() {
		return factory.openSession();
	}
}
