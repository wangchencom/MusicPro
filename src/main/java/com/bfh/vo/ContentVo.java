package com.bfh.vo;

import com.bfh.entity.Content;

/**
 * @Author bfh
 * @Time 2017/11/16
 * @Description
 */
public class ContentVo extends Content {

	private String userName;
	private String userImage;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}
}
