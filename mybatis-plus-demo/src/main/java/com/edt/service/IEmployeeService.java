package com.edt.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.edt.domain.Employee;
import com.edt.qo.EmployeeQueryObject;

public interface IEmployeeService extends IService<Employee> {

    Page<Employee> queryPage(EmployeeQueryObject qo);
}
