package com.edt.spring.mvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;

@Controller
public class UploadController {

    @Autowired
    private ServletContext servletContext;

    @RequestMapping("/upload")
    private ModelAndView upload(Part pic){
        // 获取项目 webapp 目录下 static 目录的绝对路径
        System.out.println(servletContext.getRealPath("/static"));
        System.out.println(pic.getSize());
        System.out.println(pic.getContentType());
        return null;
    }
}
