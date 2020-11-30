package com.edt.xml_properties;

import com.edt.xml_properties.dao.UserDaoImpl;
import org.junit.Test;

public class UserDaoImplTest {
  private UserDaoImpl userDao = new UserDaoImpl();
    @Test
    public void add() {
        userDao.add();
    }

    @Test
    public void delete() {
        userDao.delete(1);
    }
}