/**
 * @filename User.java
 * @date 2015年1月24日
 * @author chdy
 */
package com.blog.web.entity;


/**
 * 用户实体类
 * @author chdy
 * @date 2015年1月24日
 */
public class User extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 * 自增
	 */
	private Integer userId;
	
	/**
	 * 用户名
	 * 用于登录
	 */
	private String userName;
	
	/**
	 * 昵称
	 */
	private String nickName;
	
	/**
	 * 密码
	 */
	private String passWord;
	
	
	public User() {
	}
	public User(Integer userId, String userName, String nickName, String passWord) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.nickName = nickName;
		this.passWord = passWord;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
}
