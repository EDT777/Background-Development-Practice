package com.edt.webcrud_product.service;

import com.edt.webcrud_product.domain.User2;

public interface IUserService {
    public User2 checkUser(String username, String password);

    void updateHeadImg(User2 user);
}
