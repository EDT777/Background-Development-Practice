package com.octopus.relection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

//反射2，获取一个类的方法或者属性信息
public class Test2 {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException {
		Class<?> stuClass1 = Student.class;
		// 得到属性的信息
		// Field fieldId = stuClass1.getField("id");//获取公共属性
		Field fieldId = stuClass1.getDeclaredField("id");// 可以获得所有情况的属性
		System.out.println(fieldId);
		// 获取方法信息
		Method method1 = stuClass1.getMethod("showInfo");// 代表获取无参数的叫做showInfo的方法
		Method method2 = stuClass1.getMethod("setName", String.class);
		Method method3 = stuClass1.getMethod("setId", int.class);
		Method method4 = stuClass1.getMethod("setId", Integer.TYPE);
		System.out.println(method1);
		System.out.println(method2);
		System.out.println(method3);
		System.out.println(method4);
		// 获取类实现的接口
		Class<?>[] interfaces = stuClass1.getInterfaces();
		for (Class<?> ifs : interfaces) {
			System.out.println(ifs);
		}
		// 能获取父类
		System.out.println(stuClass1.getSuperclass());
	}

}