package com.edt.file_upload_download.download;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;

@WebServlet("/download")
public class downloadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
//            获取下载的文件名
        String name = req.getParameter("name");

        String header = req.getHeader("User-Agent");
//        防止下载文件到浏览器后乱码问题
        String downloadFileName = header.contains("MSIE")?
                URLEncoder.encode(name,"UTF-8"):
                new String(name.getBytes("UTF-8"),"ISO-8859-1");
//    设置文件下载头
        resp.setHeader("Content-Disposition", "attachment;filename=" + downloadFileName);
//        获取下载文件路径,利用响应对象的输出流,写回浏览器
        Files.copy(Paths.get(this.getServletContext().getRealPath("/WEB-INF/download"), name)
                , resp.getOutputStream());
    }
}
