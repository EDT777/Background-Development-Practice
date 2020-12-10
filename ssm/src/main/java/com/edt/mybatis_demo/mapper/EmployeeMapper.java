package com.edt.mybatis_demo.mapper;

import com.edt.mybatis_demo.domain.Employee;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeMapper {
        //查询工资大于等于某个值的员工
    List<Employee> queryByMinSalary(@Param("minSalary") BigDecimal minSalary);
    List<Employee> queryByMinSalaryAndMaxSalary(@Param("minSalary") BigDecimal minSalary, @Param("maxSalary") BigDecimal maxSalary);
    void update(Employee e);
    void batchDelete(Long[] ids);
}
