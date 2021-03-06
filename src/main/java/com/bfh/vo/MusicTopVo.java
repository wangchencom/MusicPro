package com.bfh.vo;

import java.io.Serializable;

/**
 * @Author wcc
 * @Time 2019/09/24
 * @Description MusicVo
 */
public class MusicTopVo implements Serializable {

    private int mid;
    private String musicName;
    private String musicImage;

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

    public String getMusicImage() {
        return musicImage;
    }

    public void setMusicImage(String musicImage) {
        this.musicImage = musicImage;
    }
}
