package com.edt.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.edt.domain.Employee;
import com.edt.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class QueryTest {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void testQuery() {
//      需求:查询所有员工,返回员工name,age列
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.select("name", "age");
        employeeMapper.selectList(wrapper);
    }

    @Test
    public void testQuery2() {
//      需求:查询所有员工按age正序排, 如果一样 按id正序排
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        //第一个参数是是否执行排序,第二个参数是否为asc排序,第三个是要排序的列
        wrapper.orderBy(true,true,"name");
        employeeMapper.selectList(wrapper);
    }

    @Test
    public void testQuery3() {
//      需求:查询name=tzh,age=18员工信息
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("name", "tzh");
        map.put("age", 18);
        wrapper.allEq(map);
//        wrapper.orderby
        employeeMapper.selectList(wrapper);
        employeeMapper.selectByMap(map);
    }

    @Test
    public void testQuery4() {
//      需求:查询name!=tzh员工信息
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.ne("name", "tzh");
        employeeMapper.selectList(wrapper);
    }

    @Test
    public void testQuery5() {
//      需求:查询age>18员工信息
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.gt("age", 18);
        employeeMapper.selectList(wrapper);
    }

    @Test
    public void testQuery6() {
//      需求:查询age在18-30岁 员工信息
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.between("age", 18, 30);
        employeeMapper.selectList(wrapper);
    }

    @Test
    public void testQuery7() {
//      需求:查询部门为null的员工信息
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.isNull("dept_id");
        employeeMapper.selectList(wrapper);
    }

    @Test
    public void testQuery8() {
//      需求:查询id为1,2 的员工信息
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
//        wrapper.in("id",1L,8L);
        wrapper.inSql("id", "1,2");
        employeeMapper.selectList(wrapper);
    }

    @Test
    public void testQuery9() {
//      需求:查询name含有t字样的员工
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.like("name", "t");
        wrapper.notLike("name", "t");
        wrapper.likeLeft("name", "h");//%在左
        employeeMapper.selectList(wrapper);
    }

    @Test
    public void testQuery10() {
//      需求:查询age=18 或者 name=tzh  或者 id=1 的用户
//        sql:select * from employee where age =18 or name tzh or id=1
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();

        wrapper.eq("age", 18)
                .or()
                .eq("name", "tzh")
                .or()
                .eq("id", 1L);
        employeeMapper.selectList(wrapper);
    }
    @Test
    public void testQuery11() {
//      需求:查询name含有tzh字样的 或者 年龄在18和30直接的用户
//        sql:select * from employee where name like 'tzh' or (age>=18 and age<=30)
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();

        wrapper.like("name","tzh").or(
            wp->wp.ge("age",18).le("age",30));


        employeeMapper.selectList(wrapper);
    }

    @Test
    public void testQuery12() {
//      需求:查询name含有tzh字样的 或者 年龄在18和30直接的用户
//        sql:select * from employee where name like 'tzh' and (age<18 or age>30)
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();

        wrapper.like("name","tzh")
                .and(wp->wp.lt("age",18).or().gt("age",30));
        employeeMapper.selectList(wrapper);
    }

    @Test
    public void testQuery13() {
//      需求:以部门id进行分组查询,查询每个部门员工个数
//        sql:select dept_id,count(id) from employee group by dept_id
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.groupBy("dept_id");
        wrapper.select("dept_id","count(id) as count");
        System.out.println(employeeMapper.selectMaps(wrapper));//此演示只有使用map,才可封装我们查询的值
    }

    @Test
    public void testQuery14() {
//      需求:以部门id进行分组查询,查询每个部门员工个数 并且员工个数大于3的
//        sql:select dept_id,count(id) as count from employee group by dept_id having count > 3
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.groupBy("dept_id");
        wrapper.select("dept_id","count(id) as count");
//        wrapper.having("count > 3"); //不使用占位符的方法
        wrapper.having("count > {0}",3);//使用占位符的方法
        System.out.println(employeeMapper.selectMaps(wrapper));//此演示只有使用map,才可封装我们查询的值
    }

    //------------------------------------xml和注解的方式使用---------------------------------------
    @Test
    public void testQuery15(){
        System.out.println(employeeMapper.listByXmlSingle());
    }

    @Test
    public void testQuery16(){
        System.out.println(employeeMapper.listByXmlJoin());
    }

    @Test
    public void testQuery17(){
        System.out.println(employeeMapper.listByAnnoSingle());
    }

    @Test
    public void testQuery18(){
        System.out.println(employeeMapper.listByAnnoJoin());
    }
}
