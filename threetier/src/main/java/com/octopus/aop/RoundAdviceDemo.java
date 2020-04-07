package com.octopus.aop;


import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;
@Component
public class RoundAdviceDemo implements MethodInterceptor{
	/**
	 * 动态代理机制包装
	 */
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("环绕通知中方法执行前的时间");
		//invocation参数的使用
		Method method = invocation.getMethod();//得到被执行得方法的信号
		Object[] params = invocation.getArguments();//方法接受的实参
		//真正的方法调用
		Object result = invocation.proceed();//被代理的对象实际方法的调用,result为方法的返回值
		//上述代码如果不执行，则实际被代理对象根本没执行
		
		
		//可以在方法之前执行代码
		//决定实际方法是否真的执行
		//可以在方法之后执行代码
		System.out.println("环绕通知中方法执行后的时间");
		
		return result;
	}	
			
}
