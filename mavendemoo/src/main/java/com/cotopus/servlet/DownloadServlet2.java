package com.cotopus.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
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

@WebServlet("/down")
public class DownloadServlet2 extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 得到要下载的文件名
		String filename = req.getParameter("filename");
		// 检查文件是否存在
		String basePath = "images\\";
		if (FileUploadDownUtil.isExists(filename, basePath)) {
			//判断内容类型，如果是浏览器能识别的直接显示,否则启用文件下载
			String lowerName=filename.toLowerCase();
			String contentType="application/octet-stream";//默认认为文件只能下载不能显示
			if(lowerName.endsWith(".jpg")) {
				contentType="image/jpeg";
			}else if(lowerName.endsWith(".png")) {
				contentType="image/png";
			}else if(lowerName.endsWith(".gif")) {
				contentType="image/gif";
			}else if(lowerName.endsWith(".css")) {
				contentType="text/css";
			}else if(lowerName.endsWith(".txt")) {
				contentType="text/plain";
			}
			//如果是浏览器不能显示的文件，还要考虑文件名的问题
			if(contentType.equals("application/octet-stream")) {
				resp.addHeader("Content-Disposition", "attachment;filename*=utf-8''"+URLEncoder.encode(filename,"UTF-8"));
				
			}
			resp.setContentType(contentType);//告诉浏览器我们认为的真实文件类型
			// 读取
			try (FileInputStream fis = new FileInputStream(
					FileUploadDownUtil.fileStoreLocation + basePath + filename)) {
				// 要讲文件的数据写入resp的输出流中
				OutputStream os = resp.getOutputStream();
				byte[] buffer = new byte[4096];
				int len = 0;
				while ((len = fis.read(buffer)) > 0) {
					os.write(buffer, 0, len);
				}
				os.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
