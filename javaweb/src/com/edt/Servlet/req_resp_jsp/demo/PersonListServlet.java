package com.edt.Servlet.req_resp_jsp.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/person")
public class PersonListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建3个对象，摸你数据库的数据
        Person p1 = new Person(1L,"小狼",18,"lang@");
        Person p2 = new Person(2L,"小狼2",18,"lang@2");
        Person p3 = new Person(3L,"小狼3",18,"lang@3");
        //放入集合
        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        //显示数据到浏览器
        //下拉数据共享给jsp
        req.setAttribute("list",list);
        //跳转到jsp中去显示数据
        req.getRequestDispatcher("/list_person.jsp").forward(req,resp);
    }
}
