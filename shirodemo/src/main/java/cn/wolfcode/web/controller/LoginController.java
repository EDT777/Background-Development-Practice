package cn.wolfcode.web.controller;

import cn.wolfcode.qo.JsonResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {


    @RequestMapping("/userLogin")
    @ResponseBody
    public JsonResult login(String username, String password){
//        使用shiro的方式进行登录
        try {
            Subject subject = SecurityUtils.getSubject();
            Md5Hash md5Hash =new Md5Hash(password,username);
            subject.login(new UsernamePasswordToken(username,md5Hash.toString()));
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,"账号与密码不匹配");
        }
        return new JsonResult();
    }

    @RequestMapping("/nopermission")
    public String nopermission(){
        return "common/nopermission";
    }

}
