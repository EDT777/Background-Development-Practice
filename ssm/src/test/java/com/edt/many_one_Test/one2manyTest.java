package com.edt.many_one_Test;


import com.edt.mybatis_demo.utils.MybatisUtil;
import com.edt.one2many2one.one2many.domain.Department;
import com.edt.one2many2one.one2many.domain.Employee;
import com.edt.one2many2one.one2many.mapper.DepartmentMapper;
import com.edt.one2many2one.one2many.mapper.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class one2manyTest {

//    根据ID查部门 把部门的员工信息也查出来
    @Test
    public void testGet() {
        SqlSession session = MybatisUtil.openSession();
        DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
        System.out.println(departmentMapper.get(5L));
        session.close();
    }


    //    保存一个部门和两个员工,且这两个员工都是这个部门的
    @Test
    public void testSave() {
        Department department = new Department();
        department.setName("洗脚部");
        Employee e1 = new Employee();
        e1.setName("小豪");
        Employee e2 = new Employee();
        e2.setName("小兰");

        SqlSession session = MybatisUtil.openSession();
        DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        departmentMapper.save(department);

        e1.setDeptId(department.getId());
        e2.setDeptId(department.getId());
        System.out.println(e1);
        System.out.println(e2);
        employeeMapper.save(e1);
        employeeMapper.save(e2);
        session.commit();
        session.close();

    }
}
