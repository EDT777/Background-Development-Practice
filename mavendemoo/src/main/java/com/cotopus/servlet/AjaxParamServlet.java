package com.cotopus.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/param2")
public class AjaxParamServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
System.out.println("GET从表单获取的suername:"+req.getParameter("username"));
System.out.println("GET从表单获取的age:"+req.getParameter("age"));
}

@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("UTF-8");
	System.out.println("POST从表单获取的suername:"+req.getParameter("username"));
	System.out.println("POST从表单获取的age:"+req.getParameter("age"));
	
	}
}
