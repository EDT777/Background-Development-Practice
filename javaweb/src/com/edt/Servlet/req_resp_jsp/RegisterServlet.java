package com.edt.Servlet.req_resp_jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //      获取单个参数值
        System.out.println("账号：" + req.getParameter("username"));
        System.out.println("密码：" + req.getParameter("password"));
        System.out.println("性别：" + req.getParameter("gender"));
        System.out.println("城市：" + req.getParameter("city"));
//        获取多个参数值
        System.out.println(Arrays.toString(req.getParameterValues("hobby")));
        System.out.println("=========");
        //      其他api（了解）
        Enumeration<String> names = req.getParameterNames();//获取所有参数名
        while (names.hasMoreElements()) { //遍历所有参数值
            String name = names.nextElement();
            System.out.println(name + ":  " + req.getParameterValues(name));
        }
        System.out.println("======");
        Map<String, String[]> map = req.getParameterMap();
        Set<Map.Entry<String, String[]>> entrySet = map.entrySet();
        for (Map.Entry<String, String[]> entry : entrySet) {
            System.out.println(entry.getKey() + ": " + entry.getValue());

        }
    }
}
