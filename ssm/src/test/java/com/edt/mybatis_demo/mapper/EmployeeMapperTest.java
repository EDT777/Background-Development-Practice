package com.edt.mybatis_demo.mapper;

import com.edt.mybatis_demo.domain.Employee;
import com.edt.mybatis_demo.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class EmployeeMapperTest {

    @Test
    public void queryByMinSalary() {
        SqlSession session = MybatisUtil.openSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        List<Employee> list = mapper.queryByMinSalary(new BigDecimal("1000"));
        session.commit();
        session.close();
        System.out.println(list);
    }
    @Test
    public void queryByMinSalaryAndMaxSalary() {
        SqlSession session = MybatisUtil.openSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        List<Employee> list = mapper.queryByMinSalaryAndMaxSalary(new BigDecimal("1000"),new BigDecimal("1200"));
        session.commit();
        session.close();
        System.out.println(list);
    }
    @Test
    public void update() {
        SqlSession session = MybatisUtil.openSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee e = new Employee();
        e.setId(1L);
        e.setSalary(new BigDecimal("5555"));
        mapper.update(e);
        session.commit();
        session.close();
    }

    @Test
    public void deleteBatch() {
        SqlSession session = MybatisUtil.openSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        mapper.batchDelete(new Long[]{1L,2L,3L});
        session.commit();
        session.close();
    }
}
