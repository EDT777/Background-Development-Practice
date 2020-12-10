package com.edt.spring.ioc_di;

public class MyDataSource {

    public MyDataSource(){
        System.out.println("对象创建了");
    }
    public void init(){
        System.out.println("池中连接对象都创建好了,初始化操作");
    }
    public void getConnection(){
        System.out.println("连接对象给你了");
    }

    public void close(){
        System.out.println("池中连接对象都销毁了");
    }
}
