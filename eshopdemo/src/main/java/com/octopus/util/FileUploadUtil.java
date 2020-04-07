package com.octopus.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadUtil {

	private static String fileLocation = "d:/upload/";// 上传的文件存放到哪里

	private static Random random = new Random();// 随机文件名

	/**
	 * 直接对包含文件上传数据的请求进行处理并自动处理文件相关的表单项
	 * 
	 * @param request
	 * @return 包含所有非文件表单元素的数据，和文件处理后真实保存的文件名
	 */
	public static Map<String, String> processFileUpload(HttpServletRequest request) {
		Map<String, String> data = new HashMap<String, String>();
		if (ServletFileUpload.isMultipartContent(request)) {
			
			// 文件上传标准步骤
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload();
			upload.setFileItemFactory(factory);
			upload.setHeaderEncoding("UTF-8");
			// 处理
			try {
				List<FileItem> list = upload.parseRequest(request);
				for (FileItem i : list) {
					if (i.isFormField()) {// 这只是一个普通表单元素
						String name = i.getFieldName();
						String value = i.getString();
						// 转码
						name = new String(name.getBytes("iso-8859-1"), "UTF-8");
						value = new String(value.getBytes("iso-8859-1"), "UTF-8");
						data.put(name, value);
					} else {
						// 文件处理
						DiskFileItem item = (DiskFileItem) i;
						// 得到文件的真实名称的扩展名
						String extName = item.getName().substring(item.getName().lastIndexOf('.'));
						// 生成一个随机的文件名
						String newFileName = fileLocation + random.nextLong() + extName;
						while (new File(newFileName).exists()) {
							newFileName = fileLocation + random.nextLong() + extName;
						}
						item.write(new File(newFileName));// 写入指定位置
						data.put(i.getFieldName(), newFileName.substring(newFileName.lastIndexOf('/')+1));

					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
			Map<String, String[]> parameterMap = request.getParameterMap();
			for(String key:parameterMap.keySet()){
				data.put(key, parameterMap.get(key)[0]);
			}
			
		}

		return data;
	}
	
	public static void outputImageFile(HttpServletResponse resp,String filePath){
		try {
			FileInputStream fis = new FileInputStream(fileLocation+ filePath);
			byte[] buffer = new byte[4096];
			resp.setContentType("image/jpeg");
			OutputStream os = resp.getOutputStream();
			int len =0;
			do{
				len = fis.read(buffer);
				if(len>0){
					os.write(buffer,0,len);
				}
			}while(len>0);
			fis.close();
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
