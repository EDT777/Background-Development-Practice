package com.octopus.aop.impl;

import org.springframework.stereotype.Service;

import com.octopus.aop.TestBiz;
@Service
public class TestBizImpl  implements TestBiz{

	public String targetTest1(String name) {
			System.out.println("targetTest1方法执行开始");
			return "hello,"+name;
			//throw new RuntimeException("这是测试异常");
	}

}
