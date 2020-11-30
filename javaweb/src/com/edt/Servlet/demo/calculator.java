package com.edt.Servlet.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculator")
public class calculator extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        double num1 = Double.valueOf(req.getParameter("num1"));
        double num2 = Double.valueOf(req.getParameter("num2"));
        String mark = req.getParameter("mark");
        double result = 0;
        if (mark.equals("+")) { //地址栏写%2B 才是加号
            result = num1 + num2;
        } else if (mark.equals("-")) {
            result = num1 - num2;
        } else if (mark.equals("*")) {
            result = num1 * num2;
        } else if (mark.equals("/")) {
            result = num1 / num2;
        }
        System.out.println(num1 + mark + num2 + "=" + result);
        PrintWriter writer = resp.getWriter();

    }
}
