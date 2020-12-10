package com.edt.spring;

import com.edt.spring.anno_proxy.Person;
import com.edt.spring.anno_proxy.cglib_proxy.handler.TransactionInvocationHandler2;
import com.edt.spring.anno_proxy.cglib_proxy.service.impl.EmployeeServiceImpl2;
import com.edt.spring.anno_proxy.jdk_proxy.handler.TransactionInvocationHandler;
import com.edt.spring.anno_proxy.register.service.impl.StudentServiceImpl;
import com.edt.spring.anno_proxy.static_proxy.service.IEmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Proxy;

@RunWith(SpringJUnit4ClassRunner.class)//在测试类的测试方法执行之前启动 Spring 容器
@ContextConfiguration("classpath:spring/anno_proxy.xml")
public class anno_proxy_Test {
    @Autowired
    private Person person;
    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    @Qualifier("proxy")
    private IEmployeeService proxy;
    @Autowired
    private TransactionInvocationHandler transactionInvocationHandler;
    @Autowired
    private TransactionInvocationHandler2 transactionInvocationHandler2;
    @Test
    public void test() {
        System.out.println(person);
    }

    @Test
    public void testRegister() throws Exception {
        studentService.register("啊啊啊", "123");
    }

    @Test
    public void testStaticProxy() {
        proxy.save("a周杰伦", "123");
    }

    @Test
    public void testDynamicProxy() {
//        下面方法执行的返回结果是生成代理类的对象
        com.edt.spring.anno_proxy.jdk_proxy.service.IEmployeeService proxy = (com.edt.spring.anno_proxy.jdk_proxy.service.IEmployeeService)
                Proxy.newProxyInstance(
                this.getClass().getClassLoader(),//类加载器
                transactionInvocationHandler.getTarget().getClass().getInterfaces(),//生成代理类实现的接口
                transactionInvocationHandler
        );
//调用代理对象的 toString 方法
        proxy.save("蔡徐坤123123","123");
    }

 @Test
 public void testCglib(){
     Enhancer enhancer = new Enhancer();
     enhancer.setCallback(transactionInvocationHandler2);
     enhancer.setSuperclass(transactionInvocationHandler2.getTarget().getClass());
//     创建代理类,并创建这个代理类对象返回
     EmployeeServiceImpl2 object = (EmployeeServiceImpl2) enhancer.create();

     object.save("海尔兄弟","6666");
 }
}
