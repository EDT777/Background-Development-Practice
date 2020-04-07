package com.octopus.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

	private static final String MD5_SALT = "bgsuo";

	/**
	 * 根据盐获取md5密码
	 * 
	 * @param pwd 加密前的密码
	 * @return
	 */
	public static String md5(String pwd) {
		if(pwd==null || pwd.length()==0) {
			return "";
		}
		String result = "";
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			byte[] bytes = digest.digest((pwd + MD5_SALT).getBytes("UTF-8"));
			result = bytesToHexString(bytes);
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 验证数据库中的密码和传入密码是否吻合
	 * 
	 * @param md5 数据库中的md5密码
	 * @param pwd 实际密码
	 * @return
	 */
	public static boolean validatePassword(String md5, String pwd) {
		String result = md5(pwd);
		return result.equals(md5);
	}

	/**
	 * byte数组转为二进制字符串
	 * 
	 * @param arr
	 * @return
	 */
	public static String bytesToHexString(byte[] arr) {
		StringBuffer sb = new StringBuffer(arr.length);
		String sTmp;

		for (int i = 0; i < arr.length; i++) {
			sTmp = Integer.toHexString(0xFF & arr[i]);
			if (sTmp.length() < 2)
				sb.append(0);
			sb.append(sTmp.toUpperCase());
		}

		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(md5("111111"));
	}

}
