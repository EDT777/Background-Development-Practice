package com.octopus.mybatisDemo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.octopus.mybatisDemo.dao.UserInfoDao;
import com.octopus.mybatisDemo.entity.UserInfo;

public class Test2 {
	public static void main(String[] args) {
		SqlSession session = MySqlSessionFactory.openSession();
		UserInfoDao userInfoDao = session.getMapper(UserInfoDao.class);// 得到了一个由mybatis自动创建的dao接口的实现类
		List<UserInfo> users = userInfoDao.findAllUsers();
//		String insertSQL = "insert into user_info (user_name,user_pwd) values('mybatis测试','000000')";
//		int result = userInfoDao.insert(insertSQL);
//		session.commit();
//		System.out.println("添加影响的行数为:" + result);
		System.out.println(users);
		session.close();
	}
}
