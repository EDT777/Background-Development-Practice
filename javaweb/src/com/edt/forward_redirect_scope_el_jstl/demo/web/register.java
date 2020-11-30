package com.edt.forward_redirect_scope_el_jstl.demo.web;

import com.edt.Servlet.demo.dao.IStudentDao;
import com.edt.Servlet.demo.dao.impl.StudentDaoImpl;
import com.edt.Servlet.demo.domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
//访问register.jsp 即可完成注册
@WebServlet("/jspRegister")
public class register extends HttpServlet {
    IStudentDao studentDao = new StudentDaoImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            Long number = Long.valueOf(req.getParameter("number"));
            String name = req.getParameter("name");
            Double score = Double.valueOf(req.getParameter("score"));
            String sex = req.getParameter("sex");
            Student stu = new Student(number, name, sex, score);
            studentDao.insert(stu);
            req.setAttribute("msg", true);

        } catch (Exception e) {
            req.setAttribute("msg", false);
        }
        List<Student> list = studentDao.selectAll();
        req.setAttribute("listMsg", true);
        req.setAttribute("list", list);
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
        System.out.println("注册成功!");
    }
}
