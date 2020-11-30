package com.edt.mybatis_crud.dao;

import com.edt.mybatis_crud.domain.User;

import java.io.IOException;
import java.util.List;

public interface IUserDao {
    void insert(User user) throws IOException; //增

    void delete(Long id);//删

    void update(User user);//改

    User selectOne(Long id);//查

    List<User> selectList();//查所有
}
