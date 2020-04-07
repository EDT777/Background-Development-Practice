package com.octopus.crypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class TestMD5 {
//MD5和SHA都是单项散列摘要算法：不同的值得到的一般都是不同结果
	public static void main(String[] args) {
		try {
			MessageDigest digist =MessageDigest.getInstance("MD5");
			String pwd1="123456";
			byte[] data =digist.digest(pwd1.getBytes());
			System.out.println(Arrays.toString(digist.digest()));
		//base64:将字节数组转为字符串形式
			System.out.println(Base64.getEncoder().encodeToString(data));
		
		
		
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
