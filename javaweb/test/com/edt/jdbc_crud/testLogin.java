package com.edt.jdbc_crud;

import com.edt.jdbc_crud.util.DruidUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.*;

public class testLogin {
    @Test
    public void testStatement() throws SQLException {
        String name ="吴亦凡";
        BigDecimal salary =new BigDecimal(111);
        Connection con = DruidUtils.getConnection();
        Statement st =con.createStatement();//创建先不放sql语句进去
        String sql ="select * from user where name='"+name+"' and salary="+salary;
        ResultSet rs =st.executeQuery( sql);
        if(rs.next()){
            System.out.println("登陆成功");
        }else {
            System.out.println("登陆失败");
        }


    }
    @Test
    public void testPreparedStatement() throws SQLException {
        String name ="吴亦凡";
        BigDecimal salary =new BigDecimal(111);
        String sql ="select * from user where name =? and salary=?";
            Connection con =DruidUtils.getConnection();
        PreparedStatement pst =con.prepareStatement(sql);//创建就放sql语句进去
        pst.setString(1,name);
        pst.setBigDecimal(2,salary);
        ResultSet rs = pst.executeQuery();
        if (rs.next()){
            System.out.println("登陆成功");
        }else {
            System.out.println("登陆失败");
        }
    }
}
