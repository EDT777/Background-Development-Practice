package com.edt.webcrud_good.test;

import com.edt.webcrud_good.dao.IGoodDao;
import com.edt.webcrud_good.dao.impl.GoodDaoImpl;
import com.edt.webcrud_good.domain.Good;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;

import static org.junit.Assert.*;

public class GoodDaoTest {
    private IGoodDao goodDao = new GoodDaoImpl();

    @Test
    public void insert() {
        Good g = new Good();
        g.setDetail("啊啊啊");
        g.setCreateTime(new Date());
        g.setName("哈哈哈");
        g.setPrice(2f);
        goodDao.insert(g);
    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
    }

    @Test
    public void selectOne() {
    }

    @Test
    public void selectList() {
        System.out.println(goodDao.selectList());
    }
}
