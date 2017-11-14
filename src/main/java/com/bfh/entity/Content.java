package com.bfh.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author bfh
 * @Time 2017/11/13
 * @Description
 */
public class Content implements Serializable {

	private int cid;
	private int uid;
	private String musicImage;
	private int mid;
	private String content;
	private Date contentTime;


	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getMusicImage() {
		return musicImage;
	}

	public void setMusicImage(String musicImage) {
		this.musicImage = musicImage;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getContentTime() {
		return contentTime;
	}

	public void setContentTime(Date contentTime) {
		this.contentTime = contentTime;
	}
}
