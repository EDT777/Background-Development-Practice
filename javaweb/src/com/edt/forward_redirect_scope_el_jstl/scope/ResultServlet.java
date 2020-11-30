package com.edt.forward_redirect_scope_el_jstl.scope;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        Object reqNum = req.getAttribute("num");
        Object sessionNum = req.getSession().getAttribute("num");
        Object appNum = req.getServletContext().getAttribute("num");
        writer.println("<br> request:" + reqNum);
        writer.println("<br> session:" + sessionNum);
        writer.println("<br> servletContext:" + appNum);
    }
}
