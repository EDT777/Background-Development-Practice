package com.edt.spring.ioc_di.register.service.impl;

import com.edt.spring.ioc_di.register.dao.IStudentDao;
import com.edt.spring.ioc_di.register.service.IStudentService;

public class StudentServiceImpl implements IStudentService {

    private IStudentDao studentDao;

    public void setStudentDao(IStudentDao studentDao){
        this.studentDao = studentDao;
    }
    @Override
    public void register(String username, String password) throws Exception {
        studentDao.save(username,password);

    }
}
