package com.edt.spring.aop.service.impl;

import com.edt.spring.aop.service.AopService;
import org.springframework.stereotype.Component;

@Component
public class AopServiceImpl implements AopService {
    @Override
    public void save(String username, String password) {
        System.out.println("保存了"+username+"密码为:"+password);
    }
}
