package com.edt.Servlet.demo.web;

import com.edt.Servlet.demo.dao.IStudentDao;
import com.edt.Servlet.demo.dao.impl.StudentDaoImpl;
import com.edt.Servlet.demo.domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/selectAll")
public class selectAll extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IStudentDao studentDao = new StudentDaoImpl();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        List<Student> list =studentDao.selectAll();
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">");
        writer.println("<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>查询学生所有数据</title>\n" +
                "</head>");
        writer.println("<body>");
        writer.println(list);
        writer.println("</body>");
        writer.println("</html>");


        writer.close();
    }
}
