package com.edt.mybatis_crud.dao.impl;

import com.edt.mybatis_crud.dao.IUserDao;
import com.edt.mybatis_crud.domain.User;
import com.edt.mybatis_crud.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserDaoImpl implements IUserDao {

    @Override
    public void insert(User user) throws IOException {
        try {
            //读取配置文件 Resources.getResourceAsStream获取配置文件也可以
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("mybatis-config.xml");
            //构建出SqlSessionFactory 工厂对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            //获取session对象
            SqlSession session = factory.openSession();
            //执行sql语句
            session.insert("com.edt.mybatis_crud.mapper.UserMapper.insert", user);
            //提交事务
            session.commit();
            //释放资源
            session.close();
            //获取生成的主键值
            System.out.println(user.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Long id) {

        SqlSession session = MybatisUtil.openSession();
        session.delete("com.edt.mybatis_crud.mapper.UserMapper.delete", id);
        session.commit();
        session.close();

    }

    @Override
    public void update(User user) {
        SqlSession session = MybatisUtil.openSession();
        session.update("com.edt.mybatis_crud.mapper.UserMapper.update", user);
        session.commit();
        session.close();

    }

    @Override
    public User selectOne(Long id) {
        User user = null;
        SqlSession session = MybatisUtil.openSession();
        user = session.selectOne("com.edt.mybatis_crud.mapper.UserMapper.selectOne", id);
        session.commit();
        session.close();
        return user;
    }

    @Override
    public List<User> selectList() {
        SqlSession session = MybatisUtil.openSession();
        List<User> list = session.selectList("com.edt.mybatis_crud.mapper.UserMapper.selectList");
        session.commit();
        session.close();
        return list;
    }
}
