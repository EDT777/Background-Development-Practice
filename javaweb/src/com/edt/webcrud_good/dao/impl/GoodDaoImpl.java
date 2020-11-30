package com.edt.webcrud_good.dao.impl;

import com.edt.webcrud_product.util.MybatisUtil;
import com.edt.webcrud_good.dao.IGoodDao;
import com.edt.webcrud_good.domain.Good;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GoodDaoImpl implements IGoodDao {
    public void insert(Good g) {
        SqlSession session = MybatisUtil.openSession();
        session.insert("com.edt.webcrud_good.mapper.goodMapper.insert", g);
        session.commit();
        session.close();
    }


    @Override
    public void delete(Long id) {
        SqlSession session = MybatisUtil.openSession();
        session.delete("com.edt.webcrud_good.mapper.goodMapper.delete", id);
        session.commit();
        session.close();
    }


    @Override
    public void update(Good g) {
        SqlSession session = MybatisUtil.openSession();
        session.update("com.edt.webcrud_good.mapper.goodMapper.update", g);
        session.commit();
        session.close();
    }

    @Override
    public Good selectOne(Long id) {
        SqlSession session = MybatisUtil.openSession();
        Good g = session.selectOne("com.edt.webcrud_good.mapper.goodMapper.selectOne", id);
        session.commit();
        session.close();
        return g;
    }

    @Override
    public List<Good> selectList() {
        SqlSession session = MybatisUtil.openSession();
        List<Good> list = session.selectList("com.edt.webcrud_good.mapper.goodMapper.selectList");
        session.commit();
        session.close();
        return list;
    }
}
