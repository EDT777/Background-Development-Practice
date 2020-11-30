package com.edt.jdbc_crud;

import com.edt.jdbc_crud.util.JDBCUtil;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.*;

//事务演示 转账入账
public class TxTest {
    @Test
    public void tx() {
        Connection con = null;
        Statement st = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "select * from account where balance >? and name =?";
        try {

            con = JDBCUtil.getConnection();
            con.setAutoCommit(false);  //关闭事务自动提交
            pst = con.prepareStatement(sql);  // preparedStatement的方式
            pst.setBigDecimal(1, new BigDecimal("10000"));
            pst.setString(2, "小豪");
            rs = pst.executeQuery();
            if (!rs.next()) {
                System.out.println("小豪的约不足10000,不能进行转账");
                return;
            }
            //转账
            String sql2 = "update account set balance = balance -3000 where name = '小豪'";
            pst = con.prepareStatement(sql2);// preparedStatement的方式
            pst.executeUpdate();

            int a = 10 / 0;
            //收账
            String sql3 = "update account set balance = balance+3000 where name ='小红'";
            st = con.createStatement();// statement的方式
            st.executeUpdate(sql3);

            con.commit();//手动提交
        } catch (Exception e) {
            try {
                con.rollback(); //回滚事务
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } finally {
            JDBCUtil.close(con, pst, rs);

        }

    }

}
