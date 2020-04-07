package com.octopus.springdemo.code;
/**
 * spring beanfactory中的bean的作用域
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.octopus.springdemo.beans.JavaBean1;
import com.octopus.springdemo.beans.JavaBean2;
//获取bean的几种方式
public class TestSpring2 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-scope.xml");
		 JavaBean2 bean2 =  context.getBean(JavaBean2.class);
		 System.out.println(bean2);
		 JavaBean2 bean3 =  context.getBean(JavaBean2.class);
		 System.out.println(bean3);
		 //默认是单例的
		 System.out.println(bean2==bean3);
	}
}
