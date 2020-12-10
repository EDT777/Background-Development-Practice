package com.edt.spring.anno_proxy.cglib_proxy.tx;

public class MyTransactionManager {
    public void begin(){
        System.out.println("开启事务1");
        System.out.println("开启事务2");
        System.out.println("开启事务3");
    }
    public void rollback(){
        System.out.println("回滚事务1");
    }

    public void commit(){
        System.out.println("提交事务1");
        System.out.println("提交事务2");
        System.out.println("提交事务3");
    }
}
