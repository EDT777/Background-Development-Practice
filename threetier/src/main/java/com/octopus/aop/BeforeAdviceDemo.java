package com.octopus.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

@Component
public class BeforeAdviceDemo implements MethodBeforeAdvice{
	/*
	 * 该方法决定了JoinPoint为方法执行前
	 */
	
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		
		System.out.println("BeforeAdvice方法:"+method.getName()+"被执行");
	}

}
