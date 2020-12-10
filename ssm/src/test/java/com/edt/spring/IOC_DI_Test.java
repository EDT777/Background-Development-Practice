package com.edt.spring;

import com.edt.spring.ioc_di.Cat1;
import com.edt.spring.ioc_di.Cat2FactoryBean;
import com.edt.spring.ioc_di.MyDataSource;
import com.edt.spring.ioc_di.Person;
import com.edt.spring.ioc_di.register.service.IStudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)//在测试类的测试方法执行之前启动 Spring 容器
@ContextConfiguration("classpath:spring/ioc_di.xml")
public class IOC_DI_Test {
    @Autowired //默认会根据类型到容器中找个对象设置给找个字段
    private Person person;
    @Autowired
    private Cat1 cat1;
    @Autowired
    private IStudentService studentService;
    @Autowired
    private MyDataSource myDataSource;

    @Test
    public void testDoWorkIoc() {
//      利用spring API 帮我们解析配置,创建容器对象,并把配置文件配置对象也创建出来,存在容器中
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:ioc_di.xml");
//        从容器中获取Person对象
//       Person person= (Person) ctx.getBean("person");
//       person.doWork();

        person.doWork();
    }

    @Test
    public void testCat() throws Exception {
//        首先创建工厂对象
        Cat2FactoryBean cat2FactoryBean = new Cat2FactoryBean();
//        调用工厂对象的方式
        System.out.println(cat2FactoryBean.getObject());
//现在用了Spring,我也希望spring 帮我们做这样,利用工厂类对象的方法帮我们创建工厂
    }

    @Test
    public void testIoc() {
        System.out.println(cat1);
    }

    @Test
    public void testMyDataSource() {
//        myDataSource.getConnection();
    }

    //使用IOC_DI 实现用户注册
    @Test
    public void testRegister() throws Exception {
        studentService.register("32谭泽豪23", "2666");
    }

}
