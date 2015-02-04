/**
 * @filename UserService.java
 * @date 2015年1月24日
 * @author chdy
 */
package com.blog.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.blog.web.entity.User;
import com.blog.web.mapper.UserMapper;
import com.blog.web.entity.Page;

/**
 * 用户服务类
 * @author chdy
 * @date 2015年1月24日
 */
@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public User getUserByName(String userName){
		
		if (userName == null || userName.isEmpty()  ) {
			System.out.println("用户名为空。");
			return null;
		}
		User user = userMapper.getUserByName(userName);
		System.out.println("Nick Name = "+user.getNickName());
		return user;
	}

	/**
	 * 通过用户名和密码验证用户是否登录成功
	 * @param userName
	 * @param passWord
	 * @return 是否返回成功
	 */
	public User userLogin(String userName, String passWord){
		User user = userMapper.getUserByName(userName);
		String pd = user.getPassWord();
		if (pd.equals(passWord)) {
			return user;
		}
		return null;
	}
	public ModelAndView getUserList(Integer pageNo, Integer pageSize) {
		
		ModelAndView mav = new ModelAndView();
		
		Page<User> page = new Page<User>();
		if (pageNo != null) {
			page.setPageNo(pageNo);
		}
		if (pageSize != null) {
			page.setPageSize(pageSize);
		}
		
		//page.setResults(userList);
		System.out.println("page No=== "+page.getPageNo());
		System.out.println("page Size=== "+page.getPageSize());
		
		List<User> userList = userMapper.getUserList(page);
		mav.addObject("userList", userList);
		mav.addObject("pageNo", page.getPageNo());
		mav.addObject("totalPage", page.getTotalPage());
		mav.addObject("totalRecord", page.getTotalRecord());
		
		mav.setViewName("user/list");
		
		return mav;
	}
}
