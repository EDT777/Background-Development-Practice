package com.edt.mybatis_demo.mapper;

import com.edt.mybatis_demo.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//类似于DAO 接口
public interface UserMapper {
    void  save(User user);
    void delete(Long id);
    void update(User user);
    User get(Long id);
    List<User> listAll();
    //本质底层就帮你创建 Map key 注解的值 value实参
    User login(@Param("username") String username, @Param("password") String password);

    User query1(String username);
    User query2(@Param("username") String username);
}
