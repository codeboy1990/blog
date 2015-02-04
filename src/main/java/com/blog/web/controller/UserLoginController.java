package com.blog.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.web.service.UserService;
import com.blog.common.consts.CommonConstant;
import com.blog.common.consts.UrlConfig;
import com.blog.web.entity.RespData;
import com.blog.web.entity.User;
import com.blog.web.interceptor.AjaxException;
import com.blog.web.service.UserService;


/**
 * @author chdy
 * @date 2015年1月28日
 */
@Controller
public class UserLoginController {

	@Autowired
	UserService userService;

	@RequestMapping(value = UrlConfig.Login.LOGIN_INDEX, method = RequestMethod.GET)
	public String index(HttpSession session, HttpServletRequest request) {

		if (session.getAttribute(CommonConstant.LOGIN_ADMIN_KEY) != null) {
			return "redirect:/";
		}
		System.out.println("用户通过："+request.getRemoteAddr()+"访问。method = "+request.getMethod());
		
		return "login/index";
	}

	@RequestMapping(value = UrlConfig.Login.LOGIN_INDEX, method = RequestMethod.POST)
	public @ResponseBody RespData login(String userName, String password,
			Model model, HttpSession session, HttpServletRequest request) {
		if (StringUtils.isBlank(userName)) {
			throw new AjaxException(10001);
		}
		if (StringUtils.isBlank(password)) {
			throw new AjaxException(10002);
		}
		System.out.println("用户尝试用"+userName+"登陆。method = "+request.getMethod());
		
//		boolean success = userService.userLogin(userName, password);
		User user = userService.userLogin(userName, password);
		if (user == null) {
			System.out.println("用户使用"+userName+"登陆失败。method = "+request.getMethod());
			throw new AjaxException(10003);
		}
		System.out.println("用户使用"+userName+"登陆成功。method = "+request.getMethod());
		session.setAttribute(CommonConstant.LOGIN_ADMIN_KEY, user);
		return new RespData();
	}

	@RequestMapping(UrlConfig.Login.LOGIN_LOGOUT)
	public String logout(HttpSession session) {
		session.removeAttribute(CommonConstant.LOGIN_ADMIN_KEY);
		return "redirect:" + UrlConfig.Login.LOGIN_INDEX;
	}

}
