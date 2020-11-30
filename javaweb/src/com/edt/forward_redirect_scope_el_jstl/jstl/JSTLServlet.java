package com.edt.forward_redirect_scope_el_jstl.jstl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/jstl")
public class JSTLServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        模拟数据库中查询出一个Person 列表
        List<Person> list = new ArrayList<>();
        list.add(new Person());
        list.add(new Person());
        list.add(new Person());
//        设置到作用域中,共享数据
        req.setAttribute("list",list);
        req.setAttribute("p",new Person());
        req.getRequestDispatcher("/jstl.jsp").forward(req,resp);

    }
}
