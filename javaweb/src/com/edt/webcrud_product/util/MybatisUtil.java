package com.edt.webcrud_product.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
//    返回SqlSession对象
     private static SqlSessionFactory factory;
     static {
         try {
             factory = new SqlSessionFactoryBuilder()
                     .build(Thread.currentThread().getContextClassLoader().getResourceAsStream("mybatis-config.xml"));
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
     public static SqlSession openSession(){
        return factory.openSession();
     }

    public static void main(String[] args) {
        System.out.println(MybatisUtil.openSession());
    }
}
