package com.edt.spring.aop.tx;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyTransactionManager {
    @Pointcut("execution(* com.edt.spring.aop.service.impl.AopServiceImpl.*(..))")
    private void txPointcut(){

    }
    @Before("txPointcut()")
    public void begin(){
        System.out.println("开启事务");
    }
    @AfterReturning("txPointcut()")
    public void commit(){
        System.out.println("提交事务");
    }
    @AfterThrowing("txPointcut()")
    public void rollback(){
        System.out.println("回滚事务");
    }
}
