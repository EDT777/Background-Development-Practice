package cn.wolfcode.util;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

public class FileUploadUtil {

	/**
	 * 上传文件
	 * @param file
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public static String uploadFile(MultipartFile file, String path)
			throws Exception {
		//生成uuid值
		String uuid = UUID.randomUUID().toString();
		//获取当前文件的文件名
		String fileName = file.getOriginalFilename();
		//获取文件名后缀 .jpg
		String fileType = fileName.substring(fileName.lastIndexOf("."));
		fileName = "/upload/" + uuid + fileType;
		//拼接最终路径
		File targetFile = new File(path, fileName);
		FileUtils.copyInputStreamToFile(file.getInputStream(),targetFile);
		return fileName;
	}

	/**
	 * 删除文件
	 * @param pic
	 */
	public static void deleteFile(String pic) {
		File file=new File(pic);
		if(file.exists()) file.delete();
	}
}
