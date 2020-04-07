package com.octopus.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

@Component
public class AfterAdviceDemo implements AfterReturningAdvice{

	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
			System.out.println("AfterAdvice 方法:"+method.getName()+"被执行,返回值是："+returnValue);
	}

}
