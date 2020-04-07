package com.octopus.springdemo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.octopus.springdemo.beans.JavaBean1;

public class TestSpring {
	public static void main(String[] args) {
		BeanFactory factory = null;// 对象工厂，也是容器
		ApplicationContext context = null;//应用上下文，是高级版的对象工厂
		context = new ClassPathXmlApplicationContext("beans.xml");//创建Spring的主容器
		//通过context获得被管理的对象
		JavaBean1 bean1 = (JavaBean1) context.getBean("bean1");
		System.out.println(bean1);
		
		JavaBean1 bean2 = (JavaBean1) context.getBean("bean2");
		System.out.println(bean2);
	}
}
