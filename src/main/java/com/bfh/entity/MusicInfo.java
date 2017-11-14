package com.bfh.entity;

import java.io.Serializable;

/**
 * @Author bfh
 * @Time 2017/11/13
 * @Description
 */
public class MusicInfo implements Serializable {

	private int id;
	private int mid;
	private String musicImage;
	private int clickRate;
	private int downloads;
	private int like;
	private int dislike;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMusicImage() {
		return musicImage;
	}

	public void setMusicImage(String musicImage) {
		this.musicImage = musicImage;
	}

	public int getClickRate() {
		return clickRate;
	}

	public void setClickRate(int clickRate) {
		this.clickRate = clickRate;
	}

	public int getDownloads() {
		return downloads;
	}

	public void setDownloads(int downloads) {
		this.downloads = downloads;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public int getDislike() {
		return dislike;
	}

	public void setDislike(int dislike) {
		this.dislike = dislike;
	}
}
