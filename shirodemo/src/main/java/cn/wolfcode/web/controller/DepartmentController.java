package cn.wolfcode.web.controller;

import cn.wolfcode.domain.Department;
import cn.wolfcode.qo.QueryObject;
import cn.wolfcode.service.IDepartmentService;

import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    private IDepartmentService departmentService;

    @Autowired
    public void setDepartmentService(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping("/list")
    public String list(Model model, QueryObject qo){
        model.addAttribute("pageInfo", departmentService.query(qo));
        return "department/list"; // /WEB-INF/views/department/list.jsp
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        if (id != null) {
            departmentService.delete(id);
        }
        return "redirect:/department/list";
    }


    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Department department) {
        if (department.getId() == null) {
            departmentService.save(department);
        } else {
            departmentService.update(department);
        }
        return "redirect:/department/list";
    }

}
