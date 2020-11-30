package com.edt.webcrud_product.web.servlet;

import com.edt.webcrud_product.domain.User2;
import com.edt.webcrud_product.service.IUserService;
import com.edt.webcrud_product.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/replaceImg")
@MultipartConfig
public class ReplaceImgServlet extends HttpServlet {
    private IUserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取上传的文件
        //保存到项目的upload目录,文件名随机
        Part part = req.getPart("headImg");
        String cd = part.getHeader("Content-Disposition");//文件名在这里面
        String fileName = cd.substring(cd.lastIndexOf("=") + 2, cd.length() - 1);
        String extName = fileName.substring(fileName.lastIndexOf(".")); //获取文件扩展名
        String saveFileName = UUID.randomUUID().toString() + extName;
        String saveDir = this.getServletContext().getRealPath("/upload"); //通过相对路径 获取绝对路径
        part.write(saveDir + "/" + saveFileName);//存到该位置

        String headImg = "/upload/" + saveFileName; //编写用户的headImg属性值

        //获取当前操作的用户
        User2 user = (User2) req.getSession().getAttribute("USER_IN_SESSION");
        user.setHeadImg(headImg);

        //修改数据库对应用户的headImg 字段 为新的头像路径
        userService.updateHeadImg(user);
        resp.sendRedirect("/product");
    }
}
