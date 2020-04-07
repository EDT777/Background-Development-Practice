package com.octopus.spring1.controller;

import java.io.FileInputStream;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.octopus.spring1.util.UploadUtil;

@Controller
@RequestMapping("/file")
public class FileUploadDownloadController {
//上传
	@ResponseBody
	@RequestMapping("/upload")
	public String upload(MultipartFile file) {
		String result = "";
		System.out.println(file.getOriginalFilename());// 得到上传文件的原始文件名
		result = UploadUtil.saveFile(file);
		return result;
	}

	// 下载
	@RequestMapping("/download")
	public ResponseEntity<byte[]> download(String fileName) {
		// 查找文件名
		String fullFileName = UploadUtil.basePath + fileName;
		// 使用流转文件为字节数组
		// 为浏览器能识别内容格式，我们要传递headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);

		try (FileInputStream fis = new FileInputStream(fullFileName)) {
			byte[] data = StreamUtils.copyToByteArray(fis);
			ResponseEntity<byte[]> resp = new ResponseEntity<byte[]>(data, headers, HttpStatus.OK);
			return resp;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
