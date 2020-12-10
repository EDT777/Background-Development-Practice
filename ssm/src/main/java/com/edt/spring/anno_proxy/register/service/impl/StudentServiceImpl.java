package com.edt.spring.anno_proxy.register.service.impl;

import com.edt.spring.anno_proxy.register.dao.IStudentDao;
import com.edt.spring.anno_proxy.register.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {

    private IStudentDao studentDao;
    @Autowired
    public void setStudentDao(IStudentDao studentDao){
        this.studentDao = studentDao;
    }
    @Override
    public void register(String username, String password) throws Exception {
        studentDao.save(username,password);

    }
}
