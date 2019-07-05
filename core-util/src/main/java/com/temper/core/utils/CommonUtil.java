package com.temper.core.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

//import org.apache.commons.codec.digest.DigestUtils;


/**
 * 
 * 
 * @Title:CommonUtil
 * @Package com.lunz.uc.users.util
 * @Description: 公共工具类
 * @author chenxiaojun
 * @date 2019/04/24
 */
public class CommonUtil {

	/**
	 * 分割-逗号
	 */
	public static final String COMMON_SPLIT = ",";

	/**
	 * 判断对象是否为null和空
	 * 
	 * @param object
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isObjectNull(Object object) {
		if (object == null) {
			return true;
		} else if (object instanceof java.util.Collection) {
			return ((java.util.Collection) object).isEmpty() ? true : false;
		} else if (object instanceof java.util.Map) {
			return ((java.util.Map) object).isEmpty() ? true : false;
		} else if (object instanceof String) {
			return ((String) object).trim().length() == 0 ? true : false;
		}
		return false;
	}

	/**
	 * 判断对象是否为null字符串和空
	 * @param str
	 * @return
	 */
	public static boolean isNullStr(String str) {
		return str.toLowerCase().trim().equals("null");
	}
	
	
	public static List<String> splitStr(String str, String separator) {
		List<String> list = new ArrayList<String>();
		if (CommonUtil.isObjectNull(str)) {
			return null;
		}
		String[] split = str.split(separator);
		list.addAll(Arrays.asList(split));
		return list;
	}

	/**
	 * MD5方法
	 * 
	 * @param text 明文
	 * @param key  密钥
	 * @return 密文
	 * @throws Exception
	 */
	public static String md5(String text, String key) throws Exception {
		// 加密后的字符串
		String encodeStr="";// = DigestUtils.md5Hex(text + key);
		System.out.println("MD5加密后的字符串为:encodeStr=" + encodeStr);
		return encodeStr;
	}

	/**
	 * MD5验证方法
	 * 
	 * @param text 明文
	 * @param key  密钥
	 * @param md5  密文
	 * @return true/false
	 * @throws Exception
	 */
	public static boolean verify(String text, String key, String md5) throws Exception {
		// 根据传入的密钥进行验证
		String md5Text = md5(text, key);
		if (md5Text.equalsIgnoreCase(md5)) {
			System.out.println("MD5验证通过");
			return true;
		}
		return false;
	}
	
	/**
	 * 生成UUID
	 * @Description: TODO
	 */
	public static String getUUID() {
		
		return UUID.randomUUID().toString();
	}	

	public static String getDate(Date date,String dateFormate) {
		
		SimpleDateFormat fmtDateFormat = new SimpleDateFormat(dateFormate);
		return fmtDateFormat.format(date);
	}
}


