package com.bfh.entity;

import java.io.Serializable;

/**
 * @Author bfh
 * @Time 2017/11/13
 * @Description 用户等级实体类
 */
public class UserGrade implements Serializable{

	private int gid;
	private int uid;
	private int grade;
	private int score;

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
