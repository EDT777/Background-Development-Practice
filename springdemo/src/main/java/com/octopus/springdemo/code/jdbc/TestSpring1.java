package com.octopus.springdemo.code.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.octopus.springdemo.beans.JavaBean1;
//jdbcTemplate的功能
public class TestSpring1 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-jdbc.xml");
		JdbcTemplate template = context.getBean(JdbcTemplate.class);
		List<Map<String,Object>> list = template.queryForList("select * from user_info");
		System.out.println(list);
	}
}
