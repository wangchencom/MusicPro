package com.bfh.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author bfh
 * @Time 2017/11/12
 * @Description 音乐实体类
 */
public class Music implements Serializable {

	private int mid;
	private String musicName;
	private String pathName;
	private int uploadUser;
	private Date uploadTime;

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMusicName() {
		return musicName;
	}

	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}

	public String getPathName() {
		return pathName;
	}

	public void setPathName(String pathName) {
		this.pathName = pathName;
	}

	public int getUploadUser() {
		return uploadUser;
	}

	public void setUploadUser(int uploadUser) {
		this.uploadUser = uploadUser;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
}
