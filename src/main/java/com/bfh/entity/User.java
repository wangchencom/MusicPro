package com.bfh.entity;

/**
 * @Author bfh
 * @Time 2017/11/9
 * @Description: 用户实体类
 */
public class User {

	private int uid;
	private String email;
	private String userPassword;
	private String userName;
	private String userImage;
	private String userMood;
	private int userGrade;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

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

	public String getUserMood() {
		return userMood;
	}

	public void setUserMood(String userMood) {
		this.userMood = userMood;
	}

	public int getUserGrade() {
		return userGrade;
	}

	public void setUserGrade(int userGrade) {
		this.userGrade = userGrade;
	}
}