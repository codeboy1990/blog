package com.blog.common.utils;

import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.SystemException;

/**
 * 字符串工具类
 * @author sfit0254
 * @date 2014-4-9
 */
public class StringUtils {

	/**
	 * 获取毫秒类型主键，附加七位纳秒值
	 * @return
	 */
	public static String getKey() {
		Long curMillis = System.currentTimeMillis();
		Long curNanos = Math.abs(System.nanoTime());
		String nanos = curNanos.toString();
		return curMillis + nanos.substring(nanos.length() - 6);
	}

	/**
	 * 获取6位随机数字
	 * @return			返回6位数字
	 */
	public static int getSixNum(int num) {
		int ranNum = 0;
		switch (num) {
		case 3:
			ranNum = (int)((Math.random()*9+1)*100);
			break;
		case 4:
			ranNum = (int)((Math.random()*9+1)*1000);
			break;
		case 5:
			ranNum = (int)((Math.random()*9+1)*10000);
			break;
		default:
			ranNum = (int)((Math.random()*9+1)*100000);
			break;
		}
		return ranNum;
	}


	/**
	 * 检查用户名是否合法
	 * 只能包含字母与数字，且5-25位
	 * @param userName
	 * @return
	 */
	public static boolean checkUserName(String userName) {
		Pattern p = Pattern.compile("^[a-zA-Z0-9]{5,25}$");
		Matcher m = p.matcher(userName);
		return m.matches();
	}

	/**
	 * 判断字符串是否包含不可见字符
	 * @param str		校验字符串
	 * @return			包含返回false，不包含返回true
	 */
	public static boolean isValid(String str) {
		Pattern p = Pattern.compile("[^\\s*|\t|\r|\n]{1,}");
		Matcher m = p.matcher(str);
		return m.matches();
	}

	/**
	 * 密码加密
	 * @param password	需加密的密码
	 * @return			加密后的密码:盐值
	 */
	public static String encryptPwd(String password) {
		SecureRandom random = new SecureRandom();
        byte[] salt = new byte[24];
        random.nextBytes(salt);
        password = MD5(password + salt);
        return password + ":" + salt;
	}

