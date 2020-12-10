package com.edt.spring.anno_proxy.jdk_proxy.handler;

import com.edt.spring.anno_proxy.jdk_proxy.tx.MyTransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TransactionInvocationHandler implements InvocationHandler {
    //真实对象的引用
    private Object target;
    public void setTarget(Object target){
        this.target = target;
    }
    public Object getTarget(){
        return this.target;
    }
    private MyTransactionManager tx;

    public void setTx(MyTransactionManager tx){
        this.tx = tx;
    }
    //   下面方法就开发者自己自定义,调用代理对象的方法,最终执行下面这个方法
//   虽然代理对象不能改,但我们发现调用代理对象的很多方法都会执行下面方法
//    事务操作写在这里,把调用真实对象的代码也写这里
    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        System.out.println("到此一游");

        Object retValue = null;
//        反射调用真实对象的方法
        try {
            tx.begin();
            retValue = method.invoke(target, args);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retValue;
    }
}
