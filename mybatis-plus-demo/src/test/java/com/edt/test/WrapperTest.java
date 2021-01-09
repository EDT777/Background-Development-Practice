package com.edt.test;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.edt.domain.Employee;
import com.edt.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

@SpringBootTest
public class WrapperTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    //-----------------------------更新-------------------
    @Test
    public void testUpdate(){
//需求: 将id=1的员工age改为18,如果传入uname变量值不等于null或者"",修改为员工name为uname变量值
        String uname="哈哈哈12";
        UpdateWrapper<Employee> wrapper = new UpdateWrapper<>();
        wrapper.eq("id",1L);
        wrapper.set("age",18);
//        当参数1 位true时, 更新后面的列与值
        wrapper.set(StringUtils.hasLength(uname),"name",uname);
        employeeMapper.update(null,wrapper);
    }

    @Test
    public void testUpdate2(){//拼接sql
        UpdateWrapper<Employee> wrapper = new UpdateWrapper<>();
        wrapper.eq("id",1L);
        wrapper.setSql("name='123'");//直接写sql片段
        employeeMapper.update(null,wrapper);
    }

    @Test
    public void testUpdate3(){//lambda版本,可避免手误,直接Employee::getXX 指定
        LambdaUpdateWrapper<Employee> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(Employee::getId,1L);
        wrapper.set(Employee::getName,"tzh");
        employeeMapper.update(null,wrapper);
    }

    //-----------------------------查询-------------------
    @Test
    public void testSelect(){
//      需求:查询name=tzh,age=18的员工
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.eq("name","tzh");
        wrapper.eq("age",18);
        System.out.println(employeeMapper.selectList(wrapper));
    }

    @Test
    public void testSelect2(){
//      需求:查询name=tzh,age=18的员工
       employeeMapper.selectList(new QueryWrapper<Employee>()
       .eq("name","tzh")
               .eq("age",18));

    }

    @Test
    public void testWrapper(){
//      如何创建wrapper对象
//        update
        UpdateWrapper<Employee> updateWrapper1 = new UpdateWrapper<>();
        UpdateWrapper<Employee> updateWrapper2 = Wrappers.<Employee>update();

        LambdaUpdateWrapper<Employee> lambdaUpdateWrapper1 = new LambdaUpdateWrapper<>();
        LambdaUpdateWrapper<Employee> lambdaUpdateWrapper2 =updateWrapper1.lambda();
        LambdaUpdateWrapper<Employee> lambdaUpdateWrapper3 = Wrappers.<Employee>lambdaUpdate();

//        query
        QueryWrapper<Employee> queryWrapper1 = new QueryWrapper<>();
        QueryWrapper<Employee> queryWrapper2 = Wrappers.<Employee>query();

        LambdaQueryWrapper<Employee> lambdaQueryWrapper1 = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<Employee> lambdaQueryWrapper2 =queryWrapper1.lambda();
        LambdaQueryWrapper<Employee> lambdaQueryWrapper3 = Wrappers.<Employee>lambdaQuery();

    }
}
