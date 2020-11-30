package com.edt.mybatis_crud;

import com.edt.mybatis_crud.dao.IUserDao;
import com.edt.mybatis_crud.dao.impl.UserDaoImpl;
import com.edt.mybatis_crud.domain.User;
import org.junit.Test;


import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class UserDaoTest {

    private IUserDao userDao =new UserDaoImpl();

    @Test
    public void insert() throws IOException {
        User u =new User(null,"啊啊啊啊kk",2,new BigDecimal("211"));
        userDao.insert(u);
    }

    @Test
    public void delete() {
        userDao.delete(7L);
    }

    @Test
    public void update() {
        User u =new User(4L,"r谭泽豪",22,new BigDecimal("111"));
        userDao.update(u);
    }

    @Test
    public void selectOne() {
        User user = userDao.selectOne(2L);
        System.out.println(user);
    }

    @Test
    public void selectList() {
        List<User> list =userDao.selectList();
        for (User u : list){
            System.out.println(u);
        }
    }
}