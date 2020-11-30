package com.edt.webcrud_product.web.listener;

import com.edt.webcrud_product.dao.IUserDao;
import com.edt.webcrud_product.dao.impl.UserDaoImpl;
import com.edt.webcrud_product.domain.User2;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class CreateSuperUserListener implements ServletContextListener {
        private IUserDao userDao = new UserDaoImpl();
    //    ServletContext 的对象被创建的时候会执行下面的方法
    //tomcat 重启的时候
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println(servletContextEvent);
        if (userDao.checkUserByUsername("ADMIN")==null){
        User2 user = new User2();
        user.setUsername("ADMIN");
        user.setPassword("123");
        userDao.insert(user);
        }
    }

    @Override// ServletContext 的对象被销毁的时候会执行下面的方法
    //tomcat 关闭的时候
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
