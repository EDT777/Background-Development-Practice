package com.octopus.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.octopus.biz.GoodsBiz;
import com.octopus.biz.impl.GoodsBizImpl;
import com.octopus.entiy.Goods;
import com.octopus.entiy.javaBean2;

public class testSpring3 {
	public static void main(String[] args) {
		// 创建管家对象并让其读取指定配置文件
		BeanFactory factory = new ClassPathXmlApplicationContext("beans2.xml");

		GoodsBizImpl biz =factory.getBean(GoodsBizImpl.class);
		System.out.println(biz.getGoodsDao());
	}
}
