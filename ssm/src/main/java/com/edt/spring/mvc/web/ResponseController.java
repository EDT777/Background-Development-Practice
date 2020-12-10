package com.edt.spring.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseController {

//    处理方法
    @RequestMapping("/resp1")
    public ModelAndView resp1(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("resp"); //定义了前缀后缀
        mv.addObject("msg","ModelAndView");
        return mv;
    }

//model对象创建出来,反射调用,构建ModelAndView
    @RequestMapping("/resp2")
    public String resp2(Model model){//这种方式更简洁快捷
//        往作用域存入数据
        model.addAttribute("msg","ModelAndView2");
//        找视图,根据路径找文件,读取文件内容跟模型数据合并渲染 HTML内容
        return "resp";
    }


    @RequestMapping("/f")
    public String f(){
//        转发,要写明确路径,用不了视图解析器前缀和后缀
        return "forward:/WEB-INF/views/welcome.jsp";
    }
    @RequestMapping("/r")
    public String r(){
//        重定向,要写明确路径,用不了视图解析器前缀和后缀
        return "redirect:/static/b.html";
    }

    @RequestMapping("/aaa")
    public String aaa(){
        System.out.println("aaa");
        return null;
    }
}
