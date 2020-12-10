package com.edt.spring.mvc.web;

import com.edt.spring.mvc.domain.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Date;

@Controller
public class RequestController {
//    现在不关心找视图,研究怎么获取请求参数 return null 就不找视图
// 反射获取方法的形参列表
    @RequestMapping("/req1")
    public ModelAndView req1(@RequestParam("name") String username, Integer age){
        System.out.println(username);
        System.out.println(age);
        return null;
    }
//req2?ids=1&ids2&ids=3
    @RequestMapping("/req2")
    public ModelAndView req2(Long[] ids){
        System.out.println(Arrays.toString(ids));
        return null;
    }

//req3?username=tzh&password=666
//    反射创建对象 User user = new User()
//  获取这个对象所有属性id username password
//    String param1 = (String)请求对象.getParamter("username")
//    user.setUsername(param1)
//    参数名与封装参数值对象的属性名要一致,且可以封装 对象要加set方法
    @RequestMapping("/req3")
    public ModelAndView req3(User user){ 
        System.out.println(user);
        return null;
    }
//req4?date=2020-05-19
    @RequestMapping("/req4")
    public ModelAndView req4(@DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        System.out.println(date);
        return null;
    }

    @RequestMapping("/req5")
    public String req5(@ModelAttribute("u") User user){
        return "req";
    }
}
