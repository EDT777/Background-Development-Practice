package com.edt.jdbc_crud.test;

import com.edt.jdbc_crud.dao.IStudentDao;
import com.edt.jdbc_crud.dao.impl.StudentDaoImpl;
import com.edt.jdbc_crud.domain.Student;
import org.junit.Test;

import java.util.List;

public class StudentDaoTest {
private IStudentDao studentDao =new StudentDaoImpl();
    @Test
    public void insert() {
        Student stu =new Student("特朗普ads",22,"1445417290@qq.com");
        studentDao.insert(stu);
    }

    @Test
    public void update() {
        Student stu =new Student(6L,"a吴亦凡",22,"1445417290@qq.com");
        studentDao.update(stu);
    }

    @Test
    public void delete() {
        studentDao.delete(7L);
    }

    @Test
    public void query() {
        System.out.println( studentDao.query(7L));

    }

    @Test
    public void queryAll() {
        List<Student> list =studentDao.queryAll();
        System.out.println(list);

    }
}