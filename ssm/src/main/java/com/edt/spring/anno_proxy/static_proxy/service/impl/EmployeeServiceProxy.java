package com.edt.spring.anno_proxy.static_proxy.service.impl;

import com.edt.spring.anno_proxy.static_proxy.service.IEmployeeService;
import com.edt.spring.anno_proxy.static_proxy.tx.MyTransactionManager;

//代理类 代理对象 中介
public class EmployeeServiceProxy implements IEmployeeService {
    //   存在真实对象引用
    private IEmployeeService target;

    public void setTarget(IEmployeeService target) {
        this.target = target;
    }
//创建事务管理对象
    private MyTransactionManager tx;
    public void setTx(MyTransactionManager myTransactionManager){
        this.tx = myTransactionManager;
    }
    @Override
    public void save(String username, String password) {
            try {
                tx.begin();
                target.save(username,password);
                tx.commit();
            }catch (Exception e){
                tx.rollback();
            }
    }
}
