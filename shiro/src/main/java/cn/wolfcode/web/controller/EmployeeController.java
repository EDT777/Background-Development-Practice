package cn.wolfcode.web.controller;

import cn.wolfcode.domain.Employee;
import cn.wolfcode.qo.EmployeeQueryObject;
import cn.wolfcode.qo.JsonResult;
import cn.wolfcode.qo.QueryObject;
import cn.wolfcode.service.IDepartmentService;
import cn.wolfcode.service.IEmployeeService;
import cn.wolfcode.service.IRoleService;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private IEmployeeService employeeService;

    private IDepartmentService departmentService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    public void setEmployeeService(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Autowired
    public void setDepartmentService(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequiresPermissions(value = {"employee:list","员工页面"},logical = Logical.OR)//shiro提供的注解,2个中拥有其中一个权限即可访问
//    @RequiresRoles("hr")
    @RequestMapping("/list")
    public String list(Model model, @ModelAttribute("qo") EmployeeQueryObject qo){

//        判断用户是否有employee:list 权限
        Subject subject = SecurityUtils.getSubject();
        boolean permitted =subject.isPermitted("employee:list");
        boolean permitted2 =subject.isPermitted("role:list");
        System.out.println(permitted);
        System.out.println(permitted2);
        model.addAttribute("pageInfo", employeeService.query(qo));
        // 查询所有部门数据, 存到 Model
        model.addAttribute("departments", departmentService.listAll());
        return "employee/list"; // /WEB-INF/views/employee/list.jsp
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        if (id != null) {
            employeeService.delete(id);
        }
        // localhost/employee/list.do
        return "redirect:/employee/list";
    }

    @RequestMapping("/input")
    public String input(Long id, Model model) {
        // 查询所有角色
        model.addAttribute("roles",roleService.listAll());
        // 查询所有部门数据, 存到 Model
        model.addAttribute("departments", departmentService.listAll());
        if (id != null) {
            model.addAttribute("employee", employeeService.get(id));
        }
        return "employee/input";
    }

    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public JsonResult saveOrUpdate(Employee employee, Long[] ids) {
        if (employee.getId() == null) {
            employeeService.save(employee,ids);
        } else {
            employeeService.update(employee,ids);
        }
        return new JsonResult();

    }


    /**
     * 返回k-v
     * valid：true 验证通过
     * valid：false 验证不通过
     * @param username
     */
    @RequestMapping("/checkUsername")
    @ResponseBody
    public Map checkUsername(String username){
        HashMap<String, Boolean> map = new HashMap<>();
        //查询数据库是否存在该用户名
        Employee employee = employeeService.selectByUsername(username);
        //如果员工对象为空，代表用户名没被注册，现在可以注册，前端需要显示验证通过效果
        map.put("valid",employee==null);
        return map;
    }

    @RequestMapping("/exportXls")
    public void exportXls(HttpServletResponse response) throws IOException {
        //文件下载的响应头（让浏览器访问资源的的时候以下载的方式打开）
        response.setHeader("Content-Disposition","attachment;filename=employee.xls");
        Workbook wb = employeeService.exportXls();
        //把数据写出去
        wb.write(response.getOutputStream());
    }


    @RequestMapping("/importXls")
    @ResponseBody
    public JsonResult importXls(MultipartFile file) throws IOException {
        Workbook workbook = new HSSFWorkbook(file.getInputStream());
        employeeService.importXls(workbook);
        return new JsonResult();
    }

}
