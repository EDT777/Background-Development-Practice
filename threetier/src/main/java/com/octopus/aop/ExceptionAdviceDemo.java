package com.octopus.aop;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;
@Component
public class ExceptionAdviceDemo implements ThrowsAdvice{
	public void afterThrowing(Method method,Object[] args,Object target,Exception ex) {
		System.out.println("异常通知:异常信息为："+ex.getMessage());
	}
}
