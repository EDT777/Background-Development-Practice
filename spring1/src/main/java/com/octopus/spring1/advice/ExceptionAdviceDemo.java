package com.octopus.spring1.advice;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class ExceptionAdviceDemo implements ThrowsAdvice {
	public void afterThrowing(Method method, Object[] args, Object target,Exception ex) throws Throwable {
		System.out.println("异常通知:"+method.getName()+",异常的类型为:"+ ex.getClass());
		
	}
}
