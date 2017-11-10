package com.bfh.vo;

/**
 * @Author bfh
 * @Time 2017/11/9
 * @Description
 */
public class RegisterVo {

	private String userName;
	private String email;
	private String first_password;
	private String second_password;
	private String checkbox;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst_password() {
		return first_password;
	}

	public void setFirst_password(String first_password) {
		this.first_password = first_password;
	}

	public String getSecond_password() {
		return second_password;
	}

	public void setSecond_password(String second_password) {
		this.second_password = second_password;
	}

	public String getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}
}
