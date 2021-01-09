package com.edt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edt.domain.Employee;
import com.edt.mapper.EmployeeMapper;
import com.edt.qo.EmployeeQueryObject;
import com.edt.qo.QueryObject;
import com.edt.service.IEmployeeService;
import org.springframework.stereotype.Service;


/**
 * 1.实现自定义IEmployeeService接口,注意,该接口又继承IService接口
 *  IEmployeeService:负责定义业务逻辑方法
 *  IService:负责定义通用的crud方法
 *  2.必须继承ServiceImpl类,原因:ServiceImpl实现了IService接口的通用的crud方法
 *  3.ServiceImpl类 需要明确2个泛型
 *      参数一: mybatis-plus 映射接口EmployeeMapper
 *      参数二: service操作的实体对象
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

    @Override
    public Page<Employee> queryPage(EmployeeQueryObject qo) {
        Page<Employee> page = new Page<>(qo.getCurrentPage(), qo.getPageSize());
//        查询条件
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.like("name",qo.getKeyWord());
        return super.page(page,wrapper);
    }
}
