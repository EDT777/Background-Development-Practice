package cn.wolfcode.service;

import cn.wolfcode.domain.Employee;
import cn.wolfcode.qo.QueryObject;
import com.github.pagehelper.PageInfo;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

public interface IEmployeeService {
    void save(Employee employee, Long[] ids);
    void update(Employee employee, Long[] ids);
    void delete(Long id);
    Employee get(Long id);
    List<Employee> listAll();
    // 分页查询的方法
    PageInfo<Employee> query(QueryObject qo);


    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    Employee selectByUsername(String username);

    /**
     * 员工导出
     * @return
     */
    Workbook exportXls();

    /**
     * 员工导入
     * @param workbook
     */
    void importXls(Workbook workbook);
}