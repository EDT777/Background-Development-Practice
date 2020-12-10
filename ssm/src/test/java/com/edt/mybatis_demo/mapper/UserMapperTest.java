package com.edt.mybatis_demo.mapper;

import com.edt.mybatis_demo.domain.User;
import com.edt.mybatis_demo.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserMapperTest {
    @Test
    public void TestSave(){
        User user =new User();
        user.setUsername("谭泽豪老师2");
        user.setPassword("666");
        SqlSession session= MybatisUtil.openSession();
        //返回接口的实现类对象
        UserMapper userMapper =session.getMapper(UserMapper.class);
       User user1= userMapper.login("谭泽豪老师2","666");
        session.commit();
        session.close();
        System.out.println(user1);
    }
//    # 无论传什么值 都会加单引号
    @Test
    public void query1(){
        User user =new User();
        user.setUsername("谭泽豪老师2");
        user.setPassword("666");
        SqlSession session= MybatisUtil.openSession();
        //返回接口的实现类对象
        UserMapper userMapper =session.getMapper(UserMapper.class);
        User user1= userMapper.query1("谭泽豪老师2");
        session.commit();
        session.close();
        System.out.println(user1);
    }
// $ 对象没有对应的属性 就抛出异常
    @Test
    public void query2(){
        SqlSession session= MybatisUtil.openSession();
        //返回接口的实现类对象
        UserMapper userMapper =session.getMapper(UserMapper.class);
        User user1= userMapper.query2("谭泽豪老师2");
        session.commit();
        session.close();
        System.out.println(user1);
    }
}
