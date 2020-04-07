package com.octopus.spring1.freemarker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octopus.spring1.entity.UserInfo;
@WebServlet("/fm")
public class TestServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	UserInfo user = new UserInfo();
	user.setUserName("EDT2");
	req.setAttribute("user", user);
	req.setAttribute("username", "EDT3");
	req.setAttribute("date", new Date());
	req.setAttribute("number", 1.9980220);
	req.setAttribute("eng", "hello");
	List<String> list =new ArrayList<>();
	list.add("String1");
	list.add("String2");
	list.add("String3");
	req.setAttribute("mylist",list);
	
	Map<String,Object> map= new HashMap<String,Object>();
	map.put("key1", "value1");
	map.put("key2", "value2");
	map.put("key3", "value3");
	req.setAttribute("map", map);
	
	
	req.getRequestDispatcher("/test.ftl").forward(req, resp);
}
}
