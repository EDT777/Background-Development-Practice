package com.edt.json.web;

import com.alibaba.fastjson.JSON;
import com.edt.json.qo.JSONResult;
import com.edt.spring.crud.domain.Department2;
import com.edt.spring.crud.service.IDepartment2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@Controller
public class JSONController {
//    用Servlet API 完成 response对象

//    返回值
//    void      形参列表会有HttpServletResponse 对象,由开发者自定义响应内容
//    String    响应html格式数据,形参定义 Model
//    ModelAndView  目前响应html
//    其他类型      响应 JSON 数据

//    形参 HttpServletRequest HttpServletResponse HttpSession
//    形参 接收参数
//    形参 Model

    //    响应类型这样的JSON 数据{"success":true,"msg":"2020-03-16 10:00"}
    @RequestMapping("/getTime")
    public void getTime(HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();

        JSONResult jsonResult = new JSONResult();
        jsonResult.setMsg(new Date().toString());
        jsonResult.setSuccess(true);
        writer.write(JSON.toJSONString(jsonResult));
    }

//    响应单个数据方式
//    响应类型这样的 JSON数据{"success":true,"msg":"2020-03-16 10:00"}
    @RequestMapping("/getTime2")
    @ResponseBody
    public JSONResult getTime2(){
        JSONResult jsonResult = new JSONResult();
        jsonResult.setMsg(new Date().toString());
        jsonResult.setSuccess(true);
        return jsonResult;
    }

//    响应多个数据方式
//      @Autowired
//    private IDepartment2Service department2Service;
    @RequestMapping("/getDepts")
    @ResponseBody
    public List<Department2> getDepts(){
//            return  department2Service.listAll();
        return null;
    }

    @RequestMapping("/checkUsername")
    @ResponseBody
    public JSONResult checkUsername(String username){
        JSONResult jsonResult = new JSONResult();
       if ("lony".equals(username)){
           jsonResult.setSuccess(false);
           jsonResult.setMsg("用户名已存在");
           return jsonResult;
       }else {
           jsonResult.setSuccess(true);
           jsonResult.setMsg("恭喜您可以注册");
       }
       return jsonResult;
    }
    @RequestMapping("/login")
    @ResponseBody
    public JSONResult login(String username,String password){
        JSONResult jsonResult = new JSONResult();
        if ("lony".equals(username)&&"1".equals(password)){
            jsonResult.setSuccess(true);
            jsonResult.setMsg("登陆成功");
            return jsonResult;
        }else {
            jsonResult.setMsg("用户名或密码错误");
        }
        return jsonResult;
    }

}
