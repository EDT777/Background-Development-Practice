package com.edt.file_upload_download.upload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

@WebServlet("/fileUpload")
@MultipartConfig( maxFileSize = 80000 , maxRequestSize = 111111) //单个文件上传不超8w字节,多个文件一起不超111111字节
public class FileUploadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        try {
            Collection<Part> parts = req.getParts();
            for (Part part : parts){  //遍历所有
                String contentType = part.getContentType(); //看类型
                if (contentType!=null){ //type file
                    if (!contentType.startsWith("image/")){ //判断是否为问类型
                        req.setAttribute("errorMsg","您上传文件不图片类型文件");
                        req.getRequestDispatcher("/register_file.jsp").forward(req,resp);
                        return;
                    }else {//若是图片类型 执行以下操作
                        String cd = part.getHeader("Content-Disposition");//文件名在这里面
                        System.out.println(cd);
                        //        获取上传文件名
                        String fileName = cd.substring(cd.lastIndexOf("=") + 2,cd.length()-1);
                        //        获取文件扩展名
                        String extName = fileName.substring(fileName.lastIndexOf("."));
                        //        随机生成文件名
                        String saveFileName = UUID.randomUUID().toString() + extName;
                        // 把相对路径 转成一个磁盘绝对路径
                        // System.out.println("图片目录绝对路径: "+this.getServletContext().getRealPath("/upload"));
                        String saveDir = this.getServletContext().getRealPath("/upload");
                        //        保存到哪里
                        part.write(saveDir+"/" + saveFileName);
                    }
                }else { // type not file
                    System.out.println(req.getParameter(part.getName()));
                }
            }
        }catch (Exception e){
           req.setAttribute("errorMsg","你上传的文件太大了");
           req.getRequestDispatcher("/register_file.jsp").forward(req,resp);
        }




    }
}
