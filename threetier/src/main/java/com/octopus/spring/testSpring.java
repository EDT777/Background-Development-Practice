package com.octopus.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.octopus.entiy.Goods;

public class testSpring {
	public static void main(String[] args) {
		// 创建管家对象并让其读取指定配置文件
		BeanFactory factory = new ClassPathXmlApplicationContext("beans.xml");
		// 找管家要人
		 Goods g =(Goods)factory.getBean("goods1");//你帮我找一个叫做Good1的人
		//实际项目中逻辑对象大部分都是单例的(往往也是无状态的)
		// Goods g = factory.getBean(Goods.class);//你帮我找一个goods类型的人，前提是必须只有一个
		//Goods g = factory.getBean("good1", Goods.class);// 你帮我找一个goods类型的名字叫goods1的bean

		System.out.println(g);
		//有时候我们需要的对象是多利的，spring创建bean时默认是单例的(每一个bean的定义只会返回一个对象)
		Goods g1 = (Goods) factory.getBean("goods1");
		System.out.println(g==g1);
		
		//测试scope="prototype"
		Goods g3 =(Goods) factory.getBean("goods2");
		Goods g4 =(Goods) factory.getBean("goods2");
		System.out.println(g3==g4);
		//有的对象的属性可能是一个数组或者集合
	}
}
