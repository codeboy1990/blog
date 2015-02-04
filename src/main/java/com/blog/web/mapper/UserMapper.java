/**
 * @filename UserMapper.java
 * @date 2015年1月24日
 * @author chdy
 */
package com.blog.web.mapper;

import java.util.List;

import com.blog.web.entity.Page;
import com.blog.web.entity.User;

/**
 * @author chdy
 * @date 2015年1月24日
 */
public interface UserMapper {

	/**
	 * 通过用户名查找用户
	 * @param userName 用户名
	 * @return 用户
	 */
	public User getUserByName(String userName);

	/**
	 * 查找用户列表
	 * @param page
	 * @return
	 */
	public List<User> getUserList(Page<User> page);
}
