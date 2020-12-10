package com.edt.spring.anno_proxy.static_proxy.service.impl;

import com.edt.spring.anno_proxy.static_proxy.service.IEmployeeService;
//真实类 真实对象
public class EmployeeServiceImpl implements IEmployeeService {


    @Override //业务
    public void save(String username, String password) {
        System.out.println("保存了:"+username+":"+password);
    }
}
