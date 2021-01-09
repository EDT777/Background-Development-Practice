package com.edt.test;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edt.domain.Employee;
import com.edt.mapper.EmployeeMapper;
import com.edt.qo.EmployeeQueryObject;
import com.edt.service.IEmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServiceTest {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private IEmployeeService employeeService;

    @Test
    public void testPage() {
        EmployeeQueryObject qo = new EmployeeQueryObject();
        qo.setCurrentPage(2);
        qo.setPageSize(3);
        Page<Employee> page = employeeService.queryPage(qo);
    }
}
