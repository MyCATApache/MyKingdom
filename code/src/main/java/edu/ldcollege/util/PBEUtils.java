package edu.ldcollege.util;

import java.security.Key;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.apache.log4j.Logger;


/**
 * 
 * 对称加密 PBE算法
 * @author Raindrops at 2017/4/16
 *
 */
public class PBEUtils {
	
	private static Logger logger = Logger.getLogger(PBEUtils.class);
	
	/** 
	    * 支持以下任意一种算法 
	    *  
	    * <pre> 
	    * PBEWithMD5AndDES  
	    * PBEWithMD5AndTripleDES  
	    * PBEWithSHA1AndDESede 
	    * PBEWithSHA1AndRC2_40 
	    * </pre> 
	    */  
	   public static final String ALGORITHM = "PBEWithSHA1AndRC2_40";  
	 
	   public static final String raw = "mycatdom";
	   
	   /** 
	    * 初始化盐
	    * @return 
	    * @throws Exception 
	    */  
	   private static byte[] initSalt() throws Exception {  
	       byte[] salt = new byte[]{0b1,0x2,0x3,0x4,0x5,0x6,0x7,0x8};  
	       return salt;  
	   }  
	 
	   /** 
	    * 转换密钥<br> 
	    * @param password 
	    * @return 
	    * @throws Exception 
	    */  
	   private static Key keyGenerator(String password) throws Exception {  
	       PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());  
	       //创建一个密匙工厂，然后用它把PBEKeySpec转换成
	       SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);  
	       SecretKey secretKey = keyFactory.generateSecret(keySpec);  
	       return secretKey;  
	   }  
	 
	   /** 
	    * 加密 
	    * @param data 要加密的数据 
	    * @param password 口令密钥 
	    * @param salt 盐
	    * @return 
	    * @throws Exception 
	    */  
	   public static String encrypt(String data, String password ) {  
	       try {
			Key key = keyGenerator(password);  
			   PBEParameterSpec paramSpec = new PBEParameterSpec(initSalt(), 100); 
			   // 实例化Cipher对象，它用于完成实际的加密操作
			   Cipher cipher = Cipher.getInstance(ALGORITHM); 
			   // 初始化Cipher对象，设置为加密模式
			   cipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
			   byte[] buff = cipher.doFinal(data.getBytes());
			   if(logger.isTraceEnabled()) {
				   logger.trace(Arrays.toString(buff));
			   }
			   // 执行加密操作。加密后的结果通常都会用Base64编码进行传输 
			   return java.util.Base64.getEncoder().encodeToString(buff);
		} catch (Exception e) {
			return null;
		}
	   }  
	 
	   /** 
	    * 解密 
	    *  
	    * @param data 
	    *            要解密的数据 
	    * @param password 
	    *            口令密钥
	    * @param salt 
	    *            盐 
	    * @return 
	    * @throws Exception 
	    */  
	   public static String decrypt(String data, String password){  
	    // 执行解密操作
		byte[] buff;
		try {
			Key key = keyGenerator(password);  
			   PBEParameterSpec paramSpec = new PBEParameterSpec(initSalt(), 100); 
			   // 实例化Cipher对象，它用于完成实际的解密操作
			   Cipher cipher = Cipher.getInstance(ALGORITHM);
			   //初始化Cipher对象，设置为解密模式
			   cipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
			   buff = cipher.doFinal( java.util.Base64.getDecoder().decode(data));
	       System.out.println(Arrays.toString(buff));
	       return new String(buff);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	   }
	   
	   public static void main(String[] args) throws Exception {
		   String pwd= "abcd"; // 口令秘钥
		   String inputStr = "leader us";// 加密密码
	       System.out.println("原文: " + inputStr);  
	 
	       System.out.println("口令秘钥: " + pwd);  
	 
	       String encryptData = encrypt(inputStr, raw);  
	       System.out.println("加密后: " + encryptData);  
	 
	       String decryptData = decrypt(encryptData, raw);  
	       System.out.println("解密后: " + decryptData);  
	   }
}
