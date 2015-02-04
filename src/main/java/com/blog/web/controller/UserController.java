/**
 * @filename UserController.java
 * @date 2015年1月24日
 * @author chdy
 */
package com.blog.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.blog.common.consts.UrlConfig;
import com.blog.web.entity.User;
import com.blog.web.service.UserService;


/**
 * @author chdy
 * @date 2015年1月24日
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = UrlConfig.User.GETUSER, method = RequestMethod.GET)
	public ModelAndView getUserByName(@RequestParam(value = "userName", required = false) String userName) {
		ModelAndView mav = new ModelAndView();
		
		String userName1 = "chdaly";
		User user = userService.getUserByName(userName);
		mav.addObject("User", user);
		mav.setViewName("user/getuser");
		return mav;
		
	}
	
	@RequestMapping(value = UrlConfig.User.GETUSER, method = RequestMethod.POST)
	public ModelAndView getUserByName2(@RequestParam(value = "userName", required = false) String userName) {
		ModelAndView mav = new ModelAndView();
		
		String userName1 = "chdaly";
		User user = userService.getUserByName(userName1);
		mav.addObject("User", user);
		mav.setViewName("getuser");
		return mav;
		
	}
	
	/**
	 * 获取用户列表
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = UrlConfig.User.LIST, method = RequestMethod.GET)
	public ModelAndView getUserList(@RequestParam(value = "pageNo", required = false) Integer pageNo, 
			@RequestParam(value = "pageSize", required = false) Integer pageSize) {
		
		return userService.getUserList(pageNo, pageSize);
	}
	
}
