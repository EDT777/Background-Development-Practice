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

@WebServlet("/ServletRegister")
public class register extends HttpServlet {
    IStudentDao studentDao = new StudentDaoImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

         req.setCharacterEncoding("UTF-8");
         resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h3>请录入个人信息</h3>\n" +
                "        <form action=\"/ServletRegister\" method=\"get\">\n" +
                "            <p>编号: <input type=\"text\" name=\"number\"></p>\n" +
                "            <p>姓名：<input type=\"text\" name=\"name\"></p>\n" +
                "            <p>分数：<input type=\"text\" name=\"score\"></p>\n" +
                "            <p>性别: <input type=\"radio\" name=\"sex\" value=\"男\">男\n" +
                "            <input type=\"radio\" name=\"sex\" value=\"女\">女\n" +
                "            </p>\n" +
                "\n" +
                "            <input type=\"submit\" value=\"注册\">\n" +
                "        </form>\n" +
                "<span style=\"color:red\">\n" +
                "    2020年08月23号 14:40、；01\n" +
                "</span>\n" +
                "</body>\n" +
                "</html>");
        Long number = Long.valueOf(req.getParameter("number"));
         String name = req.getParameter("name");
         Double score = Double.valueOf(req.getParameter("score"));
         String sex = req.getParameter("sex");
         try {
             Student stu = new Student(number,name,sex,score);
             studentDao.insert(stu);
         }catch (Exception e){
             e.printStackTrace();
         }

        System.out.println("注册成功!");
    }
}
