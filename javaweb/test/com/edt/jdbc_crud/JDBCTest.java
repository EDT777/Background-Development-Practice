package com.edt.jdbc_crud;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

    @Test
    public void testGetConnection() throws ClassNotFoundException, SQLException {
        //加载注册驱动
        Class.forName("com.mysql.jdbc.Driver"); //这里可以不加,但是web项目必须加
        //获取连接对象
        Connection con = DriverManager.getConnection("jdbc:mysql:///test?useSSL=false&characterEncoding=UTF-8", "root", "19980220");
        System.out.println(con);
    }
    @Test  //价廉欲执事
    public  void testInsert() throws ClassNotFoundException, SQLException {
        //插入一条记录
        Class.forName("com.mysql.jdbc.Driver");
        //获取连接对象
        Connection con =DriverManager.getConnection("jdbc:mysql:///test?characterEncoding=UTF-8&useSSL=false","root","19980220");
        //获取语句对象
        Statement statement = con.createStatement();
        String sql ="insert t_student (name,email,age)values('小豪','www.123.com',12)";
        //执行语句
        statement.execute(sql);
        //释放资源
        con.close();
        statement.close();
    }
}
