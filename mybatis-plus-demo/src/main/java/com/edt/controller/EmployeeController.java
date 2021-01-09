package com.edt.controller;

import com.edt.domain.Employee;
import com.edt.service.IEmployeeService;
import com.edt.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

@RestController
@RequestMapping("/emps")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/list")
    public Object list(){
        return employeeService.list();
    }
//更新
    @PostMapping("/saveOrUpdate")
    public Object saveOrUpdate(Employee employee){
        employeeService.saveOrUpdate(employee);
        return JsonResult.success();
    }

    @GetMapping("/detail")
    public Object detail(Long id){
        return employeeService.getById(id);
    }
}
