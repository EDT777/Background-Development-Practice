package com.octopus.spring1.util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class UploadUtil {
//	文件上传的保存路径
	public final static String basePath="d:\\uploadFiles\\";
	/**
	 * 管理上传文件的保存：找一个合适的文件名存放在指定文件夹
	 * @param file
	 * @return 如果保存成功，则返回新文件名。否则返回空
	 */
	public static String saveFile(MultipartFile file) {
		try {
			int i=file.getOriginalFilename().lastIndexOf('.');
			String extName ="";//得到文件的扩展名，然后使用新的文件名（扩展名不变）
			if(i>-1) {
				extName =file.getOriginalFilename().substring(i);
			}
			//生成随机的新的文件名
			String newFileName = Math.random()+extName;
			File toSave = new File(basePath+newFileName);
			while(toSave.exists()) {
				newFileName=Math.random()+extName;
				toSave = new File(basePath+newFileName);
			}
			file.transferTo(toSave);
			return newFileName;
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}
