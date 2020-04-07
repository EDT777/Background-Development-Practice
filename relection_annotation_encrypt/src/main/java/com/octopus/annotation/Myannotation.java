package com.octopus.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//如何演示自定义注解
@Retention(RetentionPolicy.RUNTIME)//注解会一直传递到对象实例化到虚拟机，source:仅在源代码可见，编译后就没了。Class:在类中可见，运行后不见
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface Myannotation {
	String name();//注解的属性
	int id();
}
