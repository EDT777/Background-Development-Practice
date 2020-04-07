package com.octopus.springdemo.code;

/**
 * spring 注解使用
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//获取bean的几种方式
public class TestSpring3 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-annotation.xml");
		JavaBean1 bean1 = context.getBean(JavaBean1.class);
		System.out.println(bean1);

	}
}
