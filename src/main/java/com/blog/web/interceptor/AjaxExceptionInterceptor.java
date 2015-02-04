package com.blog.web.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Component
public class AjaxExceptionInterceptor implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {

		if (ex instanceof AjaxException) {
			AjaxException ajaxException = (AjaxException) ex;
			response.setStatus(ajaxException.getCode());
			try {
				response.flushBuffer();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			throw new RuntimeException(ex);
		}
		return null;
	}



}
