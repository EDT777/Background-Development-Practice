package com.octopus.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class MD5Util {
	/**
	 * 验证MD5密码是否正确
	 * 
	 * @param userPwd 用户提供的密码
	 * @param dbPwd   数据库的密码
	 * @param salt    加密的盐(可以是用户名)
	 * @return
	 */
	public static boolean validatePwd(String userPwd, String dbPwd, String salt) {
		boolean result = false;
		String toMd5 = userPwd + salt;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] digest = md.digest(toMd5.getBytes("UTF-8"));
			String encodePwd = Base64.getEncoder().encodeToString(digest);//这是根据用户输入和盐转化后得到的散列密码
			return encodePwd.equals(dbPwd);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String toMd5 ="123456user1";
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] digest = md.digest(toMd5.getBytes("UTF-8"));
		String encodePwd = Base64.getEncoder().encodeToString(digest);
		System.out.println(encodePwd);
	}
}
