package com.edt.mybatis_crud.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
    private  static SqlSessionFactory sqlSessionFactory ;
    static {
        try {
             sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static  SqlSession openSession(){
        return sqlSessionFactory.openSession();
    }
}
