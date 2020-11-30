package com.edt.jdbc_crud.util;


import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    private static Properties p = new Properties();


    static {

        try {
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
            p.load(is);
            Class.forName(p.getProperty("driverClassName"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() {  //获取连接对象
        try {
            return DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"), p.getProperty("password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //释放资源方法
    public static void close(Connection con, Statement se, ResultSet rs) {
        if (se != null) {
            try {
                se.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
