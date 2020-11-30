package com.edt.webcrud_product.dao.impl;

import com.edt.webcrud_product.dao.IUserDao;
import com.edt.webcrud_product.domain.User2;
import com.edt.webcrud_product.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class UserDaoImpl implements IUserDao {
    @Override
    public User2 checkUser2(User2 user2) {
        SqlSession session = MybatisUtil.openSession();
        User2 user22 =  session.selectOne("com.edt.webcrud_product.mapper.User2Mapper.checkUser2",user2);
       session.commit();
        session.close();
        return user22;
    }

    @Override
    public User2 checkUserByUsername(String username) {
        SqlSession session = MybatisUtil.openSession();
        User2 user22 =  session.selectOne("com.edt.webcrud_product.mapper.User2Mapper.checkUserByUsername",username);
        session.commit();
        session.close();
        return user22;
    }

    @Override
    public void updateHeadImg(User2 user) {
        SqlSession session = MybatisUtil.openSession();
        session.update("com.edt.webcrud_product.mapper.User2Mapper.updateHeadImg",user);
        session.commit();
        session.close();
    }

    @Override
    public void insert(User2 user) {
        SqlSession session = MybatisUtil.openSession();
        session.insert("com.edt.webcrud_product.mapper.User2Mapper.insert",user);
        session.commit();
        session.close();
    }
}
