package com.octopus.crypt;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;

//演示非对称加密
public class Rsa {
	
	public static void main(String[] args) {
		String privateKey="MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCBZkkkaarcNkvjLvdgPUB7RXQNLilPRS2AnxP6EigkSllHTk+fbClDCa21ytys+Ig2YybBr47XID8lfHV1Gy5SH//twTumuiSOvFJIzazzdIuCGbMQH485l/O8/TmrFjMRRwTebEJ4JyulbRKC5Yv7j1BccF0KffTrEew7fYLz6Kkqsxz/6NN+spmvITzAAGl8JQHoyhkySKCT52njDyIU9vKyHw2ibWYs0MKLWf6wn6XRYMp7uMziu2rHKXUXDLzzVP2Q3eyE3rZIG6VMoLVYQkszmFgFcCXXKaZa6rPYu0ti00scZr76H/Fb1JKW4+ACpdXmvdUjia7N1Ha/Nrx3AgMBAAECggEAcdvQzAt2XiIgkBxJaxM6Y71vKhHOI4QZT62p5EaJr7UD7axIf1yqyeQAR4/isQhWwpRoC9Ev/LbRGWjz6UErdvPVPBzlIgV0GWw3cvwXDHkmMCnw12UNn33G6CpgzdvQv4kgDZ5wtkyxKPRab3cPvyARc+Ui2RKPqS+yD36W9YolKq0ppAzxF7pUQNBDKBTNXi1urX39ZsEbWYZGfcMWI1NuGbiGvbxWpO/wJCCdFSwMnCa5T5YmjJfiSY/0NlrTkYek6jk5BKlGFY2kntOrtF2FAS9Tl/buUoA8bcKLxoVdKg/mYkuTgBEchPypaAoCZ8v4w5PW832pnXKpMRs2wQKBgQDTrID0Hnr+E+JlqcQDtHPIcnOO1ir23aYOtDb5YR+sJvSJRhEnO7G5ltH4VbvK8xGkDo+AJLr6JXJizxa1G+HOcHiSADneVI+XICF2a9y3sAIRH7zWVg2yliqEyouoxGZBMHb4A2koKBH0/nq9TX7cnFJhg5Rj05qlE9jRD3uuhwKBgQCcfzBbHGhizIawAdQAno3tg8fkHw7HrPVPYx0Wl7d9XAA4p7LflM8QR4ODVJMf/sFGB0+XrlDo3KJUT4lROgY+w6lP8+nD/WNqRnoUiqiUdAMQbuqEXFk3DwiZvwrW8Fm/N/DNJwcrkTXttJjIECyB1V7TZoY0gUCVhpwJ0laOkQKBgCcQnA/xnCNOCidXCGzincetj7QZxH4g8+eczNSDXzQHUHQRMVM7ShaFRiT9tZXD/Ep5wXQV00gdJxojO/6asbbGvQm87vEgTAvJC0PuriJcYlVEtTYdVZPS8O/m7ZVtAa4gQqSNBJg7pOzBFmffaH1QgEes3/L4d37lxcr3f4z7AoGAZxYZIksqL7qOFi5+GhJXZ1dhOtGCiOFTjgG5zYIO6lLKCofc+g4p/408AiyZ5X+IjLqQIVhAD8QWYfcqewj/yCRWyUXgfKvS6tSV4iYcOf3Zbt/BN4MleXE7txry5vbYB2+v/VNyE67JmVVXNqIAz11f410rljZ19oj/DDEztyECgYBNK02jPG+w0AOAUVLG1d2U4UYfnRFS22mwcXle+iMvw8rrclUD+ffBufBM8TYCHtTJ8ChqQypWteqohciT72ea98mnewrxGHu+9Tknt41jDgVpu9VDluZFizobLK7fEd750X8qoVcixVaLWLFRmCrBQqL3OhCS2Z778qigHYpaqA==";
		String publicKey="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgWZJJGmq3DZL4y73YD1Ae0V0DS4pT0UtgJ8T+hIoJEpZR05Pn2wpQwmttcrcrPiINmMmwa+O1yA/JXx1dRsuUh//7cE7prokjrxSSM2s83SLghmzEB+POZfzvP05qxYzEUcE3mxCeCcrpW0SguWL+49QXHBdCn306xHsO32C8+ipKrMc/+jTfrKZryE8wABpfCUB6MoZMkigk+dp4w8iFPbysh8Nom1mLNDCi1n+sJ+l0WDKe7jM4rtqxyl1Fwy881T9kN3shN62SBulTKC1WEJLM5hYBXAl1ymmWuqz2LtLYtNLHGa++h/xW9SSluPgAqXV5r3VI4muzdR2vza8dwIDAQAB";
		byte[] data=new byte[] {1,2,3,4,5,6};
		byte[] result=encrypt(data, publicKey);
		System.out.println(Arrays.toString(result));
		byte[] result2=decrypt(result,privateKey );
		System.out.println(Arrays.toString(result2));
	}
	//加密用公钥
	public static byte[] encrypt(byte[] source, String base64PublicKey) {

		try {
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(base64PublicKey));
			RSAPublicKey key = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(keySpec);
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			return cipher.doFinal(source);

		} catch (Exception e) {
			return null;
		}

	}
	//解密用私钥
	public static byte[] decrypt(byte[] source, String base64PrivateKey) {

		try {
			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(base64PrivateKey));
			RSAPrivateCrtKey key = (RSAPrivateCrtKey) KeyFactory.getInstance("RSA").generatePrivate(keySpec);
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, key);
			return cipher.doFinal(source);

		} catch (Exception e) {
			return null;
		}

	}
}
