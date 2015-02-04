package com.blog.common.consts;


/**
 * 请求url地址配置类
 * 
 * @author chdy
 * @date 2015年1月18日
 */
public interface UrlConfig {
	
	// 用户请求类
	static final class User {
		public static final String GETUSER = "/user/getuser";
		public static final String LIST = "/user/list";
	}

	
	static final class Login{
		public static final String LOGIN_INDEX = "/login/index";
		public static final String LOGIN_LOGOUT = "/login/logout";
	}
}
