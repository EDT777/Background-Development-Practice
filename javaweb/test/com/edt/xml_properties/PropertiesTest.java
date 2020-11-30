package com.edt.xml_properties;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest {

    @Test
    public void testProperties() throws IOException {//直接用此项目resources下路径获取properties
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        InputStream is = cl.getResourceAsStream("user.properties");
        Properties p = new Properties();
        p.load(is);
        System.out.println("username: " + p.getProperty("username"));
        System.out.println("password: " + p.getProperty("password"));
    }

    @Test
    public void testProperties2() throws IOException {//绝对路径方式获取properties
        Properties p =new Properties();
        p.load(new FileInputStream("D:\\IDEA-Project\\javaweb\\resources\\user.properties"));
        System.out.printf("username:"+p.getProperty("username")+"     password:"+p.getProperty("password"));
    }


}
