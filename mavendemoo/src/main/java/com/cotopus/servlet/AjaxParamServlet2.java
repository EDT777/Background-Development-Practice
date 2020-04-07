package com.cotopus.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *演示ajax提交序列化后的字符串json参数的处理方式
 */
@WebServlet("/param3")
public class AjaxParamServlet2 extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
System.out.println(req.getParameterMap());//获取所有的参数的map
}

@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("UTF-8");
	//如果对方的数据是以application/json方式提交的,则数据不会出现标准参数，而是需要进一步获取
	char[] buffer =new char[400];
	int len=req.getReader().read(buffer);
	String content = new String(buffer,0,len);
	System.out.println("这是从request的body中获取的数据"+content);
	System.out.println(new HashMap<Object,Object>(req.getParameterMap()));//获取所有的参数的map
	}
}
