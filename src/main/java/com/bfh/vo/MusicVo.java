package com.bfh.vo;

import java.io.Serializable;

/**
 * @Author wcc
 * @Time 2019/09/24
 * @Description MusicVo
 */
public class MusicVo implements Serializable {

    private int mid;
    private String musicName;
    private int like;
    private int dislike;


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
