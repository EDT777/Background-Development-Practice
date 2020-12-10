package com.edt.spring;

import com.edt.spring.aop.mapper.AccountMapper;
import com.edt.spring.aop.service.AopService;
import com.edt.spring.aop.service.IAccountService;
import com.edt.spring.aop.service.impl.AopServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)//在测试类的测试方法执行之前启动 Spring 容器
@ContextConfiguration("classpath:spring/aop.xml")
public class aopTest {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private AopService aopService;

    @Test
    public void test(){
            aopService.save("EDT777","123");
    }

     @Test
     public void testAddBalance(){
        accountMapper.addBalance(1L, BigDecimal.TEN);
     }

     @Test
     public void testTransfer(){
       accountService.transfer(1L,2L,new BigDecimal("1000"));
     }
}
