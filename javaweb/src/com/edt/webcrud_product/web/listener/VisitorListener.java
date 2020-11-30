package com.edt.webcrud_product.web.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.xml.transform.Source;

@WebListener
public class VisitorListener implements HttpSessionListener {
    private static int count = 0;

    @Override//当 session对象被创建的时候
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        count++;
        System.out.println("访问的游客量:" + count);
    }

    @Override//当 session对象被销毁的时候
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        count--;

    }
}
