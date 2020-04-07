package com.cotopus;

import java.io.File;

public class FileUploadDownUtil {
	
		public static String fileStoreLocation="F:\\upload\\";
	/**
	 * 根据原来的文件夹生成一个随机的文件名且文件名的后缀不变
	 *  orignalName 原文件名
	 *  basePath 要保存文件的路径，用来判断是否重名
	 *
	 */
		public static String genRandomFileName(String orignalName,String basePath) {
			//获取后缀
			int dotIndex =orignalName.lastIndexOf(".");
			String ext="";
			if(dotIndex>-1) {
				ext =orignalName.substring(dotIndex);
			}
			//生成随机名
			long random=(long)(Math.random()*899999999999L+100000000000L);
			String newFileName =random+ext;
			//判断是否存在
			while(new File(basePath+newFileName).exists()) {
				//重新生成
				random=(long)(Math.random()*899999999999L+100000000000L);
				 newFileName =random+ext;
			}
			return newFileName;
		}
		/**
		 * 判断指定的文件在basepath下是否存在
		 * @param filename要判断的文件名
		 * @param basePath文件夹名字
		 * @return
		 */
		public static boolean isExists(String filename,String basePath) {
			return new File(fileStoreLocation+basePath+filename).exists();
			
		}
}
