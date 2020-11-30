package com.edt.Servlet;


import com.edt.Servlet.demo.dao.IStudentDao;
import com.edt.Servlet.demo.dao.impl.StudentDaoImpl;
import com.edt.Servlet.demo.domain.Student;
import org.junit.Test;


public class StudentImplTest {
IStudentDao studentDao = new StudentDaoImpl();

    @Test
    public void insert() {
        Student stu = new Student(null,"谭泽豪4","男",99.0);
        studentDao.insert(stu);
    }

    @Test
    public void delete() {
        studentDao.delete(6L);
    }

    @Test
    public void update() {
        Student stu = new Student(7L,44L,"71谭泽豪78","男",99.0);
        studentDao.update(stu );
    }

    @Test
    public void select() {
        System.out.println(studentDao.select(1L));
    }

    @Test
    public void selectAll() {
        System.out.println(studentDao.selectAll());
    }
}
