package com.edt.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edt.domain.Employee;
import com.edt.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MapperTest {
    @Autowired
    private EmployeeMapper employeeMapper;

    //-----------------------新增----------------------------
    @Test
    public void testSave() {
        Employee employee = new Employee();
        employee.setAdmin(1);
        employee.setAge(18);
        employee.setDeptId(1L);
        employee.setEmail("edt.com");
        employee.setName("edt");
        employee.setPassword("111");
        employeeMapper.insert(employee);
    }

//---------------------更新----------------------------

    /**
     * 如果全量更新(很多属性),并且知道id,建议使用updateById方法
     * 使用完整update动作:1.查询 2.替换 3.更新
     * <p>
     * 如果是部分字段更新,建议使用update方法
     * wrapper.set("更新字段",值)
     * xxxMapper.update(null,wrapper);
     */

    @Test
    public void testUpdateById() {
//        需求: 将id=1的用户名名字修改为哈哈哈
//        存在的问题:
//         如果属性是基本类型,存在默认值,执行update时候可能出现数据丢失(被覆盖)问题
//        解决方法:
//        1.实体类全部使用包装类型
//        2.执行一次完整的updateById流程(以下演示)
//        先查询
        Employee employee = employeeMapper.selectById(1L);
//        替换
        employee.setName("哈哈哈");
//        更新
        employeeMapper.updateById(employee);
    }

    @Test
    public void testUpdate() {//不推荐
//    需求: 更新name=哈哈哈员工年龄为18岁
//    update employee set age=18 where name="哈哈哈"
        Employee employee = new Employee();
        employee.setAge(18);
//    wrapper:条件构造器
        UpdateWrapper<Employee> wrapper = new UpdateWrapper<>();
        wrapper.eq("name", "哈哈哈"); //等价于 where name = '哈哈哈'
//    执行update操作,有属性值都会执行更新操作,基本类型默认都有值
        employeeMapper.update(employee, wrapper);
    }

    @Test
    public void testUpdate2() {//推荐
//    需求: 更新name=哈哈哈员工年龄为18岁
//    update employee set age=18 where name="哈哈哈"
//    wrapper:条件构造器
        UpdateWrapper<Employee> wrapper = new UpdateWrapper<>();
        wrapper.set("age", 18);
        wrapper.eq("name", "哈哈哈"); //等价于 where name = '哈哈哈'
//    执行update操作,  这里传null就不担心有属性值都会执行更新操作,基本类型默认都有值
        employeeMapper.update(null, wrapper);
    }

    //---------------------删除----------------------------
    @Test
    public void testDeleteById() {
//        需求:删除id为2的员工
        employeeMapper.deleteById(2L);
    }

    @Test
    public void testBatchIds() {
//        需求:删除id为3,4,5
        employeeMapper.deleteBatchIds(Arrays.asList(3, 4, 5));
    }

    @Test
    public void testDeleteByMap() {
//        需求:删除name=孙总 并且age=35的员工信息
//        sql: delete from employee where name = '孙总' and age=35
//        条件列的映射:key-列名  value-条件值, 各个条件使用and拼接
        Map<String, Object> map = new HashMap<>();
        map.put("name", "孙总");
        map.put("age", 35);
        employeeMapper.deleteByMap(map);
    }

    @Test
    public void testDelete() {
//       需求:删除name=李总并且age=35的员工信息
//        sql: delete from employee where name = '李总' and age=35
//        UpdateWrapper : DML操作 ---update操作
//        QueryWrapper : DQL操作  ---非update操作
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name", "李总");
        queryWrapper.eq("age", 35);
        employeeMapper.delete(queryWrapper);
    }

    //---------------------查询----------------------------
    @Test
    public void testSelectBatchIds() {
//      需求:查询id=1,id=7的员工信息
//        sql:select * from employee where id in (1,2)
        List<Employee> list = employeeMapper.selectBatchIds(Arrays.asList(1L, 7L));
        list.forEach(System.err::println);
    }

    @Test
    public void testSelectCount() {
//      需求:查询age=18 员工个数
//        sql: select count(1) from employee where age=18
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.eq("age", 18);
        Integer count = employeeMapper.selectCount(wrapper);//如果传null 则查所有

    }

    @Test
    public void testSelectList() {//常用
//      需求:查询age=25的所有员工信息,返回list
//        sql:select * from employee where age = 25
        QueryWrapper<Employee> wrapper = new QueryWrapper();
        wrapper.eq("age", 25);
        List<Employee> employees = employeeMapper.selectList(wrapper);
        System.err.println(employees.getClass());
        for (Employee employee : employees) {
            System.err.println(employee);
        }
    }

    @Test
    public void testSelectMap() {//很少用,没有实体接收对象才会用到
//      需求:查询age=25的所有员工信息,返回map
//        sql:select * from employee where age = 25
        QueryWrapper<Employee> wrapper = new QueryWrapper();
        wrapper.eq("age", 25);
        List<Map<String, Object>> employees = employeeMapper.selectMaps(wrapper);
        System.err.println(employees.getClass());
        for (Map<String, Object> employee : employees) {
            System.err.println(employee.getClass());
            System.err.println(employee);
        }
    }

    @Test
    public void testSelectPage() {
//      需求:查询第二页员工数据,每页显示3条数据(分页返回的数据是实体对象)
//        sql:select * from employee limit (currentPage - 1) * pageSize , pageSize

//参数1:当前页, 参数2:每页显示条数
        Page<Employee> page = new Page<>(2, 3);
        employeeMapper.selectPage(page, null);//不带条件,所以传null

//        分页条:
        System.out.println("当前页"+page.getCurrent());
        System.out.println("每页显示条数"+page.getSize());
        System.out.println("总页数"+page.getPages());
        System.out.println("总数"+page.getTotal());
        System.out.println("当前页数据"+page.getRecords());
    }
}
