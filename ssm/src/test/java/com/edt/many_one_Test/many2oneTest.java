package com.edt.many_one_Test;

import com.edt.one2many2one.many2one.domain.Department;
import com.edt.one2many2one.many2one.domain.Employee;
import com.edt.one2many2one.many2one.mapper.DepartmentMapper;
import com.edt.one2many2one.many2one.mapper.EmployeeMapper;
import com.edt.mybatis_demo.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


public class many2oneTest {
//查询所有员工及其对应部门
    @Test
    public void testList() {
        SqlSession session = MybatisUtil.openSession();
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        System.out.println(employeeMapper.getList());
        session.close();
    }
//根据员工 id 查询员工，并知道该员工的所在的部门。
    @Test
    public void testGet() {
        SqlSession session = MybatisUtil.openSession();
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Employee employee = employeeMapper.get(11L);
        System.out.println(employee);
        session.close();
    }

    @Test
    public void testSave() {
        //创建员工和部门
        Employee e1 = new Employee();
        e1.setName("马云");
        Employee e2 = new Employee();
        e2.setName("马化腾");
        Department department = new Department();
        department.setName("老板部门");

        //给员工设置部门
        e1.setDept(department);
        e2.setDept(department);
        //存储数据
        SqlSession session = MybatisUtil.openSession();
        DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        departmentMapper.save(department); //会返还id值赋值回去department对象里

        employeeMapper.save(e1);
        employeeMapper.save(e2);
        session.commit();
        session.close();
    }
}
