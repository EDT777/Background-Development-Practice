package com.octopus.annotation;

import java.lang.annotation.Annotation;

import com.octopus.relection.Student;

public class Test1 {
	public static void main(String[] args) {
			//如何通过反射读取注解
		Class<?> clazz =Student.class;
		Annotation[] annos =clazz.getAnnotations();
		for(Annotation a:annos) {
			System.out.println(a.annotationType().getName());
		}
		//读取注解的值
		Myannotation a =clazz.getAnnotation(Myannotation.class);
		System.out.println("注解的值"+a.name());
	}

	
}
