package com.edt.spring;

import com.edt.spring.crud.domain.Department2;
import com.edt.spring.crud.mapper.Department2Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/crud.xml")
public class crudTest {

    @Autowired
    private Department2Mapper department2Mapper;
    @Test
    public void testSave(){
        Department2 department2 = new Department2();
        department2.setName("公关部");
        department2.setSn("DC ");
        department2Mapper.insert(department2);
    }
}
