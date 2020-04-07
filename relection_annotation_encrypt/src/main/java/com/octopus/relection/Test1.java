package com.octopus.relection;

public class Test1 {
public static void main(String[] args) {
	//获取一个类的信息是通过类的class属性或者其对象的getClass方法
	Class<?> stuClass1 = Student.class;
	Student stu = new Student();
	Class<?> stuClass2 =stu.getClass();
	//盲加载:我只需要知道类名
	Class<?> class3 =null;
	try {
		class3 =Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println(stuClass1);
	System.out.println(stuClass2);
	System.out.println(class3);
}
}
