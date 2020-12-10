package com.edt.spring.anno_proxy.cglib_proxy.service.impl;

//真实类 真实对象
public class EmployeeServiceImpl2  {


    public void save(String username, String password) {
        System.out.println("保存了:"+username+":"+password);
    }
}
