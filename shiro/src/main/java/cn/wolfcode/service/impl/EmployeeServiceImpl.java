package cn.wolfcode.service.impl;

import cn.wolfcode.domain.Employee;
import cn.wolfcode.mapper.EmployeeMapper;
import cn.wolfcode.qo.QueryObject;
import cn.wolfcode.service.IEmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private EmployeeMapper employeeMapper;

    @Autowired
    public void setEmployeeMapper(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    @Transactional
    public void save(Employee employee, Long[] ids) {
//        对密码进行加密(用户名作为盐)
        Md5Hash md5Hash = new Md5Hash(employee.getPassword(), employee.getUsername());
        employee.setPassword(md5Hash.toString());

        //保存员工
        employeeMapper.insert(employee);
        //处理中间表，关联关系
        if(ids!=null&&ids.length>0){
            for (Long roleId : ids) {
                employeeMapper.insertRelation(employee.getId(),roleId);
            }
        }
    }

    @Override
    @Transactional
    public void update(Employee employee, Long[] ids) {
        employeeMapper.updateByPrimaryKey(employee);
        //删除关联关系
        employeeMapper.deleteRelation(employee.getId());
        //处理中间表，关联关系
        if(ids!=null&&ids.length>0){
            for (Long roleId : ids) {
                employeeMapper.insertRelation(employee.getId(),roleId);
            }
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        //删除关联关系
        employeeMapper.deleteRelation(id);

        employeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Employee get(Long id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Employee> listAll() {
        return employeeMapper.selectAll();
    }

   @Override
    public PageInfo<Employee> query(QueryObject qo) {
        PageHelper.startPage(qo.getCurrentPage(),qo.getPageSize());
        List<Employee> employees = employeeMapper.selectForList(qo);
        return new PageInfo<>(employees);
    }

    @Override
    public Employee selectByUsername(String username) {
        return employeeMapper.selectByUsername(username);
    }

    @Override
    public Workbook exportXls() {
        //查询所有员工数据
        List<Employee> employees = employeeMapper.selectAll();
        //创建工作簿 excel
        Workbook wb = new HSSFWorkbook();
        //创建一个表格
        Sheet sheet = wb.createSheet("员工通讯录");
        //创建一行(行号) 标题行
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("用户名");
        row.createCell(1).setCellValue("真实姓名");
        row.createCell(2).setCellValue("邮箱");
        row.createCell(3).setCellValue("年龄");

        for (int i=0 ; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            row = sheet.createRow(i+1);
            //创建单元格(列号)，写入内容到单元格
            row.createCell(0).setCellValue(employee.getUsername());
            row.createCell(1).setCellValue(employee.getName());
            row.createCell(2).setCellValue(employee.getEmail());
            row.createCell(3).setCellValue(employee.getAge());
        }
        return wb;
    }

    @Override
    public void importXls(Workbook workbook) {
        //获取索引为0的表格
        Sheet sheet = workbook.getSheetAt(0);
        //获取最后一行的索引值
        int lastRowNum = sheet.getLastRowNum();
        //从索引为1的行数开始读
        for (int i = 1; i <= lastRowNum; i++) {
            Row row = sheet.getRow(i);
            //创建员工对象
            Employee employee = new Employee();
            employee.setUsername(row.getCell(0).getStringCellValue());
            employee.setName(row.getCell(1).getStringCellValue());
            employee.setEmail(row.getCell(2).getStringCellValue());
            employee.setAge((int)row.getCell(3).getNumericCellValue());
            employee.setPassword("1"); //默认密码
            //插入到数据库中
            employeeMapper.insert(employee);
        }

    }
}
