package com.cotopus.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.cotopus.FileUploadDownUtil;
@WebServlet("/upload")
public class UploadServlet extends HttpServlet{

		
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 //第一步：判断提交的表达是不是一个multipart表单
			boolean hasFile =ServletFileUpload.isMultipartContent(req);
			if(hasFile) {
				//创建一个工厂类
				FileItemFactory factory = new DiskFileItemFactory();
				//创建一个真正的文件传输对象ServletFileUpload
				ServletFileUpload upload =new ServletFileUpload(factory);
				//第三步:解析请求并获得文件
				
				//如果要让文件可以下载，则最简单的办法就会访问项目运行的根目录下
			//	String servletRootPath =req.getServletContext().getRealPath("/");
				//System.out.println(servletRootPath);
				try {
					List<FileItem> items =upload.parseRequest(req);
					for(FileItem fi:items) {
						//一个FileItem可能是文件也可能是普通表单
						if(fi.isFormField()){//这是一个普通表单而不是文件
							System.out.println("表单项目:"+fi.getFieldName()+"="+fi.getString("UTF-8"));
						}else {
							//String basePath =servletRootPath+"images\\";
							String basePath =FileUploadDownUtil.fileStoreLocation+"images\\";
							String realFileName =fi.getName();//真实文件名
							String fieldName =fi.getFieldName();
							System.out.println("文件上传"+fieldName+"="+realFileName);
							String newFileName =FileUploadDownUtil.genRandomFileName(realFileName, basePath);
							//将文件搬到根目录下
							fi.write(new File(basePath+newFileName));
							//返回真正存放的文件名
							resp.getWriter().write(newFileName);
						}
					}
				
					
				
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		}
}
