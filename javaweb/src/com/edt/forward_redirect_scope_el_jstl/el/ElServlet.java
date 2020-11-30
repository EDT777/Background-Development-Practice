package com.edt.forward_redirect_scope_el_jstl.el;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/el")
public class ElServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Person person = new Person();
        req.setAttribute("p",person);
        req.getRequestDispatcher("/personEl.jsp").forward(req,resp);

    }
}
