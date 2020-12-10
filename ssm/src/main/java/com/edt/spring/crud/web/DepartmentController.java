package com.edt.spring.crud.web;

import com.edt.spring.crud.domain.Department2;
import com.edt.spring.crud.qo.Queryobject;
import com.edt.spring.crud.service.IDepartment2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/department")
public class DepartmentController {


    private IDepartment2Service department2Service;
    @Autowired
    public void setDepartment2Service(IDepartment2Service department2Service){
        this.department2Service =department2Service;
    }

//    处理查询所有部门的请求,响应HTML
    @RequestMapping("/list")
    public String list(Model model, Queryobject qo){
        model.addAttribute("pageResult",department2Service.query(qo));
                return "department/list";//WEB-INF/views/department/list.jsp
    }

//    处理查询删除部门请求
    @RequestMapping("/delete")
    public String delete(Long id){
        if (id != null) {
            department2Service.delete(id);
        }
        return "redirect:/department/list";
    }

//    处理去保存请求
    @RequestMapping("/input")
    public String input(Long id,Model model){
        if (id != null) {
            model.addAttribute("department", department2Service.get(id));
        }
        return "department/input";
    }

//    处理保存请求
    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Department2 department2){
        if (department2.getId() ==null){
            department2Service.save(department2);
        }else {
            department2Service.update(department2);
        }

            return "redirect:/department/list";
    }


}
