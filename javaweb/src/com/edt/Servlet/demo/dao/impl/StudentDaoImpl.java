package com.edt.Servlet.demo.dao.impl;

import com.edt.Servlet.demo.dao.IStudentDao;
import com.edt.Servlet.demo.domain.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;

public class StudentDaoImpl implements IStudentDao {
    @Override
    public void insert(Student stu) {
        SqlSession session = new SqlSessionFactoryBuilder().build(Thread.currentThread().getContextClassLoader().getResourceAsStream("mybatis-config.xml")).openSession();
        session.insert("com.edt.Servlet.demo.StudentMapper.insert", stu);
        session.commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        SqlSession session = new SqlSessionFactoryBuilder().build(Thread.currentThread().getContextClassLoader().getResourceAsStream("mybatis-config.xml")).openSession();
        session.delete("com.edt.Servlet.demo.StudentMapper.delete", id);
        session.commit();
        session.close();
    }

    @Override
    public void update(Student stu) {
        SqlSession session = new SqlSessionFactoryBuilder().build(Thread.currentThread().getContextClassLoader().getResourceAsStream("mybatis-config.xml")).openSession();
        session.update("com.edt.Servlet.demo.StudentMapper.update", stu);
        session.commit();
        session.close();
    }

    @Override
    public Student select(Long id) {
        Student student = null;
        SqlSession session = new SqlSessionFactoryBuilder().build(Thread.currentThread().getContextClassLoader().getResourceAsStream("mybatis-config.xml")).openSession();
        student = session.selectOne("com.edt.Servlet.demo.StudentMapper.select", id);
        session.commit();
        session.close();
        return student;
    }

    @Override
    public List<Student> selectAll() {
        List<Student> list = null;
        SqlSession session = new SqlSessionFactoryBuilder().build(Thread.currentThread().getContextClassLoader().getResourceAsStream("mybatis-config.xml")).openSession();
        list = session.selectList("com.edt.Servlet.demo.StudentMapper.selectAll");
        session.commit();
        session.close();
        return list;
    }
}
