package com.edt.jdbc_crud.dao.impl;

import com.edt.jdbc_crud.dao.IStudentDao;
import com.edt.jdbc_crud.domain.Student;
import com.edt.jdbc_crud.util.DruidUtils;
import com.edt.jdbc_crud.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements IStudentDao {

    //   statement用法演示
//    public void insert(Student stu) {
//        Connection con=null;
//        Statement statement=null;
//        String sql ="insert into t_student (name,age,email) values ('"+ stu.getName()+"','"+stu.getAge()+"','"+stu.getEmail()+"')";
//            try {
//                Class.forName("com.mysql.cj.jdbc.Driver");
//                 con = DriverManager.getConnection("jdbc:mysql:///jdbcdemo?serverTimezone=GMT%2B8",
//                        "root","19980220");
//                 statement =con.createStatement();
//statement.execute(sql);
//            }catch (Exception e){
//                e.printStackTrace();
//            }finally {
//                try {
//                    con.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }finally {
//                    try {
//                        statement.close();
//                    } catch (SQLException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//     }
    //增
    public void insert(Student stu) {//preparedStatement 用法演示
        Connection con = null;
        PreparedStatement pst = null;
        String sql = "insert into t_student (name,age,email) values ( ?,?,?)";
        try {

            con = JDBCUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, stu.getName());
            pst.setInt(2, stu.getAge());
            pst.setString(3, stu.getEmail());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(con, pst, null);
        }
    }

//改
    @Override
    public void update(Student stu) {
        Connection con = null;
        PreparedStatement pst = null;
        String sql = "update t_student set name=?,age=?,email=? where id =?";
        try {
            con = JDBCUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, stu.getName());
            pst.setInt(2, stu.getAge());
            pst.setString(3, stu.getEmail());
            pst.setLong(4, stu.getId());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           JDBCUtil.close(con,pst,null);
        }
    }

    //删
    @Override
    public void delete(Long id) {
        Connection con = null;
        PreparedStatement pst = null;
        String sql = "delete from t_student where id=?";
        try {
            con = JDBCUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setLong(1, id);

            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
//查
    @Override
    public Student query(Long id) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DruidUtils.getConnection();
            String sql = "select * from t_student where id = ?";
            pst = con.prepareStatement(sql);
            pst.setLong(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                long idd = rs.getLong("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int age = rs.getInt("age");
                return new Student(idd, name, age, email);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(con,pst,rs);
        }
        return null;
    }

//查多
    public List<Student> queryAll() {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Student> list = new ArrayList<>();
        try {
            con = JDBCUtil.getConnection();
            String sql = "select * from t_student ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                long idd = rs.getLong("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int age = rs.getInt("age");
                Student stu = new Student(idd, name, age, email);
                list.add(stu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(con,pst,rs);
        }


        return list;
    }
}
