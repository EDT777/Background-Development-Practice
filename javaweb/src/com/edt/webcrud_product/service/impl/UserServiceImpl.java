package com.edt.webcrud_product.service.impl;

import com.edt.webcrud_product.dao.IUserDao;
import com.edt.webcrud_product.dao.impl.UserDaoImpl;
import com.edt.webcrud_product.domain.User2;
import com.edt.webcrud_product.service.IUserService;

public class UserServiceImpl implements IUserService {
    private IUserDao userDao = new UserDaoImpl();
    @Override
    public User2 checkUser(String username, String password) {
//        先根基用户名查询User
         User2 user = userDao.checkUserByUsername(username);//判断用户名是否正确
        if (user==null){
            throw new RuntimeException("用户错误");
        }
        if (!user.getPassword().equals(password)){
          throw new RuntimeException("密码错误");
        }
        return user;
    }

    @Override
    public void updateHeadImg(User2 user) {
        userDao.updateHeadImg(user);
    }
}
