package com.bfh.vo;

import java.io.Serializable;

/**
 * @Author bfh
 * @Time 2017/11/15
 * @Description MusicVo
 */
public class MusicVo implements Serializable{

	private String musicName;
	private int like;
	private int dislike;


	public String getMusicName() {
		return musicName;
	}

	public void setMusicName(String musicName) {
		this.musicName = musicName;
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
