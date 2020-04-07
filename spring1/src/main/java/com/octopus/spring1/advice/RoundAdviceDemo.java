package com.octopus.spring1.advice;

import java.sql.SQLException;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class RoundAdviceDemo implements MethodInterceptor {

	/**
	 * 将方法的执行委托给你这个拦截器： 1、可以决定是否真正执行这个方法 2、可以在方法调用前和调用后都处理
	 */
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String methodName = invocation.getMethod().getName();
		// 真实方法执行之前的操作
		System.out.println("方法" + methodName + "执行之前");
		// 真正被代理的方法的执行
		long time = System.currentTimeMillis();
		Object result = invocation.proceed();
		long time2 = System.currentTimeMillis() - time;
		// 方法执行后被执行代码
		System.out.println("方法" + methodName + "执行之后,共花时间："+time2+"ms");
		return result;
	}

}
