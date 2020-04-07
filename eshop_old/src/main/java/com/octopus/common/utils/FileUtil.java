package com.octopus.common.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

/**
 * 文件上传处理相关操作
 * @author jason@www.zyejy.com
 *
 */
public class FileUtil {

	
	/**
	 * 保存文件，并在保存过程中检查对应文件夹是否存在
	 * @param file 文件内容
	 * @param filePath 文件路径
	 * @param fileName 文件名
	 * @throws Exception
	 */
	public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
		File targetFile = new File(filePath);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		FileOutputStream out = new FileOutputStream(filePath + fileName);
		out.write(file);
		out.flush();
		out.close();
	}

	/**
	 * 删除指定文件
	 * @param fileName 要删除的文件名
	 * @return 是否删除了文件
	 */
	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile()) {
			if (file.delete()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	
	/**
	 * 为指定的文件生成uuid文件名，保持扩展名不变
	 * @param fileName 原文件名
	 * @return
	 */
	public static String renameToUUID(String fileName) {
		return UUID.randomUUID() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
	}
}
