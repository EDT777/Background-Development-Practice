package com.edt.jdbc_crud.dao;

import com.edt.jdbc_crud.domain.Student;

import java.util.List;

//增删改查
public interface IStudentDao {
    void insert(Student stu);
    void update(Student stu);
    void delete(Long id);
    Student query(Long id);
    List<Student> queryAll();
}
