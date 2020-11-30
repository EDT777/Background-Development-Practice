package com.edt.webcrud_product.dao;

import com.edt.webcrud_product.domain.User2;

public interface IUserDao {
//    根据用户名和密码查询用户
    User2 checkUser2(User2 user2);
//    根据用户名查询用户
    User2 checkUserByUsername(String username);

    void updateHeadImg(User2 user);

    void insert(User2 user);
}
