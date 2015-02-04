/**
 * @filename BaseEntity.java
 * @date 2015年1月24日
 * @author chdy
 */
package com.blog.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础信息类
 * @author chdy
 * @date 2015年1月24日
 */
public class BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6123235533114513962L;

	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 修改时间
	 */
	private Date updateTime;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
