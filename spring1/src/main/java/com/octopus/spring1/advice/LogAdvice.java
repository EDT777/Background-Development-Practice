package com.octopus.spring1.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/**
 * 璁板綍鏂规硶琚皟鐢ㄧ殑鎯呭喌锛氫粈涔堟柟娉曡璋冪敤锛屾柟娉曠殑鎵ц缁撴灉
 * AfterReturningAdvice鍐冲畾浜嗘垜浠殑鎺ュ彛涓殑瑙勫畾鏂规硶浼氬湪琚唬鐞嗗璞＄殑鏌愪釜鏂规硶鎵ц鍚庤皟鐢�
 * @author hw
 *
 */
public class LogAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("方法"+method.getName()+"被调用，返回值:"+returnValue);
		
	}

}