	/**
	 * MD5加密
	 * @param s		需加密的字符串
	 * @return		加密后的32位字符串
	 */
	public static String MD5(String s) {
		char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

	/**
	 * 将javaBean对象转换成Json字符串
	 * @param object	需要转换的javaBean
	 * @param fields	指定属性值，多个以,隔开
	 * @return
	 * @throws SystemException
	 */
	public static String beanToJson(Object object, String fields) throws Exception {
		String fs[] = fields.split(",");
		Class<?> classes = object.getClass();
		StringBuffer json = new StringBuffer("{");
		try {
			for (String s : fs) {
				Field field = classes.getDeclaredField(s);
				field.setAccessible(true);

				json.append("\"" + field.getName() + "\":\"");

				if (field.get(object) == null) {
					json.append("");
				} else {
					json.append(field.get(object));
				}

				field.setAccessible(false);
				json.append("\",");
			}
		} catch (Exception e) {
			throw new Exception("The system parses the JSON error");
		}
		json.delete(json.length() - 1, json.length());
		json.append("}");
		return json.toString();
	}

	/**
	 * 将javaBean对象转换成Json字符串
	 * @param object	需要转换的javaBean
	 * @return
	 * @throws SystemException
	 */
	public static String beanToJson(Object object) throws Exception {
		Class<?> classes = object.getClass();
		Field fields[] = classes.getDeclaredFields();
		StringBuffer json = new StringBuffer("{");
		try {
			for (Field field : fields) {
				field.setAccessible(true);
				json.append("\"" + field.getName() + "\":\"");

				if (field.get(object) == null) {
					json.append("");
				} else {
					json.append(field.get(object));
				}
				field.setAccessible(false);
				json.append("\",");
			}
		} catch (Exception e) {
			throw new Exception("The system parses the JSON error");
		}

		json.delete(json.length() - 1, json.length());
		json.append("}");
		return json.toString();
	}

	/**
	 * 获取客户端IP
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ipAddress = null;
		 ipAddress = request.getRemoteAddr();
		ipAddress = request.getHeader("x-forwarded-for");
		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			if (ipAddress.equals("127.0.0.1")) {
				// 根据网卡取本机配置的IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ipAddress = inet.getHostAddress();
			}
		}
		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (ipAddress != null && ipAddress.length() > 15) {
			if (ipAddress.indexOf(",") > 0) {
				ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
			}
		}
		return ipAddress;
	}

	final static char[] digits = {  
        '0' , '1' , '2' , '3' , '4' , '5' ,  
        '6' , '7' , '8' , '9' , 'a' , 'b' ,  
        'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,  
        'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,  
        'o' , 'p' , 'q' , 'r' , 's' , 't' ,  
        'u' , 'v' , 'w' , 'x' , 'y' , 'z' ,  
        'A' , 'B' , 'C' , 'D' , 'E' , 'F' ,  
        'G' , 'H' , 'I' , 'J' , 'K' , 'L' ,  
        'M' , 'N' , 'O' , 'P' , 'Q' , 'R' ,  
        'S' , 'T' , 'U' , 'V' , 'W' , 'X' ,  
        'Y' , 'Z', '+', '/' };  

    /** 
     * 把10进制的数字转换成64进制 
     * @param number 
     * @param shift 
     * @return 
     */  
    public static String CompressNumber(long number, int shift) {  
        char[] buf = new char[64];  
        int charPos = 64;  
        int radix = 1 << shift;  
        long mask = radix - 1;  
        do {  
            buf[--charPos] = digits[(int)(number & mask)];  
            number >>>= shift;  
        } while (number != 0);  
        return new String(buf, charPos, (64 - charPos));  
       }  
    /** 
     * 把64进制的字符串转换成10进制 
     * @param decompStr 
     * @return 
     */  
    public static long UnCompressNumber(String decompStr)  
    {  
        long result=0;  
        for (int i =  decompStr.length()-1; i >=0; i--) {  
            if(i==decompStr.length()-1)  
            {  
                result+=getCharIndexNum(decompStr.charAt(i));  
                continue;  
            }  
            for (int j = 0; j < digits.length; j++) {  
                if(decompStr.charAt(i)==digits[j])  
                {  
                    result+=((long)j)<<6*(decompStr.length()-1-i);  
                }  
            }  
        }  
        return result;  
    }     
    
    /** 
     *  
     * @param ch 
     * @return 
     */  
    private static long getCharIndexNum(char ch)  
    {  
        int num=((int)ch);  
        if(num>=48&&num<=57)  
        {  
            return num-48;  
        }  
        else if(num>=97&&num<=122)  
        {  
            return num-87;  
        }else if(num>=65&&num<=90)  
        {  
            return num-29;  
        }else if(num==43)  
        {  
            return 62;  
        }  
        else if (num == 47)  
        {  
            return 63;  
        }  
        return 0;  
    }

    
    
    private static final int USERID_LEN_32 = 32;
	private static final int WAYBILLID_LEN_20 = 20;

	private StringUtils() {
	}

	/**
	 * 把字符串的回车转换成"\\n"
	 * @param s 待转换的字符串
	 * @return 转换后的字符串
	 */
	public static String convert(final String s) {
		String str;
		str = s.replace("\r\n", "\n").replace("\r", "\n");
		String[] split = str.split("\n");
		str = "";
		for (int i = 0; i < split.length; i++) {
			str += split[i] + (i == split.length - 1 ? "" : "\\\\n");
		}
		return str;
	}

	/**
	 * 判断是否不为空串
	 * @param s 待判断的字符串
	 * @return 是否不为空串
	 */
	public static boolean isNotEmpty(final String s) {
		return (s != null) && (!"".equals(s.trim()));
	}

	/**
	 * 判断是否为空串
	 * @param s 待判断的字符串
	 * @return 是否为空串
	 */
	public static boolean isEmpty(final String s) {
		return (s == null) || ("".equals(s.trim()));
	}

	/**
	 * 首字母大写
	 * @param name
	 * @return
	 */
	public static String initialString(final String name) {
		if (name == null) {
			return "";
		}
		String s = name.trim();
		if (!"".equals(s)) {
			String i = s.substring(0, 1);
			s = i.toUpperCase() + s.substring(1);
		}
		return s;
	}

	/**
	 * 逗号分割字符串
	 * @param name
	 * @return
	 */
	public static List<Long> getListIds(final String listIds) {
		List<Long> list = new ArrayList<Long>();
		String[] stringList = listIds.split(",");
		for (int i = 0; i < stringList.length; i++) {
			list.add(i, Long.parseLong(stringList[i]));
		}
		return list;
	}

	/**
	 * 判断字符是否为空
	 * @param str
	 * @return
	 */
	public static boolean checkedIsEmpty(final String str) {
		if (str == null || str.equals("")) {
			return true;
		}

		return false;
	}

	/**
	 * 判断字符串是否相同，null == ""
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean checkedEqualString(final String str1, final String str2) {
		if ((str1 == null && str2 == null) || (str1 == null && str2.equals("")) || (str2 == null && str1.equals(""))
				|| str1.equals(str2)) {
			return true;
		}

		return false;
	}

	// 判断电话
	public static boolean isTelephone(final String phonenumber) {
		if (isEmpty(phonenumber)) {
			return false;
		}
		String phone = "0\\d{2,3}-\\d{7,8}";
		Pattern p = Pattern.compile(phone);
		Matcher m = p.matcher(phonenumber);
		return m.matches();
	}

	// 判断手机号
	public static boolean isMobile(final String mobile) {
		if (isEmpty(mobile)) {
			return false;
		}
		Pattern p = Pattern.compile("^((13[0-9])|(14[0-9])|(15[0-9])|(17[0-9])|(18[0-9]))\\d{8}$");
		Matcher m = p.matcher(mobile);
		return m.matches();
	}

	// 判断邮箱
//	public static boolean isEmail(final String email) {
//		String str = "^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$";
//		Pattern p = Pattern.compile(str);
//		Matcher m = p.matcher(email);
//		return m.matches();
//	}

	//不足32位前面补 0
	public static String fillBeginWith0(String str) {
		if (null != str && !"".equals(str)) {
			int len = str.length();
			for (int i = 0; i < USERID_LEN_32 - len; i++) {
				str = "0" + str;
			}
		}
		return str;
	}

	/**
	 * <p>Description: 不足32位前面补 0</p>
	 * @author 050940
	 * @return String
	 * @2013-11-9 下午3:46:54
	 */
	public static String fillLeftWith0(final String str) {
		if (isNotEmpty(str) && str.length() < USERID_LEN_32) {
			StringBuilder sb = new StringBuilder();
			int len = str.length();
			for (int i = 0; i < USERID_LEN_32 - len; i++) {
				sb.append("0");
			}
			return sb + str;
		}
		return str;
	}

	//截掉左边起所有为0的字串,如：截取0000000002343023434后，结果为：2343023434
	public static String getOrigiSubStr(final String str) {
		String origStr = null;
		if (!isEmpty(str)) {
			int omitNum = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '0') {
					omitNum++;
				} else {
					break;
				}
			}
			origStr = str.substring(omitNum, str.length());
		}
		return origStr;
	}

	//不足32位前面补 0
	public static String fillBeginWith0ForwaybillId(String str) {
		if (null != str && !"".equals(str)) {
			int len = str.length();
			for (int i = 0; i < WAYBILLID_LEN_20 - len; i++) {
				str = "0" + str;
			}
		}
		return str;
	}

	//判断是否是允许的字符串（过滤特殊字符）
	public static boolean isPermitChars(final String str) {
		boolean flag = true;
		if (isNotEmpty(str)) {
			String regex = "[` ~!#$%^&*()+=|{}':;',\\[\\]<>/?~！#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(str);
			if (m.find()) {
				flag = false;
			}
		}
		return flag;
	}

	public static boolean isNaN(final String obj) {
		if (isEmpty(obj)) {
			return false;
		} else {
			return Pattern.matches("^\\d{1,}+$", obj.toString());
		}
	}
}
