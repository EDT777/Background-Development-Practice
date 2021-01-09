package cn.wolfcode.service;

import cn.wolfcode.domain.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DepartmentServiceTest {

    @Autowired
    private IDepartmentService departmentService;

    @Test
    public void testSave() {
      /*  Map<String, IDepartmentService> map = ctx.getBeansOfType(IDepartmentService.class);
        Collection<IDepartmentService> values = map.values();
        for (IDepartmentService value : values) {
            System.out.println(value.getClass());
        }*/


        System.out.println(departmentService.getClass());
       /* Department department = new Department();
        department.setName("公关部");
        department.setSn("DC");
        departmentService.save(department);*/
    }
}