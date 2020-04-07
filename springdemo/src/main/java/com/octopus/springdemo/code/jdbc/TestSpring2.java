package com.octopus.springdemo.code.jdbc;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.octopus.springdemo.beans.JavaBean1;
//jdbcTemplate的功能
public class TestSpring2 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserDao userDao =   (UserDao) context.getBean(UserDaoImpl.class);
		UserInfo userInfo =userDao.findById(1L);
		System.out.println(userInfo);
		
		List<UserInfo> users = userDao.findAll();
		System.out.println(users);
		
		UserInfo user = new UserInfo();
		user.setUserBirthday(new Date());
		user.setUserDelete(0);
		user.setUserName("spring-jdbc添加数据");
		user.setUserPoint(0);
		user.setUserPwd("000000");
		user.setUserStatus(0);
		int n =userDao.insert(user);
		System.out.println("添加返回值为:"+n+",新得到的id为："+user.getId());
		
	}
}


