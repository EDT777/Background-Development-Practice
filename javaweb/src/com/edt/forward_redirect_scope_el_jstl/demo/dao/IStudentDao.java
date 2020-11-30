package com.edt.forward_redirect_scope_el_jstl.demo.dao;

import com.edt.Servlet.demo.domain.Student;

import java.util.List;

public interface IStudentDao {

    void insert(Student stu);//增

    void delete(Long id);//删

    void update(Student stu);//改

    Student select(Long id); //查

    List<Student> selectAll();//查所有


}
