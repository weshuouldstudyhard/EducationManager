package cn.edu.fjnu.cdio4.xplan.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;


/**
 *类的作用：MD5加密
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-11-13   上午01:30:38
 */
public class Md5Encode {
	public static String EncoderByMd5(String str) {
		// 确定计算方法
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BASE64Encoder base64en = new BASE64Encoder();
		// 加密后的字符串
		String newstr = null;
		try {
			newstr = base64en.encode(md5.digest(str.getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newstr;
	}

}
