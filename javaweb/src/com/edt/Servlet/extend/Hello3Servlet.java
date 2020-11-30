package com.edt.Servlet.extend;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello3")
public class Hello3Servlet extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("执行操作");
    }
}
