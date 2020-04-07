package com.octopus.crypt;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

//Des是java中一种标准支持的堆成加密技术
public class TestDes {
	
	
	public static void main(String[] args) {
		String content ="this is a secret";
		String pwd="111111     ";
		byte[] result =encrypt(content, pwd);
		System.out.println("加密后的内容"+Arrays.toString(result));
		byte[] result1=decrypt(result, pwd);
		try {
			System.out.println("解密后为："+new String(result1,"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 实现加密
	 * @param content 被加密内容
	 * @param pwd  密码
	 * @return
	 */
	public static byte[] encrypt(String content,String pwd) {
	
		try {	//加密解密基于字节而不是字符串
			byte[] contentByte =content.getBytes("UTF-8");
			byte[] passwordByte =pwd.getBytes("UTF-8");
		//密码处理
			DESedeKeySpec key = new DESedeKeySpec(passwordByte);
		//算法工厂类
			SecretKeyFactory factory =SecretKeyFactory.getInstance("DES");
			SecretKey keySecret =factory.generateSecret(key);
			//加密
			Cipher cipher =Cipher.getInstance("DES");//加密操作类
			cipher.init(Cipher.ENCRYPT_MODE, keySecret);//设定操作类为加密模式并传入加工过的key
			byte[] result =cipher.doFinal(contentByte);//加密操作
			return result;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 实现解密
	 * @param content 被解密的内容
	 * @param pwd  密码
	 * @return
	 */
	public static byte[] decrypt(byte[] content,String pwd) {
	
		try {	//加密解密基于字节而不是字符串
			byte[] contentByte =content;
			byte[] passwordByte =pwd.getBytes("UTF-8");
		//密码处理
			DESedeKeySpec key = new DESedeKeySpec(passwordByte);
		//算法工厂类
			SecretKeyFactory factory =SecretKeyFactory.getInstance("DES");
			SecretKey keySecret =factory.generateSecret(key);
			//加密
			Cipher cipher =Cipher.getInstance("DES");//加密操作类
			cipher.init(Cipher.DECRYPT_MODE, keySecret);//设定操作类为加密模式并传入加工过的key
			byte[] result =cipher.doFinal(contentByte);//加密操作
			return result;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
