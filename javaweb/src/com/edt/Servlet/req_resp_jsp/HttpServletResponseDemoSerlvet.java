package com.edt.Servlet.req_resp_jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/resp")
public class HttpServletResponseDemoSerlvet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//         通知浏览器给的数据格式，并处理响应数据中文乱码问题
            resp.setContentType("text/html;charset=utf-8"); //可一句表达 要放在第一行！
//           处理响应数据中文乱码问题
//            resp.setCharacterEncoding("UTF-8");

        PrintWriter writer = resp.getWriter();
        writer.println("<h3>hello 浏览器</h3>");
    }
}
