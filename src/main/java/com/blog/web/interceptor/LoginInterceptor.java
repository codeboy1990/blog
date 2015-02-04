package com.blog.web.interceptor;

import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.blog.common.consts.CommonConstant;
import com.blog.common.consts.UrlConfig;

public class LoginInterceptor implements HandlerInterceptor {

	private List<String> excludes;

	public void setExcludes(List<String> excludes) {
		this.excludes = excludes;
	}

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String reqPath = request.getServletPath();
		for (String pathPattern : excludes) {
			if (Pattern.matches(pathPattern, reqPath)) {
				return true;
			}
		}
		Object loginAdminObj = request.getSession().getAttribute(CommonConstant.LOGIN_ADMIN_KEY);
		if (loginAdminObj == null) {
			if (isAjax(request)) {
				response.setStatus(403);
				response.flushBuffer();
			} else {
				response.sendRedirect(request.getSession().getServletContext().getContextPath() + UrlConfig.Login.LOGIN_INDEX);
			}
			return false;
		}
		return true;
	}

	private  boolean isAjax(HttpServletRequest request) {
		if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
			return true;
		}
		return false;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
