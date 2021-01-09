package com.edt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edt.domain.Employee;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmployeeMapper extends BaseMapper<Employee> {
        List<Employee>  listByXmlSingle();

//        查询员工信息 并且关联部门信息
        List<Employee> listByXmlJoin();

        @Select("select e.* from employee e")
        List<Employee> listByAnnoSingle();

        @Select("select e.*,d.id d_id,d.name d_name,d.sn d_sn from employee e left join department d on e.dept_id = d.id")
        @Results({
                @Result(column = "d_id",property = "dept.id"),
                @Result(column = "d_name",property = "dept.name"),
                @Result(column = "d_sn",property = "dept.sn")
        })
        List<Employee> listByAnnoJoin();

}
