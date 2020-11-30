package com.edt.jdbc_crud.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
//连接池工具
public class DruidUtils {
    private static DataSource ds ;
    static {
        try {
            Properties p =new Properties();
            p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
           ds= DruidDataSourceFactory.createDataSource(p);//连接池 只需要一个 所以放静态代码块里


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){


        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }
}
