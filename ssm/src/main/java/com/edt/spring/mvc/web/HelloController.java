package com.edt.spring.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController  {
//    处理请求方式/hello
    @RequestMapping("/hello")
    public ModelAndView handler(){
//        创建ModelAndView对象,封装视图和数据
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/WEB-INF/views/welcome.jsp");//相当于之前的转发
        mv.addObject("msg","Hello Spring MVC");//req.setAttribute(x,x)
        return mv;
    }
}
