package com.edt.forward_redirect_scope_el_jstl.forward;
//一般不跨域 就用转发
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
//转发可以不加上下文项目路径   重定向必须加
//转发的地址栏不会发生变化，是服务器跳转     重定向会发生变化，是浏览器跳转
//转发的数据不会丢失，同一个请求    重定向会丢失，因为不是同一个请求
@WebServlet("/forward/one")
public class  OneServlet extends HttpServlet {//转发操作
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        String username = req.getParameter("username");
        System.out.println("oneSerlvet begin username: " + username);//执行
        writer.println("oneSerlvet begin");//不执行，有跳转
        req.getRequestDispatcher("/forward/two").forward(req, resp);//执行
        //可以访问web-inf下的资源   不可进行跨域操作
        // req.getRequestDispatcher("/WEB-INF/hello.jsp").forward(req, resp);
        //处理输出操作
        System.out.println("oneSerlvet end");//执行
        writer.println("oneSerlvet end");//不执行，有跳转
    }
}
