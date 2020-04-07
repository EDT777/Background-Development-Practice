package com.octopus.relection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//反射第三步:操作一个类的属性，方法
//实例方法和实例属性必须在一个具体的实例上操作
public class Test3 {
	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
		Class<?> stuClass1 = Class.forName("com.octopus.relection.Student");
		// 实例化对象
		Student stu = (Student) stuClass1.newInstance();
		// 操作属性：利用得到的Field作用于某个对象
		Field fieldId = stuClass1.getDeclaredField("id");
		fieldId.setAccessible(true);//强制将不能直接访问的属性设置为能访问
		fieldId.set(stu, 111);// 为某个对象(stu)的某个属性(fieldId)赋值给某个值(111)
		System.out.println("属性通过反射赋值后:" + stu);
		//方法传参数
		Method method2 = stuClass1.getMethod("setName", String.class);
		Object rtv =method2.invoke(stu, "张三");
		System.out.println("方法通过反射赋值后:" + stu);
		
	}
}
