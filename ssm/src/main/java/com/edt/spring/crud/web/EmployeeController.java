package com.edt.spring.crud.web;

import com.edt.spring.crud.domain.Employee;
import com.edt.spring.crud.qo.EmployeeQueryObject;
import com.edt.spring.crud.qo.Queryobject;
import com.edt.spring.crud.service.IDepartment2Service;
import com.edt.spring.crud.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private IDepartment2Service departmentService;

    private IEmployeeService employeeService;
    @Autowired
    public void setEmployeeService(IEmployeeService employeeService){
        this.employeeService =employeeService;
    }

    @Autowired
    public void setDepartment2Service(IDepartment2Service department2Service){
        this.departmentService =department2Service;
    }

    //    处理查询所有员工的请求,响应HTML
    @RequestMapping("/list")
    public String list(Model model, @ModelAttribute("qo") EmployeeQueryObject qo){
        model.addAttribute("pageResult",employeeService.query(qo));
            model.addAttribute("departments",departmentService.listAll());
               return "employee/list";//WEB-INF/views/employee/list.jsp
    }

//    处理查询删除员工请求
    @RequestMapping("/delete")
    public String delete(Long id){
        if (id != null) {
            employeeService.delete(id);
        }
        return "redirect:/employee/list";
    }

//    处理去保存请求
    @RequestMapping("/input")
    public String input(Long id,Model model){
        model.addAttribute("departments",departmentService.listAll());

        if (id != null) {
            model.addAttribute("employee", employeeService.get(id));
        }
        return "employee/input";
    }

//    处理保存请求
    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Employee employee){
        if (employee.getId() ==null){
            employeeService.save(employee);
        }else {
            employeeService.update(employee);
        }

            return "redirect:/employee/list";
    }


}
