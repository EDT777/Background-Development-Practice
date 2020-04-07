package com.octopus.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//专门负责生产sqlseesion方便实现数据操作
public class MybatisSqlSessionFatory {
		private static SqlSessionFactory factory;
		static {
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			factory = builder.build( MybatisSqlSessionFatory.class.getResourceAsStream("/mybatis.xml"));
		}
		
		public static SqlSession openSession() {
			return factory.openSession();
		}
		
}
