package cn.wolfcode.exception;

import cn.wolfcode.qo.JsonResult;
import com.alibaba.fastjson.JSON;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 当前类必须要被扫描
 * 代表该类是对控制器进行增强
 */
@ControllerAdvice
public class MyHandlerException {

    /**
     * 代表当前方法是用于捕获并处理异常(需要捕获的异常)
     */
    @ExceptionHandler(RuntimeException.class)
    public Object handler(RuntimeException e, HandlerMethod method, HttpServletResponse response) {
        e.printStackTrace(); //打印异常信息
        //如果是ajax请求(是否有贴ResponseBody)，就会返回jsonresult false msg
        if (method.hasMethodAnnotation(ResponseBody.class)) {
            //向浏览器输出结果
            try {
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().println(JSON.toJSONString(new JsonResult(false, "系统异常，请联系管理员")));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return null;
        } else {
            //返回视图
            return "common/error";
        }
    }
    /**
     * 代表当前方法是用于捕获并处理异常(需要捕获的异常)
     */
    @ExceptionHandler(LogicException.class)
    public Object handler2(LogicException e, HandlerMethod method, HttpServletResponse response){
        e.printStackTrace(); //打印异常信息
        //如果是ajax请求(是否有贴ResponseBody)，就会返回jsonresult false msg
        if(method.hasMethodAnnotation(ResponseBody.class)){
            //向浏览器输出结果
            try {
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().println(JSON.toJSONString(new JsonResult(false,e.getMessage())));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return null;
        }else{
            //返回视图
            return "common/error";
        }
    }


    /**
     * 代表当前方法是用于捕获并处理异常(需要捕获的异常)
     */
    @ExceptionHandler(UnauthorizedException.class)
    public Object handler3(RuntimeException e, HandlerMethod method, HttpServletResponse response){
        e.printStackTrace(); //打印异常信息
        //如果是ajax请求(是否有贴ResponseBody)，就会返回jsonresult false msg
        if(method.hasMethodAnnotation(ResponseBody.class)){
            //向浏览器输出结果
            try {
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().println(JSON.toJSONString(new JsonResult(false,"没有权限操作!")));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return null;
        }else{
            //返回视图
            return "common/nopermission";
        }
    }

}
